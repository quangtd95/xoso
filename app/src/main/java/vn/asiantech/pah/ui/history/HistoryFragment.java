package vn.asiantech.pah.ui.history;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.pah.R;
import vn.asiantech.pah.ui.BaseFragment;

/**
 * HistoryFragment.
 *
 * @author BiNC
 */
@EFragment(R.layout.fragment_history)
public class HistoryFragment extends BaseFragment {
    @ViewById(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private HistoryAdapter mHistoryAdapter;

    @Override
    protected void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        mHistoryAdapter = new HistoryAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mHistoryAdapter);
    }
}
