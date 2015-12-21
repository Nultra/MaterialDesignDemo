package me.appa.materialdesign.utils;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by niuxm on 2015/12/7.
 */
public class OkHttpUtil {
    private static final OkHttpClient mOkHTTPClient = new OkHttpClient();
    private static final String CHARSET_NAME = "UTF-8";

    static {
        mOkHTTPClient.setConnectTimeout(30, TimeUnit.SECONDS);
    }

    /**
     * 不会开启异步线程
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Response execute(Request request) throws IOException {
        return mOkHTTPClient.newCall(request).execute();
    }

    /**
     * 开启异步线程
     *
     * @param request
     * @param responsCallback
     */
    public static void enqueue(Request request, Callback responsCallback) {
        mOkHTTPClient.newCall(request).enqueue(responsCallback);
    }

    /**
     * 开启异步线程，并且不在意返回结果(实现为空Callback)
     *
     * @param request
     */
    public static void enqueue(Request request) {
        mOkHTTPClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }

    public static String getStringFromServer(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected Code " + response);
        }


    }

}
