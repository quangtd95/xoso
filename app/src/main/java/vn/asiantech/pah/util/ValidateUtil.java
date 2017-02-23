package vn.asiantech.pah.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by BiNC on 19/01/2017.
 */

public final class ValidateUtil {
    private ValidateUtil() {
        //no-op
    }

    /**
     * This method is used to validate an email.
     *
     * @param email email
     * @return true if email is valid
     */
    public static boolean isValidName(String email) {
        return TextUtils.isEmpty(email);
    }
    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    /**
     * This method is used to validate an phone.
     *
     * @param phone phone
     * @return true if phone is valid
     */
    public static boolean isValidPhoneNumber(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }

    /**
     * This method is used to validate password.
     *
     * @param password password
     * @return true if correct format
     */
    public static boolean isValidPassword(String password) {
        String passwordPattern = "[A-Za-z0-9@-_.#~]+";
        Pattern pattern = Pattern.compile(passwordPattern);
        return pattern.matcher(password).matches();
    }

    public static String validEmailAndPassword(Context context, String email, String password) {
        String error = "";
       /* if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            error = context.getString(R.string.fragment_login_error_input_character);
        } else if (email.length() > 255) {
            error = context.getString(R.string.fragment_login_error_email_greater_character);
        } else if (!(isValidEmail(email) || isValidPhoneNumber(email))) {
            error = context.getString(R.string.fragment_login_error_email_or_phone_number_incorect);
        } else if (password.length() < 8 || password.length() > 32) {
            error = context.getString(R.string.fragment_login_error_password_character);
        }*/
        return error;
    }
}
