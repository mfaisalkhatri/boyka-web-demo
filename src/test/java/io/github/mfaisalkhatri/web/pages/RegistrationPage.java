package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.TextBoxActions;
import io.github.boykaframework.builders.Locator;
import net.datafaker.Faker;
import org.openqa.selenium.By;


public class RegistrationPage extends BasePage {

    public RegistrationPage() {
    }

    private final Locator firstNameField = Locator.buildLocator()
            .name("First Name field")
            .web(By.id("input-firstname"))
            .build();

    private final Locator lastNameField = Locator.buildLocator()
            .name("Last Name field")
            .web(By.id("input-lastname"))
            .build();

    private final Locator emailField = Locator.buildLocator()
            .name("Email field")
            .web(By.id("input-email"))
            .build();

    private final Locator telephoneField = Locator.buildLocator()
            .name("Telephone field")
            .web(By.id("input-telephone"))
            .build();

    private final Locator passwordField = Locator.buildLocator()
            .name("Password field")
            .web(By.id("input-password"))
            .build();


    private final Locator confirmPasswordField = Locator.buildLocator()
            .name("Confirm Password field")
            .web(By.id("input-confirm"))
            .build();

    private final Locator agreePrivacyPolicy = Locator.buildLocator()
            .name("Agree to Privacy policy")
            .web(By.cssSelector(".float-right .custom-control"))
            .build();


    private final Locator continueBtn = Locator.buildLocator()
            .name("Continue Button")
            .web(By.cssSelector("input[type=submit]"))
            .build();


    public RegistrationSuccessPage registerUser() {
        Faker faker = new Faker();
        TextBoxActions.onTextBox(firstNameField).clear();
        TextBoxActions.onTextBox(firstNameField).enterText(faker.name().firstName());
        TextBoxActions.onTextBox(lastNameField).clear();
        TextBoxActions.onTextBox(lastNameField).enterText(faker.name().lastName());
        TextBoxActions.onTextBox(emailField).clear();
        TextBoxActions.onTextBox(emailField).enterText(faker.internet().emailAddress());
        TextBoxActions.onTextBox(telephoneField).clear();
        TextBoxActions.onTextBox(telephoneField).enterText(faker.phoneNumber().phoneNumber());
        TextBoxActions.onTextBox(passwordField).clear();
        TextBoxActions.onTextBox(passwordField).enterText("Password@123");
        TextBoxActions.onTextBox(confirmPasswordField).clear();
        TextBoxActions.onTextBox(confirmPasswordField).enterText("Password@123");
        ClickableActions.withMouse(agreePrivacyPolicy).hover();
        ClickableActions.withMouse(agreePrivacyPolicy).click();
        ClickableActions.withMouse(continueBtn).click();
        return new RegistrationSuccessPage();
    }
}
