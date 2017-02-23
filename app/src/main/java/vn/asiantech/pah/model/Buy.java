package vn.asiantech.pah.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Buy.
 *
 * @author BiNC
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class Buy {
    private String number;
    private boolean isCheck;
}
