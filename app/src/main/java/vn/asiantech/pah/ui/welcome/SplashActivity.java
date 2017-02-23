package vn.asiantech.pah.ui.welcome;

import android.os.Handler;

import org.androidannotations.annotations.EActivity;

import vn.asiantech.pah.R;
import vn.asiantech.pah.ui.BaseActivity;
import vn.asiantech.pah.ui.account.RegisterActivity_;

/**
 * Splash Screen Activity.
 *
 * @author TriNT
 */
@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    private static final int TIME_DELAYED = 2000; // 2s

    private Handler mHandler;
    private final Runnable mActivityStarter = new Runnable() {
        @Override
        public void run() {
            RegisterActivity_.intent(SplashActivity.this).start();
        }
    };

    @Override
    protected void init() {
        mHandler = new Handler();
        mHandler.postDelayed(mActivityStarter, TIME_DELAYED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mActivityStarter);
        mHandler = null;
    }
}
