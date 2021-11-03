import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage{
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    private static final By FRAME_BUTTON = By.xpath("//a[contains(text(), 'iFrame')]");
    private static final By FRAME_TITLE = By.xpath("//h3");
    private static final By FRAME_FIELD = By.xpath("//*[@id='mce_0_ifr']");
    private static final By TEXT_IN_FRAME = By.xpath("//*[@id='tinymce']");

    public void openIframe() {
        driver.findElement(FRAME_BUTTON).click();
    }

    public boolean titleDisplayed() {
        return driver.findElement(FRAME_TITLE).isDisplayed();
    }

    public String iFrameBoxText() {
        driver.switchTo().frame(driver.findElement(FRAME_FIELD));
        return driver.findElement(TEXT_IN_FRAME).getText();
    }


}
