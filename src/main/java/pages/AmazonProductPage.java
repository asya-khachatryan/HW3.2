package pages;

import constants.locators.AmazonProductPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage extends BasePage{
    private final By productName = By.id(AmazonProductPageConstants.PRODUCT_NAME);
    private final By addToCartButton = By.id(AmazonProductPageConstants.ADD_TO_CART_BUTTON);
    private final By buyNowButton = By.id(AmazonProductPageConstants.BUY_NOW_BUTTON);
    private final By cartCount = By.id(AmazonProductPageConstants.CART_COUNT);

    public AmazonProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getElementText(productName);
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public AmazonSignInPage buyNow() {
        clickElement(buyNowButton);
        return new AmazonSignInPage(driver);
    }

    public int getCartCount(){
        return Integer.parseInt(getElementText(cartCount));
    }
}
