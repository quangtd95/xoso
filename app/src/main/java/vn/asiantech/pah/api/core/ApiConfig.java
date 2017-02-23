package vn.asiantech.pah.api.core;

import android.content.Context;

import lombok.Builder;
import lombok.Value;

/**
 * Api config.
 *
 * @author BiNC
 */
@Value
@Builder
public class ApiConfig {
    private Context context;
    private String baseUrl;
}
