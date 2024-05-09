import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FooterPage extends BasePage {

    public FooterPage(WebDriver driver) {
        super(driver, Duration.ZERO);
    }

    public FooterPage clickContactLink() {
        driver.findElement(By.cssSelector(Locators.contactLink)).click();
        return this;
    }

    public FooterPage scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public boolean isAtFooter() {
        return driver.findElement(By.cssSelector(Locators.footer)).isDisplayed();
    }
}
