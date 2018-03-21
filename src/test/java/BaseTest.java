import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () {
        System.out.println("BeforeClass");
        //Create a Chrome driver. All test and page classes use this driver.
        driver = new ChromeDriver();

        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver, 10);

        //Maximize Window
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown () {
        System.out.println("AfterMethod");
        // driver.get("chrome://settings/clearBrowserData");
        driver.quit();
        driver = null;
    }
}

