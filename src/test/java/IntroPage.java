import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class IntroPage extends BasePage {

    private By introTextLocator = By.cssSelector(Locators.pageIntroName);

    public IntroPage(WebDriver driver) {
        super(driver, Duration.ZERO);
    }

    public String getIntroText() {
        return driver.findElement(introTextLocator).getText();
    }

}
