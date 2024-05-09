import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriverInfo;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

class K5Test {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpClass() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        String gridHubUrl = "http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(gridHubUrl), options);
        driver.get("https://www.k5learning.com/free-math-worksheets");


    }

    @AfterAll
    public static void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    public void setUpMethod() {
        // Setup code that runs before each test method
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
