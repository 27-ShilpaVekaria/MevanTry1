package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.soap.Text;
import java.util.concurrent.TimeUnit;

public class Register
{
    static WebDriver driver;
    public static void clickOnElement(By by)//
    {
        driver.findElement(by).click();
    }
    public static void clickOnLink(By by)
    {
        driver.findElement(by).click();
    }
    public static void typeText(By by,String text)
    {
      driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();

    }
    public static void selectDropDownByIndex(By by, int text2)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(text2);
    }

    public static void selectDropdownByValue(By by, String value1)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value1);
    }

    public static void selectByVisibleText(By by, String text1)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text1);
    }
    private static void gettext1(By by,String actualText1)
    {
        selectByVisibleText(by, actualText1);
    }
    public static long timestamp()
    {
        return (System.currentTimeMillis());
    }

        @BeforeMethod
        public static void startMethod ()
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            driver.get("https://demo.nopcommerce.com/");
        }
   @AfterMethod
    public static void closingMethod()
   {
        driver.close();
   }


        @Test
        public void NopcommerceRegister () {
            startMethod();

            clickOnLink(By.xpath("//a[text()=\"Register\"]"));
            clickOnLink(By.xpath("//div[@class=\"gender\"]/span[2] "));
            driver.findElement(By.id("FirstName")).sendKeys("Shilpa");
            driver.findElement(By.id("LastName")).sendKeys("Vekaria");
            selectDropDownByIndex(By.xpath("//select[@name=\"DateOfBirthDay\"]"), 31);
            selectByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "March");
            selectDropdownByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "2011");
            typeText(By.xpath("//input[@id=\"Email\"]"), "abc@gmail.com");
            String Email = "test+" + timestamp() + "@gmail.com";
            System.out.println("test+" + timestamp() + "@gmail.com");
            closingMethod();
        }

         @Test
        public void userShouldBeAbleToReferAProductToFriendSuccessfully();
            {
                startMethod();
                clickOnElement(By.xpath("//a[text()=\"Computers\"]"));
                clickOnElement(By.xpath("//a[text()=\"Desktops\"]"));
                clickOnElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC"));
                clickOnElement(By.xpath("//input[@value=\"Email a friend\"]"));
                clickOnElement(By.xpath("//input[@name=\"send-email\"]"));
                typeText(By.xpath("//input[@placeholder=\"Enter friend's email.\"]"), "xyz@gmail.com");
                typeText(By.xpath("//input[@placeholder=\"Enter your email address."), "abc@gmail.com");
                typeText(By.xpath("//textarea[@name=\"PersonalMessage\"]"), "This product is recomended");
                String expectedtext = "Your message hass been sent.";//variable expectedtext defined
                String actualtext = gettext1(By.xpath("//div[@class=\"result\"]"), "");
                Assert.assertEquals(actualtext, expectedtext, "expected match with actual");
                closingMethod();
            }

        @Test
        public void userShouldBeAbleToAddProductToBasketSuccessfully ();
        {
            startMethod();
            clickOnElement(By.xpath("//div[2][@class=\"header-menu\"]/ul/li[5]/a[1]"));
            clickOnElement(By.xpath("//input[contains(@onclick,\"37/1/1\")]"));
            clickOnElement(By.xpath("//input[contains(@onclick,\"39/1/1\")]"));
            clickOnElement(By.xpath("//span[ text()=\"Shopping cart\"]"));

            closingMethod();

        }
}



