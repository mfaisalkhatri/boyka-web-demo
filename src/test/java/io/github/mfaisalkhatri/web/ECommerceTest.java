package io.github.mfaisalkhatri.web;

import io.github.mfaisalkhatri.web.pages.HomePage;
import io.github.mfaisalkhatri.web.pages.RegistrationPage;
import io.github.mfaisalkhatri.web.pages.RegistrationSuccessPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;

public class ECommerceTest {

    @BeforeClass(description = "Setup test class")
    public void setupClass() {
        createSession(WEB, "ecommerce");
    }

    @Test
    public void registerUserTest() {

        HomePage.homePage().openRegistrationPage();
        RegistrationPage.registrationPage().checkPageHeader();
        //RegistrationPage.registrationPage().registerUser();

        //RegistrationSuccessPage.registrationSuccessPage().checkPageHeader();
    }

    @AfterClass(description = "Tear down test class")
    public void tearDownClass() {
        clearSession();
    }


}
