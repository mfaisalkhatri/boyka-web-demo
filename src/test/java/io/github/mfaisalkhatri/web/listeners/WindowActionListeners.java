package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.drivers.IWindowActionsListener;

public class WindowActionListeners implements IWindowActionsListener {

    @Override
    public void onClose() {
        IWindowActionsListener.super.onClose();
    }

    @Override
    public void onTakeScreenshot(String fileName) {
        IWindowActionsListener.super.onTakeScreenshot(fileName);
    }
}
