# Application Overview — Automation Exercise

## 1. Application Details

- **Application Name:** Automation Exercise
- **Application URL:** https://www.automationexercise.com/
- **Application Type:** E-commerce practice website
- **Testing Purpose:** Practice requirements analysis, manual testing, and web UI test automation.

## 2. Application Purpose

Automation Exercise is a practice e-commerce website used to explore online shopping functionality and learn software testing.

This document records observations from the homepage, Products page, individual product details page, shopping cart, checkout journey, Login / Signup page, Contact Us page, Test Cases page, and API Testing page.

## 3. Observed Navigation Items

The following navigation items were observed on the homepage:

- Home
- Products
- Cart
- Login / Signup
- Test Cases
- API Testing
- Video Tutorials
- Contact Us

## 4. Observed Application Features

### 4.1 Homepage

- Product listings were observed.
- Product prices were visible.
- Navigation to different website sections was available.

### 4.2 Products Page

- Product names and prices were visible.
- Product images were displayed.
- A product search box was available.
- A View Product option was available.
- An image advertising a 50% sale offer was observed.

The behavior of product search and the advertised sale offer has not yet been verified.

### 4.3 Individual Product Details Page

The following elements were observed:

- Product name
- Product image
- Product price
- Product category
- Product availability information
- Brand information
- Quantity field
- Add to Cart button
- Product description or image content

The quantity field was changed during exploration, but its resulting behavior was not recorded.

### 4.4 Shopping Cart

The following behavior and elements were observed:

- A confirmation modal appeared after clicking Add to Cart.
- The cart displayed the product name and price.
- The cart displayed the product quantity.
- A total price was displayed.
- A remove option was available for the cart item.
- A checkout option was encountered.
- A subscription section was encountered.

The behavior of the remove option and subscription section has not yet been verified.

### 4.5 Checkout and Payment

The following items were observed during checkout exploration:

- A login or signup prompt appeared after selecting Proceed To Checkout.
- Delivery or billing address information was displayed.
- An order summary was displayed.
- An order comment field was visible.
- Payment-related fields were encountered for card number, CVC, and expiry date.
- A Pay and Confirm button was observed.

The exact sequence connecting these screens has not been fully documented. Payment submission and final order confirmation have not been verified.

### 4.6 Login / Signup

The Login / Signup page was explored.

The following elements were observed:

- A login form was visible.
- A signup form was visible.
- A name field was available.
- Email fields were available.
- A password field was available.
- A Login button was visible.
- A Signup button was visible.

Validation messages and the behavior of both forms have not yet been checked. Account creation and successful login have not been verified.

### 4.7 Contact Us Page

The Contact Us page was explored.

The following fields and controls were observed:

- Name field
- Email field
- Subject field
- Message field
- File upload option
- Submit button

The form was submitted during exploration, and a message or confirmation was displayed afterward.

The exact confirmation text and whether the message was successfully delivered to its intended recipient have not been verified. File upload behavior has not been checked.

### 4.8 Test Cases Page

The Test Cases page displays a list of 26 practice scenarios. The page invites users to select a scenario to view its detailed test steps.

The listed scenario topics include:

- User registration
- Login with correct or incorrect credentials
- Logout
- Registration using an existing email
- Contact Us form
- Test Cases page verification
- Product listing and product details
- Product search
- Subscription on the homepage and cart page
- Adding products to the cart
- Product quantity in the cart
- Placing orders with registration or login at different stages
- Removing products from the cart
- Viewing category and brand products
- Searching products and checking the cart after login
- Adding a product review
- Adding recommended items to the cart
- Verifying checkout address details
- Downloading an invoice after purchase
- Scroll-up and scroll-down functionality, with and without an arrow button

The page also contains a Feedback for Us section with information inviting users to suggest additional test scenarios or website features. A feedback email link is provided.

A Subscription section is visible near the bottom of the page. Copyright information is also displayed.

The detailed steps within the individual scenarios have not yet been explored. The behavior of the scenario links, feedback submission, and subscription functionality has not been verified.

### 4.9 API Testing Page

The API Testing page displays a list of 14 API practice scenarios. Users can select a scenario to view its detailed API information.

The listed API scenarios cover the following operations:

- **Products:** Get All Products List and POST To All Products List.
- **Brands:** Get All Brands List and PUT To All Brands List.
- **Product search:** Search Product and Search Product without the `search_product` parameter.
- **Login verification:** Verify Login with valid details, without the email parameter, with invalid details, and using a DELETE request.
- **User account management:** Create/Register User Account, Delete User Account, Update User Account, and retrieve user account details by email.

The page also contains a Feedback for Us section. It invites users to suggest additional API scenarios and website features and provides a feedback email link.

The detailed API information, request parameters, response formats, and actual API behavior have not yet been explored or verified. No API requests have been executed as part of this exploration.

### 4.10 Video Tutorials

- Clicking the Video Tutorials navigation link redirects the user to a YouTube video.
- The video content and navigation behavior beyond this redirect have not been explored.

### 4.11 Homepage Subscription

- A Subscription section is available at the bottom of the homepage.
- An email input field is available for subscription.
- After submitting an email address, the page displays the message: "You have been subscribed successfully."
- The behavior of invalid email addresses and duplicate subscriptions has not been verified.

### 4.12 Cart Page Subscription

- A Subscription section is visible in the footer of the Cart page.
- The section appears the same as the Subscription section on the homepage.
- Cart page subscription submission behavior has not been independently verified.

### 4.13 Product Categories

