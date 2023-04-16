import base.BaseTest;
import constants.messages.AssertionMessages;
import constants.messages.ErrorMessages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonSignInPage;

public class SignInTests extends BaseTest {
    @Test
    public void testNoInputUsername() {
        SoftAssert softAssert = new SoftAssert();
        AmazonSignInPage signInPage = homePage.clickSignInLink();
        signInPage.clickContinueButton();

        softAssert.assertTrue(signInPage.isEmptyInputErrorMessageDisplayed(), AssertionMessages.emptyInput);
        softAssert.assertEquals(signInPage.getEmptyInputErrorMessage(), ErrorMessages.noInputErrorMessage);
        softAssert.assertAll();
    }
}
