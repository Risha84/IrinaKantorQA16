

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trello {
  private WebDriver driver;
//driver.findElement(By.linkTest("Sign in"))
  @BeforeClass(alwaysRun = true)
  public void setUp()  {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTrello()  {
    openSite();
    //driver.findElement(By.linkText("Зарегистрироваться")).click();
    driver.findElement(By.xpath("//*[@href='/signup']")).click();
    fillNameField();

    fillEmailField();

    fillPasswordField();

    clickOnSignButton();
    driver.findElement(By.linkText("Войти")).click();
  }

  public void clickOnSignButton() {
    driver.findElement(By.id("signup")).click();
  }

  public void fillPasswordField() {
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("!333960!");
  }

  public void fillEmailField() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("KantorRisha@gmail.com");
  }

  public void fillNameField() {
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Risha");
  }

  public void openSite() {
    driver.get("https://trello.com/");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    Thread.sleep(3000);
    driver.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
   }
  }
