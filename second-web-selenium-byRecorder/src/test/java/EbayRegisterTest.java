

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayRegisterTest {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   // driver.manage().window().maximize();
  }

  @Test
  public void testEbayRegister() {

    openSite();

    goToRegisterPage();

    typeName();

    typeLastName();

    typeEmail();

    typePassword();
  }

  public void goToRegisterPage() {
    driver.findElement(By.linkText("register")).click();
  }

  public void typePassword() {
    driver.findElement(By.id("PASSWORD")).click();
    driver.findElement(By.id("PASSWORD")).clear();
    driver.findElement(By.id("PASSWORD")).sendKeys("KantorRisha1");
  }

  public void typeEmail() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("KantorRisha+1@gmail.com");
  }

  public void typeLastName() {
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Kantor");
  }

  public void typeName() {
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Irina");
  }

  public void openSite() {
    driver.get("https://www.ebay.com/");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
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


    }
