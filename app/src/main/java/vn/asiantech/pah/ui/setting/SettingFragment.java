package vn.asiantech.pah.ui.setting;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import vn.asiantech.pah.R;
import vn.asiantech.pah.ui.BaseFragment;
import vn.asiantech.pah.ui.account.LoginActivity_;
import vn.asiantech.pah.ui.home.CustomTabHome;
import vn.asiantech.pah.ui.home.HomeActivity;

/**
 * SettingFragment.
 *
 * @author BiNC
 */
@EFragment(R.layout.fragment_setting)
public class SettingFragment extends BaseFragment {
    @Override
    protected void init() {
    }

    @Click(R.id.llContainLogout)
    void onCLickLogout() {
        LoginActivity_.intent(getActivity()).start();
        getActivity().finish();
    }

    @Click(R.id.llContainHistoryBuy)
    void onCLickHistoryBuy() {
        ((HomeActivity) getActivity()).getCustomTabHome().updateTab(CustomTabHome.HomeStatus.HISTORY);
    }
}
