package vn.asiantech.pah.ui.home;

/**
 * Home Listener.
 *
 * @author BiNC
 */
public interface HomeListener {
    void showResultFragment();

    void showHistoryFragment();

    void showSettingFragment();

    void showByFragment();

    void showStatisticFragment();

    void setTextHeader(@CustomTabHome.HomeStatus int status);
}
