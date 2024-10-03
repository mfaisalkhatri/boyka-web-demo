package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.builders.Locator;
import io.github.mfaisalkhatri.web.testdata.RegisterUser;
import org.openqa.selenium.By;

import static io.github.mfaisalkhatri.web.testdata.RegistrationDataBuilder.getRegistrationData;

public class BasePage {

    protected RegisterUser registerUser;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;

    public BasePage() {
        registerUser = getRegistrationData();
        firstName = getRegistrationData().getFirstName();
        lastName = getRegistrationData().getLastName();
        email = getRegistrationData().getEmail();
        phoneNumber = getRegistrationData().getPhoneNumber();
    }

    protected final Locator pageHeader = Locator.buildLocator()
            .name("Page header")
            .web(By.cssSelector("#content h1"))
            .build();


}
