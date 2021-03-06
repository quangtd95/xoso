package vn.asiantech.pah.api.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.asiantech.pah.api.ApiService;

/**
 * Api Service client.
 *
 * @author BiNC
 */
public class ApiClient {
    private static final String HEADER_UA = "User-Agent";
    private static final String TAG = "ApiClient";

    private static final int TIMEOUT_CONNECTION = 10000;

    private static ApiClient sApiClient;
    private static Context sContext;
    /**
     * ApiService service
     */
    private ApiService mApiService;

    public static synchronized ApiClient getInstance() {
        if (sApiClient == null) {
            sApiClient = new ApiClient();
        }
        return sApiClient;
    }

    /**
     * method this is request api
     */
    public static ApiService call() {
        return getInstance().mApiService;
    }

    public static HeaderStore getHeader() {
        return HeaderStore.getInstance(sContext);
    }

    public void init(final ApiConfig apiConfig) {
        sContext = apiConfig.getContext();
        // initialize OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                Map<String, String> headers = HeaderStore.getInstance(apiConfig.getContext()).getHeader();
                if (headers != null && headers.size() > 0) {
                    for (Map.Entry<String, String> entry : headers.entrySet()) {
                        builder.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                builder.addHeader(HEADER_UA, createUserAgent());
                return chain.proceed(builder.build());
            }
        });
        builder.readTimeout(TIMEOUT_CONNECTION, TimeUnit.MILLISECONDS);
        builder.writeTimeout(TIMEOUT_CONNECTION, TimeUnit.MILLISECONDS);
        OkHttpClient okHttpClient = builder.build();

        // Gson rules
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(apiConfig.getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    private String createUserAgent() {
        PackageManager pm = sContext.getPackageManager();
        String versionName = "";
        try {
            PackageInfo packageInfo = pm.getPackageInfo(sContext.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return String.format(Locale.JAPANESE, "%s %s/%s", System.getProperty("http.agent"), sContext.getPackageName(), versionName);
    }
}
