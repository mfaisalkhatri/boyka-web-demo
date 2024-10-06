package io.github.mfaisalkhatri.web.listeners;

import java.text.MessageFormat;

import io.github.boykaframework.actions.interfaces.listeners.elements.IClickableActionsListener;
import io.github.boykaframework.builders.Locator;
import io.qameta.allure.Allure;

public class ClickableActionListeners implements IClickableActionsListener {
    @Override
    public void onClick (final Locator locator) {
        Allure.step (MessageFormat.format ("Clicking on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onHover (final Locator locator) {
        Allure.step (MessageFormat.format ("Hovering on element [{0}]...", locator.getName ()));
    }
}