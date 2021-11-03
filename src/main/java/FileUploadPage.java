import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    private static final By FILE_UPLOAD = By.xpath("//*[@id='file-upload']");
    private static final By FILE_UPLOAD_BUTTON = By.xpath("//*[@id='file-submit']");
    private static final By CONFIRMATION_TEXT = By.xpath("//h3");
    private static final By ERROR_TEXT = By.xpath("//h1");
    private static final By FILE_NAME = By.xpath("//*[@id='uploaded-files']");

    public void fileDirectory(String path) {
        driver.findElement(FILE_UPLOAD).sendKeys(path);
    }

    public void uploadAndConfirmation() {
        driver.findElement(FILE_UPLOAD_BUTTON).click();
        waitForElementIsLocated(CONFIRMATION_TEXT, 10);
    }

    public void uploadEmptyFile() {
        driver.findElement(FILE_UPLOAD_BUTTON).click();
        waitForElementIsLocated(ERROR_TEXT, 10);
    }

    public String getConfirmationText() {
        return driver.findElement(CONFIRMATION_TEXT).getText();
    }

    public String getFileNameText() {
        return driver.findElement(FILE_NAME).getText();
    }

    public String getErrorText() {
        return driver.findElement(ERROR_TEXT).getText();
    }
}
