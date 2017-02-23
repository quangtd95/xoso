package vn.asiantech.pah.model;

import android.os.Parcelable;

/**
 * Base Model.
 *
 * @author TriNT
 */
public abstract class BaseModel implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }
}
