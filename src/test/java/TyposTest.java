import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TyposTest {

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
        driver.get("https://the-internet.herokuapp.com/typos");
        String elementTest1 = driver.findElement(By.cssSelector("div > p:nth-of-type(1)")).getText();
        System.out.println(elementTest1);
        String elementTest2 = driver.findElement(By.cssSelector("div > p:nth-of-type(2)")).getText();
        System.out.println(elementTest2);
        Assert.assertEquals(elementTest1, "This example demonstrates a typo being introduced. It does it randomly on each page load.");
        Assert.assertEquals(elementTest2, "Sometimes you'll see a typo, other times you won't.");
        driver.quit();
    }
}
