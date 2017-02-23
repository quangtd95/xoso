package vn.asiantech.pah.ui.dialog;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import vn.asiantech.pah.R;
import vn.asiantech.pah.ui.BaseDialog;

/**
 * DetailDialog.
 *
 * @author BiNC
 */
@EFragment(R.layout.dialog_detail)
public class DetailDialog extends BaseDialog {
    @Override
    protected void init() {

    }

    @Click(R.id.tvHistory)
    void onClickHistory() {
        dismiss();
    }
}
