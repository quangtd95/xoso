package vn.asiantech.pah.ui.by;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.seismic.ShakeDetector;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.pah.R;
import vn.asiantech.pah.model.Buy;
import vn.asiantech.pah.ui.BaseFragment;

/**
 * BuyFragment.
 *
 * @author BiNC
 */
@EFragment(R.layout.fragment_buy)
public class BuyFragment extends BaseFragment implements BuyAdapter.BuyListener {
    @ViewById(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @ViewById(R.id.llContainBuy)
    LinearLayout mLlContainBuy;
    private BuyAdapter mBuyAdapter;
    @SystemService
    SensorManager mSensorManager;
    private ShakeDetector mShakeDetector;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mShakeDetector = new ShakeDetector(new ShakeDetector.Listener() {
            @Override
            public void hearShake() {
                mBuyAdapter.randomFromShack();
            }
        });
    }

    @Override
    protected void init() {
        initRecyclerView();
        startDetect();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopDetect();
    }

    /**
     * start shake detect
     */
    public void startDetect() {
        if (null != mShakeDetector && null != mSensorManager) {
            mShakeDetector.start(mSensorManager);
        }
    }

    /**
     * stop shake detect
     */
    public void stopDetect() {
        if (null != mShakeDetector) {
            mShakeDetector.stop();
        }
    }

    private void initRecyclerView() {
        mBuyAdapter = new BuyAdapter(initData());
        mBuyAdapter.setMBuyListener(this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));
        mRecyclerView.setAdapter(mBuyAdapter);
    }

    private List<Buy> initData() {
        List<Buy> buys = new ArrayList<>();
        for (int i = 0; i < 75; i++) {
            buys.add(new Buy(i < 10 ? String.format("0%d", i) : String.valueOf(i), false));
        }
        return buys;
    }

    @Override
    public void onBuy() {
        mLlContainBuy.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNoBuy() {
        mLlContainBuy.setVisibility(View.GONE);
    }

    @Click(R.id.tvReset)
    void onReset() {
        mBuyAdapter.resetNumber();
    }

    @Click(R.id.tvRandom)
    void onRandom() {
        mBuyAdapter.randomNumber();
    }
}
