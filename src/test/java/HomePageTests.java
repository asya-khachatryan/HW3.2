import base.BaseTest;
import constants.messages.AssertionMessages;
import constants.messages.ErrorMessages;
import constants.urls.PagesUrls;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonProductPage;
import pages.AmazonSearchResultPage;
import pages.AmazonSignInPage;

import static constants.urls.PagesUrls.shopByInterestUrl;

public class HomePageTests extends BaseTest {
    @Test
    public void testSearch() {
        SoftAssert softAssert = new SoftAssert();
        String searchTerm = "Instax Mini 11";
        AmazonSearchResultPage searchResultPage = homePage.searchForProduct(searchTerm);
        AmazonProductPage productPage = searchResultPage.clickResultTitle(0);
        softAssert.assertTrue(productPage.getProductName().contains(searchTerm));
        AmazonSignInPage signInPage = productPage.buyNow();
        softAssert.assertTrue(driver.getCurrentUrl().contains(PagesUrls.signInUrl));
        signInPage.enterEmail("invalidemail");
        signInPage.clickContinueButton();
        softAssert.assertTrue(signInPage.isFailedLoginErrorMessageDisplayed(), AssertionMessages.failedToLogin);
        softAssert.assertEquals(signInPage.getFailedLoginErrorMessage(), ErrorMessages.failedLoginErrorMessage);
        softAssert.assertAll();
    }

    @Test
    public void testNavigateToLoginPage() {
        SoftAssert softAssert = new SoftAssert();
        AmazonSearchResultPage resultPage = homePage.navigateToShopByInterestPage();
        softAssert.assertEquals(resultPage.getPageTitle(), "Shop By Interest");
        softAssert.assertEquals(resultPage.getCurrentUrl(), shopByInterestUrl);
        softAssert.assertAll();
    }
}
