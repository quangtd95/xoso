package vn.asiantech.pah.ui.statistic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import vn.asiantech.pah.R;

/**
 * HistoryAdapter.
 *
 * @author BiNC
 */

public class StatisticAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_statistic, parent, false);
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
        private final LinearLayout mLlDetail;

        public RegisterMedicineViewHolder(final View view) {
            super(view);
            mLlDetail = (LinearLayout) view.findViewById(R.id.llDetail);
            mLlDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // ((HomeActivity) view.getContext()).showDialogDetail();
                }
            });
        }
    }
}
