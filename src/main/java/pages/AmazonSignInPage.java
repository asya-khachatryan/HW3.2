package pages;

import constants.locators.AmazonSignInPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonSignInPage extends BasePage{
    private final By emailField = By.id(AmazonSignInPageConstants.EMAIL_FIELD);
    private final By continueButton = By.id(AmazonSignInPageConstants.CONTINUE_BUTTON);
    private final By emptyInputErrorMessage = By.id(AmazonSignInPageConstants.EMPTY_INPUT_ERROR_MESSAGE_BOX);
    private final By failedLoginErrorMessage = By.id(AmazonSignInPageConstants.WRONG_INPUT_ERROR_MESSAGE_BOX);


    public AmazonSignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
    }

    public boolean isEmptyInputErrorMessageDisplayed() {
        return driver.findElements(emptyInputErrorMessage).size() > 0;
    }

    public boolean isFailedLoginErrorMessageDisplayed() {
        return super.isElementDisplayed(failedLoginErrorMessage);
    }

    public String getEmptyInputErrorMessage() {
        return getElementText(emptyInputErrorMessage);
    }

    public String getFailedLoginErrorMessage() {
        return getElementText(failedLoginErrorMessage);
    }
}
