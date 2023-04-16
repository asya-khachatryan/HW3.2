package pages;

import constants.locators.AmazonHomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends BasePage {
    private final By searchBox = By.id(AmazonHomePageConstants.SEARCH_BOX);
    private final By searchButton = By.id(AmazonHomePageConstants.SEARCH_BUTTON);
    private final By departmentsDropdown = By.id(AmazonHomePageConstants.DEPARTMENTS_DROPDOWN);
    private final By shopByInterestCategory = By.xpath(AmazonHomePageConstants.SHOP_BY_INTEREST);
    private final By signInButton = By.xpath(AmazonHomePageConstants.SIGN_IN_BUTTON);

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public AmazonSearchResultPage searchForProduct(String query) {
        enterText(searchBox, query);
        clickElement(searchButton);
        return new AmazonSearchResultPage(driver);
    }

    public AmazonSearchResultPage navigateToShopByInterestPage() {
        clickElement(departmentsDropdown);
        clickElement(shopByInterestCategory);
        return new AmazonSearchResultPage(driver);
    }

    public AmazonSignInPage clickSignInLink(){
        clickElement(signInButton);
        return new AmazonSignInPage(driver);
    }
}
