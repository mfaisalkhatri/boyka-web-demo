package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ElementActions;

public class RegistrationSuccessPage extends BasePage {


    public RegistrationSuccessPage() {
    }

    public void checkPageHeader() {
        ElementActions.onElement(pageHeader).verifyText().isEqualTo("Your Account Has Been Created!");
    }

}
