import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BenefitsPage extends BasePage {
    private IntroPage introPage;
    private FooterPage footerPage;
    private SearchPage searchPage;

    public WebElement contactLink = driver.findElement(By.cssSelector(Locators.contactLink));

    public BenefitsPage(WebDriver driver) {
        super(driver, Duration.ZERO);
        introPage = new IntroPage(driver);
        footerPage = new FooterPage(driver);
        searchPage = new SearchPage(driver);
    }

    public BenefitsPage navigateToBenefits() {
        driver.findElement(By.cssSelector(Locators.exploreBenefitsButton)).click();
        return this;
    }

    public BenefitsPage clickContactLink() {
        contactLink.click();
        return this;
    }

    public boolean isAt() {
        return driver.findElement(By.cssSelector(Locators.benefitsPage)).isDisplayed();
    }

    // Getter methods to access other pages
    public IntroPage getIntroPage() {
        return introPage;
    }

    public FooterPage getFooterPage() {
        return footerPage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }
}
