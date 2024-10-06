package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.elements.IElementActionsListener;
import io.github.boykaframework.builders.Locator;

public class ElementActionsListener implements IElementActionsListener {


    @Override
    public void onClear(Locator locator) {
        IElementActionsListener.super.onClear(locator);
    }

    @Override
    public void onGetText(Locator locator) {
        IElementActionsListener.super.onGetText(locator);
    }

    @Override
    public void onIsDisplayed(Locator locator) {
        IElementActionsListener.super.onIsDisplayed(locator);
    }

    @Override
    public void onScrollIntoView(Locator locator) {
        IElementActionsListener.super.onScrollIntoView(locator);
    }

    @Override
    public void onVerifyIsDisplayed(Locator locator) {
        IElementActionsListener.super.onVerifyIsDisplayed(locator);
    }

    @Override
    public void onVerifyText(Locator locator) {
        IElementActionsListener.super.onVerifyText(locator);
    }
}
