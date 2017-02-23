package vn.asiantech.pah.shareds;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by Binc on 1/20/17.
 */
@SharedPref(SharedPref.Scope.UNIQUE)
public interface SharedPreferences {
    @DefaultBoolean(false)
    boolean keyLaucher();
}
