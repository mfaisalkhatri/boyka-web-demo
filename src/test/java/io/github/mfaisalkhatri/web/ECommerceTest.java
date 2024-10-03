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
    private CheckoutPage checkoutPage;
    private ConfirmOrder confirmOrder;
    private OrderSuccessPage orderSuccessPage;
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

        this.shoppingCartPage = this.searchResultPage.navigateToCart();
    }

    @Test
    public void testCheckCartDetails() {
        this.homePage.checkTheCartCount("1");
        this.shoppingCartPage.checkProductName(this.productName);
        this.shoppingCartPage.checkProductPrice(this.productPrice);
        this.shoppingCartPage.checkCartTotalAmount(this.productPrice);

        this.checkoutPage = this.shoppingCartPage.navigateToCheckoutPage();
    }


    @Test
    public void testProductCheckout() {
        this.checkoutPage.checkProductName(this.productName);
        this.checkoutPage.checkProductPrice(this.productPrice);
        this.checkoutPage.addBillingAddress();

        this.confirmOrder = this.checkoutPage.checkoutProduct();

    }

    @Test
    public void testConfirmOrder() {
        this.confirmOrder.checkPageHeader();
        this.confirmOrder.checkProductName(this.productName);
        this.orderSuccessPage = this.confirmOrder.confirmOrder();
    }

    @Test
    public void testOrderSuccess() {
        this.orderSuccessPage.checkOrderSuccessMessage();
        this.orderSuccessPage.continueToHomePage();
    }


    @AfterClass(description = "Tear down test class")
    public void tearDownClass() {
        clearSession();
    }

}
