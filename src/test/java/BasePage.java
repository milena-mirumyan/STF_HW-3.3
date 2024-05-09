import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor to initialize the WebDriver and WebDriverWait with more flexibility
    public BasePage(WebDriver driver, Duration waitDuration) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitDuration);
    }

    // Method to click on elements after ensuring they are clickable
    protected void click(By locator) {
        WebElement element = waitForElementClickable(locator);
        element.click();
    }

    // Method to send keys to elements after ensuring they are visible
    protected void type(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Method to wait until an element is clickable and return it
    protected WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to wait until an element is visible and return it
    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to get text from elements after ensuring they are visible
    protected String getText(By locator) {
        WebElement element = waitForElementVisible(locator);
        return element.getText();
    }

    // Method to check if an element is present on the page
    protected boolean isElementPresent(By locator) {
        try {
            return driver.findElements(locator).size() > 0;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
