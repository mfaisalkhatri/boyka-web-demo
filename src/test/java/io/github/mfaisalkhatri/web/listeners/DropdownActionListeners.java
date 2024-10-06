package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.elements.IDropDownActionsListener;
import io.github.boykaframework.builders.Locator;

public class DropdownActionListeners implements IDropDownActionsListener {

    @Override
    public void onSelectByText(Locator locator, String text) {
        IDropDownActionsListener.super.onSelectByText(locator, text);
    }

    @Override
    public void onSelectByValue(Locator locator, String value) {
        IDropDownActionsListener.super.onSelectByValue(locator, value);
    }
}
