package com.example.zhangrui0113.testokhttp3;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
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
    static String TAG = "HttpUtils";
    static  OkHttpClient mOkHttpClient;
    String http = "http://123.56.155.17:8080/";
    String loginUrl = "xys/healthButler/login";
    static  MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    static String result;
    public static String getResultFromHttpPost(String jsonStr, String url){
        mOkHttpClient = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = null;
        try {
            response = mOkHttpClient.newCall(request).execute();
            Log.i(TAG, response.body().string());
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}
