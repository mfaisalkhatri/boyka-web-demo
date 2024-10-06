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

    private final Locator addressOneField            = Locator.buildLocator ()
        .name ("Address One Field")
        .web (By.id ("input-payment-address-1"))
        .build ();
    private final Locator cityField                  = Locator.buildLocator ()
        .name ("City Field")
        .web (By.id ("input-payment-city"))
        .build ();
    private final Locator commentBox                 = Locator.buildLocator ()
        .name ("Comment box")
        .web (By.id ("input-comment"))
        .build ();
    private final Locator companyField               = Locator.buildLocator ()
        .name ("Company Field")
        .web (By.id ("input-payment-company"))
        .build ();
    private final Locator continueBtn                = Locator.buildLocator ()
        .name ("Terms and Conditions Checkbox")
        .web (By.cssSelector ("button#button-save"))
        .build ();
    private final Locator countryField               = Locator.buildLocator ()
        .name ("Country Field")
        .web (By.id ("input-payment-country"))
        .build ();
    private final Locator firstNameField             = Locator.buildLocator ()
        .name ("First Name Field")
        .web (By.id ("input-payment-firstname"))
        .build ();
    private final Locator lastNameField              = Locator.buildLocator ()
        .name ("Last Name Field")
        .web (By.id ("input-payment-lastname"))
        .build ();
    private final Locator postCodeField              = Locator.buildLocator ()
        .name ("Post Code Field")
        .web (By.id ("input-payment-postcode"))
        .build ();
    private final Locator productName                = Locator.buildLocator ()
        .name ("Product Name in Shopping cart")
        .web (By.cssSelector ("td.text-left:nth-child(2) > a"))
        .build ();
    private final Locator productPrice               = Locator.buildLocator ()
        .name ("Product Total Price in Cart")
        .web (By.cssSelector ("td.text-right:nth-child(5)"))
        .build ();
    private final Locator regionField                = Locator.buildLocator ()
        .name ("Region Field")
        .web (By.id ("input-payment-zone"))
        .build ();
    private final Locator termsAndConditionsCheckbox = Locator.buildLocator ()
        .name ("Terms and Conditions Checkbox")
        .web (By.cssSelector ("div.custom-control:nth-child(6) > label"))
        .build ();

    public CheckoutPage () {

    }

    public void addBillingAddress (final RegisterUser registerUser) {
        final Faker faker = new Faker ();
        TextBoxActions.onTextBox (this.firstNameField)
            .clear ();
        TextBoxActions.onTextBox (this.firstNameField)
            .enterText (registerUser.getFirstName ());

        TextBoxActions.onTextBox (this.lastNameField)
            .clear ();
        TextBoxActions.onTextBox (this.lastNameField)
            .enterText (registerUser.getLastName ());

        TextBoxActions.onTextBox (this.companyField)
            .clear ();
        TextBoxActions.onTextBox (this.companyField)
            .enterText (faker.company ()
                .name ());

        TextBoxActions.onTextBox (this.addressOneField)
            .clear ();
        TextBoxActions.onTextBox (this.addressOneField)
            .enterText (faker.address ()
                .streetAddress ());

        TextBoxActions.onTextBox (this.cityField)
            .clear ();
        TextBoxActions.onTextBox (this.cityField)
            .enterText (faker.address ()
                .city ());

        TextBoxActions.onTextBox (this.cityField)
            .clear ();
        TextBoxActions.onTextBox (this.cityField)
            .enterText (faker.address ()
                .city ());

        TextBoxActions.onTextBox (this.postCodeField)
            .clear ();
        TextBoxActions.onTextBox (this.postCodeField)
            .enterText (faker.address ()
                .postcode ());

        DropDownActions.onDropDown (this.countryField)
            .selectByText ("Saudi Arabia");
        DropDownActions.onDropDown (this.regionField)
            .selectByText ("Ar Riyad");

    }

    public void checkProductName (final String expectedProductName) {
        ElementActions.onElement (this.productName)
            .verifyText ()
            .isEqualTo (expectedProductName);
    }

    public void checkProductPrice (final String expectedProductPrice) {
        ElementActions.onElement (this.productPrice)
            .verifyText ()
            .isEqualTo (expectedProductPrice);
    }

    public ConfirmOrder checkoutProduct () {
        TextBoxActions.onTextBox (this.commentBox)
            .enterText ("Demo Order");
        ClickableActions.withMouse (this.termsAndConditionsCheckbox)
            .hover ();
        ClickableActions.withMouse (this.termsAndConditionsCheckbox)
            .click ();
        ClickableActions.withMouse (this.continueBtn)
            .click ();
        return new ConfirmOrder ();
    }

}

