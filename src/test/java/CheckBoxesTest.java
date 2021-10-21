import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckBoxesTest {

    @Test

    public void addRemoveElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement removeBox1 = driver.findElement(By.cssSelector("input:nth-child(1)"));
        Assert.assertFalse(removeBox1.isSelected());
        removeBox1.click();
        Assert.assertTrue(removeBox1.isSelected());
        WebElement removeBox2 = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > input:nth-child(3)"));
        Assert.assertTrue(removeBox2.isSelected());
        removeBox2.click();
        Assert.assertFalse(removeBox2.isSelected());
        driver.quit();
    }
}
