package com.example.zhangrui0113.testokhttp3;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zhangrui0113 on 2017/5/7.
 */

public class HttpUtils {
    static  OkHttpClient mOkHttpClient;
    String http = "http://123.56.155.17:8080/";
    String loginUrl = "xys/healthButler/login";
    static  MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    public static String getResultFromHttpPost(String jsonStr, String url){
        mOkHttpClient = new OkHttpClient();
        String result= null;
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
}
