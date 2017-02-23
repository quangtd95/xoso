package vn.asiantech.pah.ui.by;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import lombok.Setter;
import vn.asiantech.pah.R;
import vn.asiantech.pah.model.Buy;

/**
 * HistoryAdapter.
 *
 * @author BiNC
 */

public class BuyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int MAX_INDEX = 5;
    private List<Buy> mBuys;
    private int mIndex;
    @Setter
    private BuyListener mBuyListener;

    /**
     * interface buy
     */
    public interface BuyListener {
        void onBuy();

        void onNoBuy();
    }

    public BuyAdapter(List<Buy> buys) {
        mBuys = buys;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_buy, parent, false);
        return new BuyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Buy buy = mBuys.get(position);
        BuyViewHolder buyViewHolder = (BuyViewHolder) holder;
        buyViewHolder.mTvNumber.setText(buy.getNumber());
        if (buy.isCheck()) {
            buyViewHolder.mTvNumber.setBackgroundResource(R.drawable.ic_buy_text_select);
            buyViewHolder.mTvNumber.setTextColor(Color.parseColor("#4A4A4A"));
        } else {
            buyViewHolder.mTvNumber.setTextColor(Color.WHITE);
            buyViewHolder.mTvNumber.setBackgroundResource(R.drawable.ic_text_buy);
        }
    }

    @Override
    public int getItemCount() {
        return mBuys.size();
    }

    public void resetNumber() {
        for (Buy buy : mBuys) {
            buy.setCheck(false);
        }
        mIndex = 0;
        notifyDataSetChanged();
        mBuyListener.onNoBuy();
    }

    public void randomNumber() {
        resetNumber();
        Random random = new Random();
        for (int i = 0; i < MAX_INDEX; ) {
            int tmp = random.nextInt(75);
            if (!mBuys.get(tmp).isCheck()) {
                i++;
                mBuys.get(tmp).setCheck(true);
                mIndex++;
            }
        }
        notifyDataSetChanged();
        mBuyListener.onBuy();
    }

    public void randomFromShack() {
        if (mIndex < MAX_INDEX) {
            Random random = new Random();
            while (true) {
                int tmp = random.nextInt(75);
                if (!mBuys.get(tmp).isCheck()) {
                    mBuys.get(tmp).setCheck(true);
                    mIndex++;
                    if(mIndex==MAX_INDEX){
                        mBuyListener.onBuy();
                    }
                    notifyDataSetChanged();
                    break;
                }
            }
        }
    }

    /**
     * viewHolder for register medicine
     */
    private class BuyViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvNumber;

        public BuyViewHolder(View view) {
            super(view);
            mTvNumber = (TextView) view.findViewById(R.id.tvNumber);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() >= 0 && getAdapterPosition() < mBuys.size()) {
                        mBuys.get(getAdapterPosition()).setCheck(!mBuys.get(getAdapterPosition()).isCheck());
                        if (mBuys.get(getAdapterPosition()).isCheck()) {
                            mIndex++;
                        } else {
                            mIndex--;
                        }
                        if (MAX_INDEX <= mIndex && mBuyListener != null) {
                            if (MAX_INDEX == mIndex) {
                                mBuyListener.onBuy();
                            } else {
                                mBuyListener.onNoBuy();
                            }
                        }
                        if (MAX_INDEX + 1 == mIndex) {
                            mBuys.get(getAdapterPosition()).setCheck(false);
                            mIndex--;
                            mBuyListener.onBuy();
                        } else {
                            notifyDataSetChanged();
                        }
                    }
                }
            });
        }
    }
}
