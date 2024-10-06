package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.elements.IDropDownActionsListener;
import io.github.boykaframework.builders.Locator;
import io.qameta.allure.Allure;

import java.text.MessageFormat;

public class DropdownActionListeners implements IDropDownActionsListener {

    @Override
    public void onSelectByText(Locator locator, String text) {
        Allure.step(MessageFormat.format("Selecting item on element [{0}] by text [{1}]...", locator.getName(), text));

    }

    @Override
    public void onSelectByValue(Locator locator, String value) {
        Allure.step(MessageFormat.format("Selecting item on element [{0}] by value [{1}]...", locator.getName(), value));
    }
}
