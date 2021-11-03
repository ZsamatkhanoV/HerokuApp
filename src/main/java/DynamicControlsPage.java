import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage{
    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    private static final By CHECKBOX_BUTTON = By.xpath("//*[@id='checkbox']/input");
    private static final By REMOVE_BUTTON = By.xpath("//*[@id='checkbox-example']/button");
    private static final By TEXT_FROM_REMOVE = By.xpath("//*[@id='message']");
    private static final By INPUT_BUTTON = By.xpath("//*[@id='input-example']/input");
    private static final By ON_OFF_BUTTON = By.xpath("//*[@id='input-example']/button");

    public boolean checkboxDisplayed() {
        return driver.findElement(CHECKBOX_BUTTON).isDisplayed();
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
        waitForElementIsLocated(TEXT_FROM_REMOVE, 10);
    }

    public String removeButtonName() {
        return driver.findElement(REMOVE_BUTTON).getText();
    }

    public String textAfterClickButton() {
        return driver.findElement(TEXT_FROM_REMOVE).getText();
    }

    public boolean checkboxGone(){
        return driver.findElements(CHECKBOX_BUTTON).size() < 1;
    }

    public boolean inputDisplayed() {
        return driver.findElement(INPUT_BUTTON).isDisplayed();
    }

    public boolean inputEnabled() {
        return driver.findElement(INPUT_BUTTON).isEnabled();
    }

    public void clickOnOffButton() {
        driver.findElement(ON_OFF_BUTTON).click();
        waitForElementIsLocated(TEXT_FROM_REMOVE, 10);
    }

    public String buttonOnName() {
        return driver.findElement(ON_OFF_BUTTON).getText();
    }
}
