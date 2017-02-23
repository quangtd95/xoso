package vn.asiantech.pah.ui.account;

import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

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
@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements OnClickSpannableListener {
    private static final String FORGET_PASS = "FORGET_PASS";
    private static final String REGISTER = "REGISTER";
    @ViewById(R.id.tvForgetPass)
    TextView mTvForgetPass;
    @ViewById(R.id.tvRegister)
    TextView mTvRegister;
    @ViewById(R.id.edtMail)
    EditText mEdtMail;
    @ViewById(R.id.edtPass)
    EditText mEdtPass;

    @Override
    protected void init() {
        initTextForgetPass();
        initTextRegister();
    }

    private void initTextForgetPass() {
        String s = "Quên mật khẩu ? Nhấn vào đây!";
        String tmp = "Nhấn vào đây!";
        mTvForgetPass.setText(SpannableUtil.setTextSpannable(s, s.indexOf(tmp), s.indexOf(tmp) + tmp.length(), this, FORGET_PASS));
        mTvForgetPass.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initTextRegister() {
        String s = "Chưa có tài khoản?\nTạo tài khoản mới !";
        String tmp = "Tạo tài khoản mới !";
        mTvRegister.setText(SpannableUtil.setTextSpannable(s, s.indexOf(tmp), s.indexOf(tmp) + tmp.length(), this, REGISTER));
        mTvRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onClickSpannable(String tag) {
        if (FORGET_PASS.equals(tag)) {
            //TODO
        } else if (REGISTER.equals(tag)) {
            RegisterActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP).start();
        }
    }

    @Click(R.id.tvLogin)
    void onClickLogin() {
        if (!ValidateUtil.isValidEmail(mEdtMail.getText().toString())) {
            showToast("Kiểm Tra Mail");
        } else if (!ValidateUtil.isValidPassword(mEdtPass.getText().toString())) {
            showToast("Kiểm Tra Mật Khẩu");
        } else {
            HomeActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK).start();
        }
    }
}
