import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class RegistrationRozetka extends BaseTest {
   // WebDriver driver = new ChromeDriver();
    String Actualtext;
    String userName = "Lila";
    String login = "lilamuse30@yopmail.com";
    String password = "Lila281";
    String product = "Meizu M6 3/32GB Black (Международная версия)";

    @Test (priority = 0)
    public void Registration() throws InterruptedException {
       driver.get("https://rozetka.com.ua/");
       //add if
       //driver.findElement(By.xpath("//span[@class='exponea-close']")).click();
       driver.findElement(By.xpath("//a[@class='header-user-link sprite-side whitelink xhr']")).click();
       driver.findElement(By.xpath("//a[@class='novisited auth-f-signup-link']")).click();
       driver.findElement(By.xpath("//input[@name='title']")).sendKeys(userName);
       driver.findElement(By.xpath("//input[@name='login']")).sendKeys(login);
       driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
       driver.findElement(By.xpath("//button[@class='btn-link-i' and @type='submit']")).click();
       sleep(5000);
       //dd normal wait
       Actualtext = driver.findElement(By.xpath(("//span[text()='Мой кабинет']"))).getText();
       Assert.assertEquals(Actualtext, "Мой кабинет" );

    }
    @Test (priority = 1)
    public void Login() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath("//a[@class='header-user-link sprite-side whitelink xhr']")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn-link-i' and @type='submit']")).click();
        sleep(5000);
        //add normal wait
        Actualtext = driver.findElement(By.xpath("//a[@class='header-user-link sprite-side whitelink xhr']")).getText();
        Assert.assertEquals(Actualtext, userName);

    }
    @Test (priority = 2)
    public void FindProductByNameAndAddToCart() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath("//input[@class='rz-header-search-input-text passive']")).sendKeys(product);
        driver.findElement(By.xpath("//button[@class='btn-link-i js-rz-search-button']")).click();
        driver.findElement(By.xpath("//button[@class='btn-link-i' and @type='submit']")).click();
        sleep(5000);
        //add normal wait
        Actualtext = driver.findElement(By.xpath("//h2[@class='cart-title']")).getText();
        Assert.assertEquals(Actualtext, "Вы добавили товар в корзину" );
    }
    @Test (priority = 3)
    public void EmptyCart(){
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath("//a[@class='hub-i-link hub-i-cart-link sprite-side whitelink']")).click();
        //driver.findElement(By.xpath("//div[@class='header-popup-cart-check hidden']")).click();
        Actualtext = driver.findElement(By.xpath("//h2[@class='empty-cart-title inline sprite-side']")).getText();
        Assert.assertEquals(Actualtext, "Корзина пуста" );
        //"//div[@class='wrap-cart-empty']"
    }
}
