package com.shuwen.mvpdemo.login2.connect;

import com.shuwen.mvpdemo.login2.ConstantValue;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    public static HttpClient mHttpClient;
    public ApiService apiService;
    public static Retrofit mRetrofit;

    private HttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (ConstantValue.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }
        OkHttpClient okHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ConstantValue.API_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static HttpClient getInstance(){
        if (mHttpClient == null){
            synchronized (HttpClient.class){
                if (mHttpClient == null){
                    mHttpClient = new HttpClient();
                }
            }
        }
        return mHttpClient;
    }

    public ApiService getApiService(){
        if (apiService == null) {
            apiService = mRetrofit.create(ApiService.class);
        }
        return apiService;
    }

}
