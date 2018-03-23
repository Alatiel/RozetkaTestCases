import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public LoginPage typeUsername(String username) {
        driver.findElement(driver.findElement(By.xpath("//input[@name='login']"))));
        return this;
    }
}
