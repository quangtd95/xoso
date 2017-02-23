package vn.asiantech.pah.ui.account;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.pah.R;
import vn.asiantech.pah.listener.OnClickSpannableListener;
import vn.asiantech.pah.ui.BaseActivity;
import vn.asiantech.pah.ui.home.HomeActivity_;
import vn.asiantech.pah.util.SpannableUtil;
import vn.asiantech.pah.util.ValidateUtil;

/**
 * RegisterActivity.
 *
 * @author BiNC
 */
@EActivity(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements OnClickSpannableListener {
    private static final String TERM_OF_USE = "TERM_OF_USE";
    private static final String LOGIN = "LOGIN";
    @ViewById(R.id.tvTermOfUse)
    TextView mTvTermOfUse;
    @ViewById(R.id.edtMail)
    EditText mEdtMail;
    @ViewById(R.id.edtName)
    EditText mEdtName;
    @ViewById(R.id.edtPass)
    EditText mEdtPass;

    @Override
    protected void init() {
        initTextTermOfUse();
    }

    private void initTextTermOfUse() {
        String s = "Với việc nhấn vào nút đăng ký, bạn đã đồng ý với Điều Khoản Sử Dụng của chúng tôi";
        String tmp = "Điều Khoản Sử Dụng";
        mTvTermOfUse.setText(SpannableUtil.setTextSpannable(s, s.indexOf(tmp), s.indexOf(tmp) + tmp.length(), this, TERM_OF_USE));
    }

    @Override
    public void onClickSpannable(String tag) {
        if (TERM_OF_USE.equals(tag)) {
            //TODO
        }
    }

    @Click(R.id.tvLogin)
    void onClickLogin() {
        LoginActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP).start();
    }

    @Click(R.id.tvRegister)
    void onCLickRegister() {
        if (ValidateUtil.isValidName(mEdtName.getText().toString())) {
            showToast("Kiểm Tra Họ Và Tên");
        } else if (!ValidateUtil.isValidEmail(mEdtMail.getText().toString())) {
            showToast("Kiểm Tra Mail");
        } else if (!ValidateUtil.isValidPassword(mEdtPass.getText().toString())) {
            showToast("Kiểm Tra Mật Khẩu");
        } else {
            HomeActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK).start();
        }
    }
}
