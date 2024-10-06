package io.github.mfaisalkhatri.web.listeners;

import java.text.MessageFormat;

import io.github.boykaframework.actions.interfaces.listeners.elements.IElementActionsListener;
import io.github.boykaframework.builders.Locator;
import io.qameta.allure.Allure;

public class ElementActionsListener implements IElementActionsListener {

    @Override
    public void onClear (final Locator locator) {
        Allure.step (MessageFormat.format ("Clearing value in element [{0}]...", locator.getName ()));
    }

    @Override
    public void onGetText (final Locator locator) {
        Allure.step (MessageFormat.format ("Getting Text on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onIsDisplayed (final Locator locator) {
        Allure.step (MessageFormat.format ("Checking if element [{0}] is displayed...", locator.getName ()));
    }

    @Override
    public void onScrollIntoView (final Locator locator) {
        Allure.step (MessageFormat.format ("Scrolling element [{0}] into view...", locator.getName ()));
    }

    @Override
    public void onVerifyIsDisplayed (final Locator locator) {
        Allure.step (MessageFormat.format ("Verifying if element [{0}] is displayed...", locator.getName ()));

    }

    @Override
    public void onVerifyText (final Locator locator) {
        Allure.step (MessageFormat.format ("Verifying the text of element [{0}]...", locator.getName ()));
    }
}