The Products page displays three main product categories:

- **Women**
  - Dress
  - Tops
  - Saree
- **Men**
  - T-shirts
  - Jeans
- **Kids**
  - Dress
  - Tops and Shirts

- A plus (+) sign is displayed beside the categories.
- Clicking the plus (+) sign expands the category to display its subcategories.
- The behavior after selecting individual subcategories has not yet been documented.

### 4.14 Product Brands

The Products page displays a Brands section with the following brands and counts shown beside their names:

| Brand | Displayed Count |
|---|---:|
| POLO | 6 |
| H&M | 5 |
| MADAME | 5 |
| MAST & HARBOUR | 3 |
| BABYHUG | 4 |
| ALLEN SOLLY JUNIOR | 3 |
| KOOKIE KIDS | 3 |
| BIBA | 5 |

The screenshot confirms the displayed brand names and counts. Brand selection behavior and the products displayed after selecting a brand have not yet been verified.

### 4.15 Brand Product Pages

- The website provides separate brand-specific URLs.
- Polo brand page: https://www.automationexercise.com/brand_products/Polo
- H&M brand page: https://www.automationexercise.com/brand_products/H&M
- The behavior of brand selection and the displayed products should be confirmed through direct exploration.

### 4.16 Polo Brand Products Page

- The page heading identifies the page as the Polo brand page.
- A product card displays the following information and controls:
  - Product image
  - Product name: Blue Top
  - Product price: Rs. 500
  - Add to cart button
  - View Product option
    - The behavior of the Add to cart and View Product controls on this page has not been independently verified.

### 4.17 Recommended Items Section

- A Recommended Items section is displayed on the homepage above the footer.
- The section uses a carousel identified as `recommended-item-carousel`.
- The behavior of the carousel and its product actions has not yet been verified.

## 5. Features Requiring Further Exploration

- Product search behavior
- Product categories and brands
- Quantity selection behavior
- Add to Cart confirmation behavior
- Shopping cart item removal
- Cart quantity and total price behavior
- Checkout navigation and login/signup requirements
- Delivery and billing address details
- Order comment behavior
- Payment form behavior
- Order confirmation after payment
- Login and signup form behavior
- Authentication validation messages
- Subscription section behavior
- Advertised sale offer and discount details
- Contact Us confirmation details and message delivery
- Contact Us file upload behavior
- Detailed steps inside the listed Test Cases scenarios
- Feedback functionality on the Test Cases page
- Detailed information for the 14 listed API scenarios
- API request parameters and response formats
- Actual API behavior and response validation
- Subscription validation and duplicate-subscription behavior
- Cart page subscription submission behavior
- Product subcategory navigation and displayed products.
- Brand selection behavior and displayed products.
- Brand page product details and product-card actions
- Confirm the availability and location of the product search field on the Products page.
- Recommended Items carousel navigation and product actions.

## 6. Preliminary Testing Scope

The following areas are candidates for further exploration:

- Homepage and navigation
- Product listings, names, prices, and images
- Product details
- Product search
- Product categories and brands
- Quantity selection
- Adding products to the cart
- Cart contents, totals, and item removal
- Checkout and address information
- Order comments
- Payment and order confirmation
- Login and signup
- Subscription
- Contact Us form and file upload
- Test Cases page content and navigation
- API Testing page and its listed API scenarios
- Feedback sections

This is a preliminary scope, not a finalized list of requirements or test cases.

## 7. Out of Scope for This Step

- Creating detailed test scenarios and test cases
- Defect reporting
- Selenium automation implementation
- Executing API requests
- Performance, security, and accessibility testing

These activities may be considered during later project stages.

## 8. Exploration Summary

- The homepage navigation and product-related content were observed.
- The Products page displayed product names, prices, images, a search box, and a View Product option.
- An image advertising a 50% sale offer was observed.
- The individual product details page displayed product information, a quantity field, and an Add to Cart button.
- A confirmation modal appeared after adding a product to the cart.
- The cart displayed the product name, price, quantity, total price, and a remove option.
- Checkout and a subscription section were encountered.
- Address information, an order summary, an order comment field, payment-related fields, and a Pay and Confirm button were observed during checkout exploration.
- The Login / Signup page displayed both forms, name and email fields, a password field, and Login and Signup buttons.
- The Contact Us page displayed name, email, subject, and message fields, a file upload option, and a Submit button. Submission resulted in a visible message or confirmation.
- The Test Cases page listed 26 practice scenarios and included a feedback section, a feedback email link, and a subscription section.
- The API Testing page listed 14 API practice scenarios covering products, brands, product search, login verification, and user-account management. A feedback section and email link were also visible.
- Validation behavior, successful authentication, successful payment, Contact Us message delivery, detailed test scenario behavior, and actual API behavior have not been verified.
- No defects have been confirmed during this exploration.
- Subscription section displayed the success message "You have been subscribed successfully."
- The Cart page contains the same Subscription section in its footer as the homepage; submission behavior on the Cart page has not been independently verified.
- The Products page displays Women, Men, and Kids categories, with expandable subcategories accessed using a plus (+) sign.
- The Products page displays a Brands section with eight visible brands and a count beside each brand name.
- The Polo brand page displayed a product card for Blue Top priced at Rs. 500, with Add to cart and View Product options.
- The homepage displays a Recommended Items section above the footer, using a carousel identified as recommended-item-carousel.

## 9. Next Activity

Continue exploring the application's remaining main features and record additional observations. Refine this overview as more behavior is investigated.
