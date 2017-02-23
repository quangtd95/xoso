package vn.asiantech.pah.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Base Dialog
 *
 * @author Ync.
 */
@EFragment
public abstract class BaseDialog extends DialogFragment {
    @AfterViews
    protected abstract void init();

    @Override
    public void onResume() {
        super.onResume();
        /**
         * Set width & height of dialog on onResume method follow this
         * http://stackoverflow.com/questions/14946887/setting-the-size-of-a-dialogfragment
         */
       // int width = getResources().getDimensionPixelSize(R.dimen.dialog_width);
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width =  LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = LinearLayout.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes(params);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }
}
