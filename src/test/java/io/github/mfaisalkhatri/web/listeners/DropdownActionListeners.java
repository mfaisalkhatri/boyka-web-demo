package io.github.mfaisalkhatri.web.listeners;

import java.text.MessageFormat;

import io.github.boykaframework.actions.interfaces.listeners.elements.IDropDownActionsListener;
import io.github.boykaframework.builders.Locator;
import io.qameta.allure.Allure;

public class DropdownActionListeners implements IDropDownActionsListener {

    @Override
    public void onSelectByText (final Locator locator, final String text) {
        Allure.step (
            MessageFormat.format ("Selecting item on element [{0}] by text [{1}]...", locator.getName (), text));

    }

    @Override
    public void onSelectByValue (final Locator locator, final String value) {
        Allure.step (
            MessageFormat.format ("Selecting item on element [{0}] by value [{1}]...", locator.getName (), value));
    }
}
