package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.elements.IClickableActionsListener;
import io.github.boykaframework.builders.Locator;

public class ClickableActionListeners implements IClickableActionsListener {
    @Override
    public void onClick(Locator locator) {
        IClickableActionsListener.super.onClick(locator);
    }

    @Override
    public void onHover(Locator locator) {
        IClickableActionsListener.super.onHover(locator);
    }
}
