package vn.asiantech.pah.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import vn.asiantech.pah.R;

/**
 * Base Activity.
 *
 * @author BiNC
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity {

    @AfterViews
    protected abstract void init();

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.replace(R.id.flContain, fragment, fragment.getClass().getSimpleName());
        if (!isFinishing()) {
            ft.commit();
        }
        fm.executePendingTransactions();
    }

    protected void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
