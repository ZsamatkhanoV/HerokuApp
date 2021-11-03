import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{

    private static final String TEXT_IN_FRAME = "Your content goes here.";

    @Test
    public void checkIframePageIsOpenedTest() {
        framesPage.openPage("http://the-internet.herokuapp.com/frames");
        framesPage.openIframe();
        Assert.assertTrue(framesPage.titleDisplayed());
    }

    @Test
    public void checkTextInField() {
        framesPage.openPage("http://the-internet.herokuapp.com/frames");
        framesPage.openIframe();
        Assert.assertEquals(framesPage.iFrameBoxText(), TEXT_IN_FRAME);
    }
}
