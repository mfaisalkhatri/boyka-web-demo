package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class CheckoutPage {

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
            .web(By.id("div.custom-control:nth-child(6)"))
            .build();

    private Locator continueBtn = Locator.buildLocator()
            .name("Terms and Conditions Checkbox")
            .web(By.cssSelector("button#button-save"))
            .build();



}

