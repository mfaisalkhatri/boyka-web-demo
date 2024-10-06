package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class BasePage {

    protected final Locator pageHeader = Locator.buildLocator ()
        .name ("Page header")
        .web (By.cssSelector ("#content h1"))
        .build ();

}
