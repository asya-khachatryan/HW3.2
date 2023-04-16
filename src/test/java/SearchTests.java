import base.BaseTest;
import constants.messages.AssertionMessages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonSearchResultPage;

public class SearchTests extends BaseTest {
    @Test
    public void testSearch() {
        SoftAssert softAssert = new SoftAssert();
        String searchTerm = "iPhone 14 Pro";
        AmazonSearchResultPage resultPage = homePage.searchForProduct(searchTerm);
        String expectedTitle = "Amazon.com : iPhone 14 Pro";
        softAssert.assertEquals(expectedTitle, resultPage.getPageTitle(), AssertionMessages.successfulSearch);
        String resultTitle = resultPage.getResultTitle(0);
        softAssert.assertTrue(resultTitle.contains(searchTerm), AssertionMessages.relevantSearchItems);
        softAssert.assertAll();
    }

    @Test
    public void testFilterFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        String searchTerm = "laptop";
        AmazonSearchResultPage resultPage = homePage.searchForProduct(searchTerm);
        resultPage.selectDellBrandFilter();
        String expectedTitle = "Amazon.com : laptop";
        softAssert.assertEquals(expectedTitle, resultPage.getPageTitle(), AssertionMessages.successfulSearch);
        softAssert.assertTrue(resultPage.getSearchResults().stream().allMatch(r -> r.contains(searchTerm) && r.contains("Dell")));
        softAssert.assertAll();
    }

}
