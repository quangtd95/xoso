package vn.asiantech.pah.ui.statistic;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.pah.R;
import vn.asiantech.pah.ui.BaseFragment;

/**
 * StatisticFragment.
 *
 * @author BiNC
 */
@EFragment(R.layout.fragment_statistic)
public class StatisticFragment extends BaseFragment {
    @ViewById(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private StatisticAdapter mStatisticAdapter;

    @Override
    protected void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        mStatisticAdapter = new StatisticAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mStatisticAdapter);
    }
}
