package vn.asiantech.pah.ui.history;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lombok.Setter;
import vn.asiantech.pah.R;
import vn.asiantech.pah.ui.home.HomeActivity;

/**
 * HistoryAdapter.
 *
 * @author BiNC
 */

public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * this interface listener click textview edit
     */
    public interface OnClickDetailHistory {
        void onClickDetailHistory();
    }

    @Setter
    private OnClickDetailHistory onClickDetailHistory;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_history, parent, false);
        return new RegisterMedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        //TODO
        return 40;
    }

    /**
     * viewHolder for register medicine
     */
    private class RegisterMedicineViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvDetail;

        public RegisterMedicineViewHolder(final View view) {
            super(view);
            mTvDetail = (TextView) view.findViewById(R.id.tvDetail);
            mTvDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((HomeActivity) view.getContext()).showDialogDetail();
                }
            });
        }
    }
}
