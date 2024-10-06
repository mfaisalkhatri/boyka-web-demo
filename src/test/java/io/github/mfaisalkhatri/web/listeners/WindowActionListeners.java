package io.github.mfaisalkhatri.web.listeners;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.github.boykaframework.actions.interfaces.listeners.drivers.IWindowActionsListener;
import io.qameta.allure.Allure;

public class WindowActionListeners implements IWindowActionsListener {

    @Override
    public void onClose () {
        Allure.step ("Closing the window...");
    }

    @Override
    public void onTakeScreenshot (final String fileName) {
        Allure.step ("Taking screenshot of the current page...");
        try (final InputStream is = Files.newInputStream (Paths.get (fileName))) {
            Allure.attachment (fileName, is);

        } catch (final IOException e) {
            throw new Error ("Error occurred while attaching screenshot!!");
        }
    }
}
