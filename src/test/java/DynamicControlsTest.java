import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest{

    private static final String TEXT_UNDER_CHECKBOX = "It's gone!";
    private static final String TEXT_UNDER_INPUT = "It's enabled!";
    private static final String TEXT_REMOVE_BUTTON = "Add";
    private static final String TEXT_ENABLED_BUTTON = "Disable";

    @Test
    public void findCheckboxTest() {
        dynamicControlsPage.openPage("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertTrue(dynamicControlsPage.checkboxDisplayed());
    }

    @Test
    public void messageUnderCheckboxTest() {
        dynamicControlsPage.openPage("http://the-internet.herokuapp.com/dynamic_controls");
        dynamicControlsPage.clickRemoveButton();
        Assert.assertEquals(dynamicControlsPage.textAfterClickButton(),TEXT_UNDER_CHECKBOX);
        Assert.assertEquals(dynamicControlsPage.removeButtonName(), TEXT_REMOVE_BUTTON);
    }

    @Test
    public void removeButtonClickIfCheckboxNotDisplayedTest() {
        dynamicControlsPage.openPage("http://the-internet.herokuapp.com/dynamic_controls");
        dynamicControlsPage.clickRemoveButton();
        Assert.assertTrue(dynamicControlsPage.checkboxGone());
    }

    @Test
    public void displayedInputTest() {
        dynamicControlsPage.openPage("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertFalse(dynamicControlsPage.inputDisplayed());
    }

    @Test
    public void disabledInputTest() {
        dynamicControlsPage.openPage("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertFalse(dynamicControlsPage.inputEnabled());
    }

    @Test
    public void textUnderInputTest() {
        dynamicControlsPage.openPage("http://the-internet.herokuapp.com/dynamic_controls");
        dynamicControlsPage.clickOnOffButton();
        Assert.assertEquals(dynamicControlsPage.textAfterClickButton(), TEXT_UNDER_INPUT);
        Assert.assertEquals(dynamicControlsPage.buttonOnName(), TEXT_ENABLED_BUTTON);
    }

    @Test
    public void enabledInputTest() {
        dynamicControlsPage.openPage("http://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertFalse(dynamicControlsPage.inputEnabled());
    }
}

