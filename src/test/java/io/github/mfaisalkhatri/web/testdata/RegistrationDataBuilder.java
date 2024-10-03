package io.github.mfaisalkhatri.web.testdata;

import net.datafaker.Faker;

public class RegistrationDataBuilder {

    private static final Faker FAKER = new Faker();

    public static RegisterUser getRegistrationData() {
        return RegisterUser.builder().firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .email(FAKER.internet().emailAddress())
                .phoneNumber(FAKER.phoneNumber().phoneNumber())
                .build();
    }

}
