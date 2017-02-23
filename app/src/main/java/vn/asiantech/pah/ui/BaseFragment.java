package vn.asiantech.pah.ui;

import android.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Base Fragment.
 *
 * @author BiNC
 */
@EFragment
public abstract class BaseFragment extends Fragment {

    @AfterViews
    protected abstract void init();
}
