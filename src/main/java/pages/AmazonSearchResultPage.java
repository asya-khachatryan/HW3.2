package pages;

import constants.locators.AmazonProductPageConstants;
import constants.locators.AmazonSearchResultPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearchResultPage extends BasePage {
    private final By resultContainer = By.cssSelector(AmazonSearchResultPageConstants.RESULT_CONTAINER);
    private final By resultTitle = By.cssSelector(AmazonSearchResultPageConstants.RESULT_TITLE);
    private final By dellBrandFilter = By.xpath(AmazonSearchResultPageConstants.DELL_BRAND_FILTER);

    public AmazonSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getResultCount() {
        return driver.findElements(resultContainer).size();
    }

    public String getResultTitle(int index) {
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resultContainer))
                .findElements(resultTitle).get(index);
        return resultElement.getText();
    }

    public AmazonProductPage clickResultTitle(int index) {
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resultContainer))
                .findElements(resultTitle).get(index);
        resultElement.click();
        return new AmazonProductPage(driver);
    }

    public List<String> getSearchResults() {
        List<WebElement> searchResultElements = driver.findElements(resultContainer);
        List<String> searchResults = new ArrayList<>();
        for (WebElement element : searchResultElements) {
            searchResults.add(element.getText());
        }
        return searchResults;
    }


    public void selectDellBrandFilter() {
        clickElement(dellBrandFilter);
    }
}
