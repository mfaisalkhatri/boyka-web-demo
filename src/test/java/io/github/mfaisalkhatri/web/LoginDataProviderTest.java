package io.github.mfaisalkhatri.web;

import io.github.boykaframework.actions.drivers.WindowActions;
import io.github.mfaisalkhatri.web.pages.HomePage;
import io.github.mfaisalkhatri.web.pages.LoginPage;
import io.github.mfaisalkhatri.web.pages.MyAccountPage;
import io.github.mfaisalkhatri.web.testdata.LoginData;
import io.github.mfaisalkhatri.web.testdata.LoginDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;

@Slf4j
public class LoginDataProviderTest {

    @BeforeClass(description = "Setup test class")
    public void setupClass() {
        createSession(WEB, "ecommerce");
    }

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "getLoginDataObject")
    public void testLogin(LoginData loginData) {
        var homePage = new HomePage();
        var loginPage = homePage.openLoginPage();
        loginPage.checkLoginBoxTitle();
        if (loginData.isEnabled()) {
            loginPage.performLogin(loginData.getUsername(), loginData.getPassword());
            if (!loginData.isValid()) {
                loginPage.checkWarningMessage();

            } else {
                var myAccountPage = new MyAccountPage();
                myAccountPage.checkPageHeader();
            }
        }
    }

    @AfterMethod(description = "Take screenshots after every test")
    public void takeScreenshots() {
        WindowActions.onWindow().takeScreenshot();
    }

    @AfterClass(description = "Tear down test class")
    public void tearDownClass() {
        clearSession();
    }

}