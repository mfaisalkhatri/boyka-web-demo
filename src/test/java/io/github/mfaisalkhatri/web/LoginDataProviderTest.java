package io.github.mfaisalkhatri.web;

import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;

import io.github.boykaframework.actions.drivers.WindowActions;
import io.github.mfaisalkhatri.web.pages.HomePage;
import io.github.mfaisalkhatri.web.pages.MyAccountPage;
import io.github.mfaisalkhatri.web.testdata.LoginData;
import io.github.mfaisalkhatri.web.testdata.LoginDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class LoginDataProviderTest {

    @BeforeClass (description = "Setup test class")
    public void setupClass () {
        createSession (WEB, "ecommerce");
    }

    @AfterMethod (description = "Take screenshots after every test")
    public void takeScreenshots () {
        WindowActions.onWindow ()
            .takeScreenshot ();
    }

    @AfterClass (description = "Tear down test class")
    public void tearDownClass () {
        clearSession ();
    }

    @Test (dataProviderClass = LoginDataProvider.class, dataProvider = "getLoginDataObject")
    public void testLogin (final LoginData loginData) {
        final var homePage = new HomePage ();
        final var loginPage = homePage.openLoginPage ();
        loginPage.checkLoginBoxTitle ();
        if (loginData.isEnabled ()) {
            loginPage.performLogin (loginData.getUsername (), loginData.getPassword ());
            if (!loginData.isValid ()) {
                loginPage.checkWarningMessage ();

            } else {
                final var myAccountPage = new MyAccountPage ();
                myAccountPage.checkPageHeader ();
            }
        }
    }

}