package io.github.mfaisalkhatri.web.testdata;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterUser {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
