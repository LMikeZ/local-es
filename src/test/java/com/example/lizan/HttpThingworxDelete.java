package com.example.lizan;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author lizan
 * @version $Id: HttpThingworx.java, v 0.1 2024年08月29日 11:38 lizan Exp $$
 */
public class HttpThingworxDelete {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test() throws IOException {
        OkHttpClient client = null;
        // 机器基础编码(基本不需要修改)
        int baseNum = 1000;
        // 开始设备编号
        int startMachineNum = 18;
        // 设备总台数
        int totalMachineNum = 34;
        // *** 事物方法(重要参数)
        String method = "addRT";
        JSONArray resultList = new JSONArray();
        for (int i = startMachineNum; i <= totalMachineNum; i++) {
            // 基础编码加台数组成机器id
            // 创建 OkHttpClient 实例
            if (Objects.isNull(client)) {
                client = new OkHttpClient().newBuilder()
                        // 超时时间
                        .readTimeout(120, TimeUnit.SECONDS)
                        .build();
            }
            String machineIdStr = "";
            if (i < 10) {
                machineIdStr = "100" + i;
            } else {
                machineIdStr = "10" + i;
            }
            // 设置请求 URL 和方法
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host("10.17.3.99")
                    .port(8080)
                    .addPathSegments("Thingworx/Things/TS.ELEC.FurnaceMain" + machineIdStr + "A.TH/Services" + "/" + method)
                    .addQueryParameter("ts", String.valueOf(System.currentTimeMillis()))
                    .build();

            // 构建参数
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            JSONObject jsonObject = new JSONObject();
            RequestBody requestBody = RequestBody.create(JSON, jsonObject.toJSONString());
            // 创建请求对象
            Request request = new Request
                    .Builder()
                    .url(url)
                    .post(requestBody)
                    .addHeader("cookie", "JSESSIONID=B83D3B2700A9157C7DA90AB583004599")
                    .addHeader("accept", "application/json")
                    .build();
            // 发送请求,出现异常中断程序
            long startTime = System.currentTimeMillis();
            Response response = client.newCall(request).execute();
            long endTime = System.currentTimeMillis();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String reponseStr = new String(response.body().bytes(), StandardCharsets.UTF_8);
            System.out.println("执行位置:" + jsonObject.toString());
            System.out.println(StrUtil.format("{} 执行成功,花费{}毫秒" + "\n" + "返回数据为: {}", url, endTime - startTime, reponseStr));
            // 打印响应体
            JSONObject result = new JSONObject();
            result.put(machineIdStr, response.isSuccessful());
            resultList.add(result);

        }
        System.out.println(resultList.toJSONString());
    }

}
