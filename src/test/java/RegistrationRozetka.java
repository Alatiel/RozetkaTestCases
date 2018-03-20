import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class RegistrationRozetka {
    WebDriver driver = new ChromeDriver();
    String Actualtext;
    String userName = "Lila";
    String login = "lilamuse18@yopmail.com";
    String password = "Lila281";
    String product = "Meizu M6 3/32GB Black (Международная версия)";

    @Test
    public void registration() throws InterruptedException {
       driver.get("https://rozetka.com.ua/");
       //add if
       driver.findElement(By.xpath(("//span[@class='exponea-close']"))).click();
       driver.findElement(By.xpath(("//a[@class='header-user-link sprite-side whitelink xhr']"))).click();
       driver.findElement(By.xpath(("//a[@class='novisited auth-f-signup-link']"))).click();
       driver.findElement(By.xpath(("//input[@name='title']"))).sendKeys(userName);
       driver.findElement(By.xpath(("//input[@name='login']"))).sendKeys(login);
       driver.findElement(By.xpath(("//input[@name='password']"))).sendKeys(password);
       driver.findElement(By.xpath(("//button[@class='btn-link-i' and @type='submit']"))).click();
       sleep(5000);
       //dd normal wait
       Actualtext = driver.findElement(By.xpath(("//span[text()='Мой кабинет']"))).getText();
       Assert.assertEquals(Actualtext, "Мой кабинет" );
       driver.quit();
    }
    @Test
    public void login() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath(("//a[@class='header-user-link sprite-side whitelink xhr']"))).click();
        driver.findElement(By.xpath(("//input[@name='login']"))).sendKeys(login);
        driver.findElement(By.xpath(("//input[@name='password']"))).sendKeys(password);
        driver.findElement(By.xpath(("//button[@class='btn-link-i' and @type='submit']"))).click();
        sleep(5000);
        //dd normal wait
        Actualtext = driver.findElement(By.xpath(("//a[text()='Lila']"))).getText();
        Assert.assertEquals(Actualtext, userName);
        driver.quit();
    }
    @Test
    public void findeProducrByNameAndAddToCart() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath(("//input[@class='rz-header-search-input-text passive']"))).sendKeys(product);
        driver.findElement(By.xpath(("//button[@class='btn-link-i js-rz-search-button']"))).click();
        driver.findElement(By.xpath(("//button[@class='btn-link-i' and @type='submit']"))).click();
        Actualtext = driver.findElement(By.xpath(("//h2[@class='cart-title']"))).getText();
        sleep(5000);
        //add normal wait
        Assert.assertEquals(Actualtext, "Вы добавили товар в корзину" );
        driver.quit();
    }
}
