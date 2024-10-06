package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.elements.ITextBoxActionsListener;
import io.github.boykaframework.builders.Locator;

public class TextboxActionsListener implements ITextBoxActionsListener {


    @Override
    public void onEnterText(Locator locator, String text) {
        ITextBoxActionsListener.super.onEnterText(locator, text);
    }
}
