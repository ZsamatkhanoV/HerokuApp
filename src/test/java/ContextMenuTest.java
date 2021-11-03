import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{

    private static final String ALERT_TEXT = "You selected a context menu";

    @Test
    public void clickContextField() {
        contextMenuPage.openPage("http://the-internet.herokuapp.com/context_menu");
        contextMenuPage.pressContextField();
        contextMenuPage.getAlertMessage();
        Assert.assertEquals(contextMenuPage.getAlertMessage(), ALERT_TEXT);
        contextMenuPage.closeAlertMessage();
    }
}
