## :question: What is this Repository about?

- This repo has example of Web automation with [Boyka Framework](https://github.com/BoykaFramework/boyka-framework)
- Websites used for testing are: [LambdaTest e-commerce Playground](https://ecommerce-playground.lambdatest.io/)
- This repo uses `Maven` as build tool and `TestNG` testing framework to run the tests.

## Test Scenarios covered in this repo

### Test Scenario 1 - Register a new user
1. Register a new User
2. Check that the registration is successful by verifying the text - "Your Account Has Been Created!"
3. Check that the user is already logged in by checking for Logout link

### Test Scenario 2 - Search and add product to the cart
1. Search for a product on the home page
2. Add the product to the cart
3. Check that the message - "Success: You have added <product> to your shopping cart!" is displayed with correct text.
4. Click on View Cart button to view the cart

### Test Scenario 3 - verify the cart details
1. Check that the count of the cart increases to "1".
2. Verify the product name and amount are correctly displayed in the cart

### Test Scenario 4 - Checkout the product
1. Check that the total amount is appearing correctly
2. Enter the billing details
3. Add comment for the order, tick the terms & conditions checkbox, and continue to checkout,

### Test Scenario 5 - Confirm Order
1. Check the total amount
2. Click on the Confirm Order button to confirm the order.
3. Check that the message "Your order has been placed!" is displayed on confirming the order.
4. Click on continue button
5. Logout of the website


