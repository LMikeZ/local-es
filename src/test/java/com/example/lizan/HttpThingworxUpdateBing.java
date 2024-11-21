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
public class HttpThingworxUpdateBing {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test() throws IOException {
        OkHttpClient client = null;
        // 机器基础编码(基本不需要修改)
        int baseNum = 1000;
        // 开始设备编号
        int startMachineNum = 14;
        // 设备总台数
        int totalMachineNum = 35;
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
            //http://10.17.6.65:8080/Thingworx/Things/TS.ELEC.BoronDiffusionMain1007.TubeID4.TH/Services/RestartThing?ts=1732171836985
            // 设置请求 URL 和方法
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host("10.17.6.65")
                    .port(8080)
                    .addPathSegments("Thingworx/Things/TS.ELEC.PepolyMain" + machineIdStr + ".RT/Properties/*")
                    .addQueryParameter("Accept", "application/json")
                    .addQueryParameter("Content-Type", "application/json")
                    .build();
            // 构建参数
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("IndustrialThing", "TS.ELEC.KEP05.IC");
            RequestBody requestBody = RequestBody.create(JSON, jsonObject.toJSONString());
            // 创建请求对象
            Request request = new Request
                    .Builder()
                    .url(url)
                    .put(requestBody)
                    .addHeader("cookie", "JSESSIONID=65FE5E9381C89C87346B97E743592145")
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
