package io.github.mfaisalkhatri.web;

import io.github.mfaisalkhatri.web.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;

public class ECommerceTest {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ShoppingCartPage shoppingCartPage;
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

        shoppingCartPage = this.searchResultPage.navigateToCart();
    }

    @Test
    public void testCheckCartDetails() {
        this.homePage.checkTheCartCount("1");
        this.shoppingCartPage.checkProductName(productName);
        this.shoppingCartPage.checkProductPrice(productPrice);
        this.shoppingCartPage.checkCartTotalAmount(productPrice);

        this.shoppingCartPage.navigateToCheckoutPage();
    }


    @AfterClass(description = "Tear down test class")
    public void tearDownClass() {
        clearSession();
    }

}
