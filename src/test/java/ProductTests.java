import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonProductPage;
import pages.AmazonSearchResultPage;

import static constants.urls.PagesUrls.cartViewUrl;

public class ProductTests extends BaseTest {

    @Test
    public void testAddToCart() {
        SoftAssert softAssert = new SoftAssert();
        String searchItem = "fan";
        AmazonSearchResultPage searchPage = homePage.searchForProduct(searchItem);
        AmazonProductPage productPage = searchPage.clickResultTitle(1);
        productPage.addToCart();
        softAssert.assertTrue(driver.getCurrentUrl().contains(cartViewUrl));
        softAssert.assertEquals(productPage.getCartCount(), 1);
        softAssert.assertAll();
    }
}
