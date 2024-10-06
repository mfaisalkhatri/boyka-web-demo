package io.github.mfaisalkhatri.web.listeners;

import java.text.MessageFormat;

import io.github.boykaframework.actions.interfaces.listeners.elements.ITextBoxActionsListener;
import io.github.boykaframework.builders.Locator;
import io.qameta.allure.Allure;

public class TextboxActionsListener implements ITextBoxActionsListener {

    @Override
    public void onEnterText (final Locator locator, final String text) {
        Allure.step (MessageFormat.format ("Entering text [{0}] in element [{1}]...", text, locator.getName ()));
    }
}
