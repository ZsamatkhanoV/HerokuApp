import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTest {

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
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0 ; i < 2; i++) {
            driver.findElement(By.xpath("//*[@onclick = 'addElement()']")).click();
        }
        driver.findElement(By.xpath("//*[@onclick = 'deleteElement()']")).click();
        int count = driver.findElements(By.className("added-manually")).size();
        Assert.assertEquals(count, 1);
        driver.quit();
    }
}