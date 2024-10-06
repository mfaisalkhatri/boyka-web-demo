package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.elements.IClickableActionsListener;
import io.github.boykaframework.builders.Locator;
import io.qameta.allure.Allure;

import java.text.MessageFormat;

public class ClickableActionListeners implements IClickableActionsListener {
    @Override
    public void onClick(Locator locator) {
        Allure.step (MessageFormat.format ("Clicking on element [{0}]...", locator.getName ()));
    }

    @Override
    public void onHover(Locator locator) {
        Allure.step(MessageFormat.format("Hovering on element [{0}]...", locator.getName ()));
    }
}
