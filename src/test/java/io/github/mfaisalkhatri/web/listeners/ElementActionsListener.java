package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.elements.IElementActionsListener;
import io.github.boykaframework.builders.Locator;
import io.qameta.allure.Allure;

import java.text.MessageFormat;

public class ElementActionsListener implements IElementActionsListener {


    @Override
    public void onClear(Locator locator) {
        Allure.step(MessageFormat.format("Clearing value in element [{0}]...", locator.getName()));
    }

    @Override
    public void onGetText(Locator locator) {
        Allure.step(MessageFormat.format("Getting Text on element [{0}]...", locator.getName()));
    }

    @Override
    public void onIsDisplayed(Locator locator) {
        Allure.step(MessageFormat.format("Checking if element [{0}] is displayed...", locator.getName()));
    }

    @Override
    public void onScrollIntoView(Locator locator) {
        Allure.step(MessageFormat.format("Scrolling element [{0}] into view...", locator.getName()));
    }

    @Override
    public void onVerifyIsDisplayed(Locator locator) {
        Allure.step(MessageFormat.format("Verifying if element [{0}] is displayed...", locator.getName()));

    }

    @Override
    public void onVerifyText(Locator locator) {
        Allure.step(MessageFormat.format("Verifying the text of element [{0}]...", locator.getName()));
    }
}
