package vn.asiantech.pah.ui.home;

import android.content.Context;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewsById;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import lombok.Setter;
import vn.asiantech.pah.R;

/**
 * CustomTabHome.
 *
 * @author BiNC
 */
@EViewGroup(R.layout.custom_tab_home)
public class CustomTabHome extends LinearLayout {
    /**
     * Interface define annotation select fragment and tab.
     */
    @IntDef({HomeStatus.RESULT, HomeStatus.HISTORY, HomeStatus.BY, HomeStatus.STATISTIC, HomeStatus.SETTING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HomeStatus {
        int RESULT = 0;
        int HISTORY = 1;
        int BY = 2;
        int STATISTIC = 3;
        int SETTING = 4;
    }

    @Setter
    private HomeListener homeListener;
    @ViewsById({R.id.tvResult, R.id.tvHistory, R.id.tvBy, R.id.tvStatistic, R.id.tvSetting})
    List<TextView> mTabHomes;

    public CustomTabHome(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);
    }

    @AfterViews
    void init() {
    }

    @Click(R.id.tvResult)
    void clickHome() {
        updateTab(HomeStatus.RESULT);
    }

    @Click(R.id.tvHistory)
    void clickMedicineRecord() {
        updateTab(HomeStatus.HISTORY);
    }

    @Click(R.id.tvSetting)
    void clickMenu() {
        updateTab(HomeStatus.SETTING);
    }

    @Click(R.id.tvBy)
    void clickSymptom() {
        updateTab(HomeStatus.BY);
    }

    @Click(R.id.tvStatistic)
    void clickRetrospective() {
        updateTab(HomeStatus.STATISTIC);
    }

    public void updateTab(@HomeStatus int status) {
        if (status < 0 || status >= mTabHomes.size()) {
            return;
        }
        /*change background tab*/
        for (TextView tv : mTabHomes) {
            tv.setSelected(false);
        }
        mTabHomes.get(status).setSelected(true);
        /*change show fragment*/
        if (homeListener == null) {
            return;
        }
        homeListener.setTextHeader(status);
        switch (status) {
            case HomeStatus.RESULT:
                homeListener.showResultFragment();
                break;
            case HomeStatus.HISTORY:
                homeListener.showHistoryFragment();
                break;
            case HomeStatus.BY:
                homeListener.showByFragment();
                break;
            case HomeStatus.STATISTIC:
                homeListener.showStatisticFragment();
                break;
            case HomeStatus.SETTING:
                homeListener.showSettingFragment();
                break;
        }
    }
}
