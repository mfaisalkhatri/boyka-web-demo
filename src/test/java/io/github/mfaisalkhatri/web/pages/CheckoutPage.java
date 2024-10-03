package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.DropDownActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.actions.elements.TextBoxActions;
import io.github.boykaframework.builders.Locator;
import io.github.mfaisalkhatri.web.testdata.RegisterUser;
import net.datafaker.Faker;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    public CheckoutPage(){

    }

    private Locator productName = Locator.buildLocator()
            .name("Product Name in Shopping cart")
            .web(By.cssSelector("td.text-left:nth-child(2) > a"))
            .build();

    private Locator productPrice = Locator.buildLocator()
            .name("Product Total Price in Cart")
            .web(By.cssSelector("td.text-right:nth-child(5)"))
            .build();

    private Locator firstNameField = Locator.buildLocator()
            .name("First Name Field")
            .web(By.id("input-payment-firstname"))
            .build();

    private Locator lastNameField = Locator.buildLocator()
            .name("Last Name Field")
            .web(By.id("input-payment-lastname"))
            .build();

    private Locator companyField = Locator.buildLocator()
            .name("Company Field")
            .web(By.id("input-payment-company"))
            .build();

    private Locator addressOneField = Locator.buildLocator()
            .name("Address One Field")
            .web(By.id("input-payment-address-1"))
            .build();

    private Locator cityField = Locator.buildLocator()
            .name("City Field")
            .web(By.id("input-payment-city"))
            .build();

    private Locator postCodeField = Locator.buildLocator()
            .name("Post Code Field")
            .web(By.id("input-payment-postcode"))
            .build();

    private Locator countryField = Locator.buildLocator()
            .name("Country Field")
            .web(By.id("input-payment-country"))
            .build();

    private Locator regionField = Locator.buildLocator()
            .name("Region Field")
            .web(By.id("input-payment-zone"))
            .build();

    private Locator commentBox = Locator.buildLocator()
            .name("Comment box")
            .web(By.id("input-comment"))
            .build();

    private Locator termsAndConditionsCheckbox = Locator.buildLocator()
            .name("Terms and Conditions Checkbox")
            .web(By.cssSelector("div.custom-control:nth-child(6) > label"))
            .build();

    private Locator continueBtn = Locator.buildLocator()
            .name("Terms and Conditions Checkbox")
            .web(By.cssSelector("button#button-save"))
            .build();

    public void checkProductName(String expectedProductName) {
        ElementActions.onElement(productName).verifyText().isEqualTo(expectedProductName);
    }

    public void checkProductPrice(String expectedProductPrice) {
        ElementActions.onElement(productPrice).verifyText().isEqualTo(expectedProductPrice);
    }

    public void addBillingAddress(RegisterUser registerUser) {
        Faker faker = new Faker();
        TextBoxActions.onTextBox(firstNameField).clear();
        TextBoxActions.onTextBox(firstNameField).enterText(registerUser.getFirstName());

        TextBoxActions.onTextBox(lastNameField).clear();
        TextBoxActions.onTextBox(lastNameField).enterText(registerUser.getLastName());

        TextBoxActions.onTextBox(companyField).clear();
        TextBoxActions.onTextBox(companyField).enterText(faker.company().name());

        TextBoxActions.onTextBox(addressOneField).clear();
        TextBoxActions.onTextBox(addressOneField).enterText(faker.address().streetAddress());

        TextBoxActions.onTextBox(cityField).clear();
        TextBoxActions.onTextBox(cityField).enterText(faker.address().city());

        TextBoxActions.onTextBox(cityField).clear();
        TextBoxActions.onTextBox(cityField).enterText(faker.address().city());

        TextBoxActions.onTextBox(postCodeField).clear();
        TextBoxActions.onTextBox(postCodeField).enterText(faker.address().postcode());

        DropDownActions.onDropDown(countryField).selectByText("Saudi Arabia");
        DropDownActions.onDropDown(regionField).selectByText("Ar Riyad");


    }

    public ConfirmOrder checkoutProduct() {
        TextBoxActions.onTextBox(commentBox).enterText("Demo Order");
        ClickableActions.withMouse(termsAndConditionsCheckbox).hover();
        ClickableActions.withMouse(termsAndConditionsCheckbox).click();
        ClickableActions.withMouse(continueBtn).click();
        return new ConfirmOrder();
    }



}

