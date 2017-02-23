package vn.asiantech.pah;

import android.app.Application;

import vn.asiantech.pah.api.core.ApiClient;
import vn.asiantech.pah.api.core.ApiConfig;

/**
 * Base App
 *
 * @author TriNT
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // retrofit
        createService();
    }

    private void createService() {
        ApiConfig apiConfig = ApiConfig.builder().context(getApplicationContext())
                .baseUrl(getString(R.string.url_host))
                .build();
        ApiClient.getInstance().init(apiConfig);
    }
}
