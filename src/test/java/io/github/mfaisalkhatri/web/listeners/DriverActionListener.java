package io.github.mfaisalkhatri.web.listeners;

import io.github.boykaframework.actions.interfaces.listeners.drivers.IDriverActionsListener;
import io.qameta.allure.Allure;

public class DriverActionListener implements IDriverActionsListener {

    @Override
    public void onWaitUntil() {
        Allure.step("Waiting until the specific condition is met....");
    }
}
