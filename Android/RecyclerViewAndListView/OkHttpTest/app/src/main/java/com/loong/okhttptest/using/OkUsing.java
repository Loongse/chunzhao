package com.loong.okhttptest.using;

import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//如何使用okhttp
public class OkUsing {
    //使用同步获取请求方式
    public void execUsing(String url){
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url)
                .get().build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
    public void baseUsing(String url) {
        //基本使用：new OkHttpClient
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    //使用内部工程类Builder来设置OkHttpClient
    public void buildUsing(String url, Interceptor interceptor, Proxy proxy, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS)//设置超时
                .addInterceptor(interceptor)//添加拦截器
                .proxy(proxy)//添加代理
                .cache(cache);//设置缓存策略
        OkHttpClient client = builder.build();
        //请求操作的起点从newCall().enqueue()方法开始
        Request request = new Request.Builder()
                .url(url)
                .build();
        //newCall：返回一个RealCall对象，通过他将网络请求添加到请求队列里面
        //enqueue会调用dispatcher的入队方法，执行一个异步网络的请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
    //请求最终通过dispatcher的enqueue内部方法实现
    /**
     * dispatcher是OkHttpClient的调度器，是一种门户模式（外观模式）。
     * 主要用来实现执行、取消异步等请求操作
     * 本质上维护了一个线程池去执行异步请求，并且在dispatcher内部根据一定的策略，保证最大并发个数
     * 同一个host主机允许执行请求的线程个数等。。、
     *
     * 入队中如果满足小于最大并发个数并且小于一个host主机的最大线程，添加并执行
     * 否则只添加入队不执行。
     */


    //最终是执行AsyncCall 的excute方法，该方法的首先会调用拦截器链获取response：
    /**
     * BridgeInterceptor：主要对 Request 中的 Head 设置默认值，比如 Content-Type、Keep-Alive、Cookie 等。
     * CacheInterceptor：负责 HTTP 请求的缓存处理。
     * ConnectInterceptor：负责建立与服务器地址之间的连接，也就是 TCP 链接。
     * CallServerInterceptor：负责向服务器发送请求，并从服务器拿到远端数据结果。
     */
}
