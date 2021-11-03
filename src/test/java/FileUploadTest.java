import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{

    private static final String CONFIRM_MESSAGE = "File Uploaded!";
    private static final String ERROR_MESSAGE = "Internal Server Error";
    private static final String FILE_PATH = "D:\\logo_2.jpg";
    private static final String FILE_NAME = "logo_2.jpg";

    @Test
    public void uploadFileTest () {
        fileUploadPage.openPage("http://the-internet.herokuapp.com/upload");
        fileUploadPage.fileDirectory(FILE_PATH);
        fileUploadPage.uploadAndConfirmation();
        Assert.assertEquals(fileUploadPage.getConfirmationText(), CONFIRM_MESSAGE);
        Assert.assertEquals(fileUploadPage.getFileNameText(), FILE_NAME);
    }

    @Test
    public void uploadWithoutFileTest() {
        fileUploadPage.openPage("http://the-internet.herokuapp.com/upload");
        fileUploadPage.uploadEmptyFile();
        Assert.assertEquals(fileUploadPage.getErrorText(), ERROR_MESSAGE);
    }
}
