package io.github.mfaisalkhatri.web;

import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;
import static io.github.mfaisalkhatri.web.testdata.RegistrationDataBuilder.getRegistrationData;

import io.github.boykaframework.actions.drivers.WindowActions;
import io.github.mfaisalkhatri.web.pages.CheckoutPage;
import io.github.mfaisalkhatri.web.pages.ConfirmOrder;
import io.github.mfaisalkhatri.web.pages.HomePage;
import io.github.mfaisalkhatri.web.pages.OrderSuccessPage;
import io.github.mfaisalkhatri.web.pages.RegistrationPage;
import io.github.mfaisalkhatri.web.pages.RegistrationSuccessPage;
import io.github.mfaisalkhatri.web.pages.SearchResultPage;
import io.github.mfaisalkhatri.web.pages.ShoppingCartPage;
import io.github.mfaisalkhatri.web.testdata.RegisterUser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ECommerceTest {

    private CheckoutPage     checkoutPage;
    private ConfirmOrder     confirmOrder;
    private HomePage         homePage;
    private OrderSuccessPage orderSuccessPage;
    private String           productName;
    private String           productPrice;
    private RegisterUser     registerUser;
    private SearchResultPage searchResultPage;
    private ShoppingCartPage shoppingCartPage;

    @BeforeClass (description = "Setup test class")
    public void setupClass () {
        createSession (WEB, "ecommerce");
        this.homePage = new HomePage ();
        this.registerUser = getRegistrationData ();

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

    @Test (description = "Check adding a product to cart")
    public void testAddProductToCart () {
        this.searchResultPage.addProductToCart ();
        this.searchResultPage.checkSuccessMessageForProductAddedToCart ();

        this.shoppingCartPage = this.searchResultPage.navigateToCart ();
    }

    @Test (description = "Check cart details")
    public void testCheckCartDetails () {
        this.homePage.checkTheCartCount ("1");
        this.shoppingCartPage.checkProductName (this.productName);
        this.shoppingCartPage.checkProductPrice (this.productPrice);
        this.shoppingCartPage.checkCartTotalAmount (this.productPrice);

        this.checkoutPage = this.shoppingCartPage.navigateToCheckoutPage ();
    }

    @Test (description = "Check Order confirmation")
    public void testConfirmOrder () {
        this.confirmOrder.checkPageHeader ();
        this.confirmOrder.checkProductName (this.productName);
        this.orderSuccessPage = this.confirmOrder.confirmOrder ();
    }

    @Test (description = "Check order is successful")
    public void testOrderSuccess () {
        this.orderSuccessPage.checkOrderSuccessMessage ();
        this.orderSuccessPage.continueToHomePage ();
    }

    @Test (description = "Check checking out the product from the cart")
    public void testProductCheckout () {
        this.checkoutPage.checkProductName (this.productName);
        this.checkoutPage.checkProductPrice (this.productPrice);
        this.checkoutPage.addBillingAddress (this.registerUser);

        this.confirmOrder = this.checkoutPage.checkoutProduct ();
    }

    @Test (description = "Check Registering a new user")
    public void testRegisterUser () {

        final RegistrationPage registrationPage = this.homePage.openRegistrationPage ();
        registrationPage.checkPageHeader ();

        final RegistrationSuccessPage registrationSuccessPage = registrationPage.registerUser (this.registerUser);
        registrationSuccessPage.checkPageHeader ();
    }

    @Test (description = "Check Searching for a product")
    public void testSearchProduct () {
        final String searchProduct = "HTC Touch";
        this.searchResultPage = this.homePage.searchForProduct (searchProduct);
        this.searchResultPage.checkProductName (searchProduct);

        this.productName = this.searchResultPage.getProductName ();
        this.productPrice = this.searchResultPage.getProductPrice ();
    }
}