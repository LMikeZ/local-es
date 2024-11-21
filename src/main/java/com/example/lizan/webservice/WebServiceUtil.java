package com.example.lizan.webservice;

import com.alibaba.fastjson.JSON;
import com.example.lizan.webservice.ThirdResponseResult;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lizan
 * @version $Id: WebServiceUtil.java, v 0.1 2024年10月17日 14:53 lizan Exp $$
 */
public class WebServiceUtil {
    private static OkHttpClient client;
    private final static Map<String, List<Cookie>> cookieStore = new HashMap<>();

    public static ThirdResponseResult call(String url, Map<String, Object> paramMap) {
        try {
            Response response = eApi(url, JSON.toJSONString(paramMap));
            return parseXmlResponse(response.body().string());
            // ThirdResponseResult result = new ThirdResponseResult();
            // result.setOrderNo("0001550298");
            // result.setStatus("OK");
            // result.setSn("00003.0.01.30.000010LP2780004");
            // return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public static ThirdResponseResult parseXmlResponse(String xml) {

        ThirdResponseResult thirdResponseResult = new ThirdResponseResult();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // 启用命名空间支持
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(xml));
            Document document = builder.parse(inputSource);
            document.getDocumentElement().normalize();
            // 使用命名空间前缀解析 STATUS 元素
            String namespaceURI = "http://tempuri.org/";
            NodeList statusNodes = document.getElementsByTagNameNS(namespaceURI, "STATUS");
            if (statusNodes.getLength() > 0) {
                String status = statusNodes.item(0).getTextContent();
                thirdResponseResult.setStatus(status);
                if (StringUtils.equals(status, "OK")) {
                    NodeList snNodes = document.getElementsByTagNameNS(namespaceURI, "SN");
                    if (snNodes.getLength() > 0) {
                        String sn = snNodes.item(0).getTextContent();
                        thirdResponseResult.setSn(sn);
                    }
                } else {
                    NodeList errormsgNodes = document.getElementsByTagNameNS(namespaceURI, "ERRORMSG");
                    if (errormsgNodes.getLength() > 0) {
                        String errorMsg = errormsgNodes.item(0).getTextContent();
                        thirdResponseResult.setErrorMsg(errorMsg);
                    }
                }
            }
            return thirdResponseResult;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Response eApi(String url, String params) throws IOException {
        OkHttpClient client = getClient();
        RequestBody body = new FormBody.Builder()
                .add("Json", params)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return client.newCall(request).execute();
    }

    public static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient()
                    .newBuilder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(2, TimeUnit.MINUTES)
                    .writeTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(2, TimeUnit.MINUTES)          // 其他入库接口,读取超时
                    .cookieJar(new CookieJar() {
                        @Override
                        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                            cookieStore.put(httpUrl.host(), list);
                        }

                        @Override
                        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                            List<Cookie> cookies = cookieStore.get(httpUrl.host());
                            return cookies != null ? cookies : new ArrayList<>();
                        }
                    })   // 为OkHttp设置自动携带Cookie的功能
                    .build();
        }
        return client;
    }

}
