import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SearchPage extends BasePage {

    private By searchInput = By.cssSelector(Locators.searchInput);
    private By searchButton = By.cssSelector(Locators.searchButton);

    public SearchPage(WebDriver driver) {
        super(driver, Duration.ZERO);
    }

    public void searchFor(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchSuccessful(String keyword) {
        return driver.getPageSource().contains(keyword);
    }
}
