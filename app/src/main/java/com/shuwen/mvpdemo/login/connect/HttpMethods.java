package com.shuwen.mvpdemo.login.connect;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ruanchao on 2017/12/13.
 */

public class HttpMethods {

    private volatile static HttpMethods mHttpMethods = null;
    private final static String TAG = HttpMethods.class.getSimpleName();
    private OkHttpClient okHttpClient;

    private HttpMethods(){
        okHttpClient = new OkHttpClient();
    }

    public synchronized static HttpMethods getInstance(){

        if (mHttpMethods == null){
            synchronized (HttpMethods.class){
                if (mHttpMethods == null){
                    mHttpMethods = new HttpMethods();
                }
            }
        }
        return mHttpMethods;
    }

    public void post(String url, Map<String,String> map, Callback callback){
        MediaType mediaType = MediaType.parse("application/json");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(mediaType,jsonObject.toString());
        Request request = new Request
                .Builder()
                .post(requestBody)
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }


}
