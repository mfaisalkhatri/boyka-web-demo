package io.github.mfaisalkhatri.web;

import io.github.mfaisalkhatri.web.pages.HomePage;
import io.github.mfaisalkhatri.web.pages.RegistrationPage;
import io.github.mfaisalkhatri.web.pages.RegistrationSuccessPage;
import io.github.mfaisalkhatri.web.pages.SearchResultPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;

public class ECommerceTest {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private String productName;
    private String productPrice;

    @BeforeClass(description = "Setup test class")
    public void setupClass() {
        createSession(WEB, "ecommerce");
        this.homePage = new HomePage();
    }

    @Test
    public void testRegisterUser() {

        final RegistrationPage registrationPage = this.homePage.openRegistrationPage();
        registrationPage.checkPageHeader();

        final RegistrationSuccessPage registrationSuccessPage = registrationPage.registerUser();
        registrationSuccessPage.checkPageHeader();
    }

    @Test
    public void testSearchProduct() {
        final String searchProduct = "HTC Touch";
        this.searchResultPage = this.homePage.searchForProduct(searchProduct);
        this.searchResultPage.checkProductName(searchProduct);

        this.productName = this.searchResultPage.getProductName();
        this.productPrice = this.searchResultPage.getProductPrice();
    }

    @Test
    public void testAddProductToCart() {
        this.searchResultPage.addProductToCart();
        this.searchResultPage.checkSuccessMessageForProductAddedToCart();

        this.searchResultPage.navigateToCart();
    }

    @Test
    public void testCheckCartDetails() {
        this.homePage.checkTheCartCount("1");


    }


    @AfterClass(description = "Tear down test class")
    public void tearDownClass() {
        clearSession();
    }

}
