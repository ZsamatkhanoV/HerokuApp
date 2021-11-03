import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage{
    ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    private static final By CONTEXT_MENU = By.xpath("//*[@id='hot-spot']");

    public void pressContextField() {
        Actions actions = new Actions(driver);
        WebElement rightClick = driver.findElement(CONTEXT_MENU);
        actions.contextClick(rightClick).perform();
        waitForAlert(10);
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }

    public void closeAlertMessage() {
        driver.switchTo().alert().accept();
    }
}
