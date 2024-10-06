package io.github.mfaisalkhatri.web.testdata;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LoginData {

    private String username;
    private String password;
    private boolean isValid;
    private boolean isEnabled;

}
