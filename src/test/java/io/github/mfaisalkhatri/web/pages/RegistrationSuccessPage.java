package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class RegistrationSuccessPage {

    private static final RegistrationSuccessPage REGISTRATION_SUCCESS_PAGE = new RegistrationSuccessPage();

    public static RegistrationSuccessPage registrationSuccessPage() {
        return REGISTRATION_SUCCESS_PAGE;
    }

    private final Locator pageHeader = Locator.buildLocator()
            .name("Registration Success page header")
            .web(By.cssSelector("#content h1"))
            .build();

    public void checkPageHeader() {
        ElementActions.onElement(pageHeader).verifyText().isEqualTo("Your Account Has Been Created!");
    }
}
