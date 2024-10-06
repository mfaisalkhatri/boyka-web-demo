package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class MyAccountPage {

    Locator pageHeader = Locator.buildLocator ()
        .name ("My Account page header")
        .web (By.cssSelector ("#content > div:nth-child(1) > h2"))
        .build ();

    public MyAccountPage () {

    }

    public void checkPageHeader () {
        ElementActions.onElement (this.pageHeader)
            .verifyText ()
            .isEqualTo ("My Account");
    }
}
