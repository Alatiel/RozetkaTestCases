import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown () {
        // driver.get("chrome://settings/clearBrowserData");
        driver.quit();
        driver = null;
    }
}

