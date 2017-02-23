package vn.asiantech.pah.api.core;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Api Callback.
 *
 * @param <T> object call back
 * @author BiNC
 */

public abstract class ApiCallback<T> implements Callback<T> {

    public abstract void success(T t);

    public abstract void failure(Error myError);

    public ApiCallback() {
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        success(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        failure(new Error(t.getMessage()));
    }
}
