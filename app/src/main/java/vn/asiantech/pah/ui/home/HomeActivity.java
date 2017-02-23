package vn.asiantech.pah.ui.home;

import android.widget.TextView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import lombok.Getter;
import lombok.experimental.Accessors;
import vn.asiantech.pah.R;
import vn.asiantech.pah.ui.BaseActivity;
import vn.asiantech.pah.ui.BaseDialog;
import vn.asiantech.pah.ui.by.BuyFragment_;
import vn.asiantech.pah.ui.dialog.DetailDialog_;
import vn.asiantech.pah.ui.history.HistoryFragment_;
import vn.asiantech.pah.ui.result.ResultFragment_;
import vn.asiantech.pah.ui.setting.SettingFragment_;
import vn.asiantech.pah.ui.statistic.StatisticFragment_;

/**
 * RegisterActivity.
 *
 * @author BiNC
 */
@EActivity(R.layout.activity_home)
public class HomeActivity extends BaseActivity implements HomeListener {
    private static final String[] HEADER = {"KẾT QUẢ", "LỊCH SỬ", "MUA VÉ", "THỐNG KÊ", "CÀI ĐẶT"};
    @Getter
    @Accessors(prefix = "m")
    @ViewById(R.id.customTabHome)
    CustomTabHome mCustomTabHome;
    @ViewById(R.id.tvHeader)
    TextView mTvHeader;

    @Override
    protected void init() {
        mCustomTabHome.setHomeListener(this);
        mCustomTabHome.updateTab(CustomTabHome.HomeStatus.RESULT);
    }

    @Override
    public void showResultFragment() {
        replaceFragment(ResultFragment_.builder().build(), false);
    }

    @Override
    public void showHistoryFragment() {
        replaceFragment(HistoryFragment_.builder().build(), false);
    }

    @Override
    public void showSettingFragment() {
        replaceFragment(SettingFragment_.builder().build(), false);
    }

    @Override
    public void showByFragment() {
        replaceFragment(BuyFragment_.builder().build(), false);
    }

    @Override
    public void showStatisticFragment() {
        replaceFragment(StatisticFragment_.builder().build(), false);
    }

    @Override
    public void setTextHeader(@CustomTabHome.HomeStatus int status) {
        mTvHeader.setText(HEADER[status]);
    }

    public void showDialogDetail() {
        BaseDialog baseDialog = DetailDialog_.builder().build();
        baseDialog.show(getFragmentManager(), null);
    }
}
