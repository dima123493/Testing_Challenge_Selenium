package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utils.BrowserManager.webDriver;

public class ChallengeOnePage {
    @FindBy(id = "firstname")
    public WebElement firstNameField;
    @FindBy(name = "formSubmit")
    public static WebElement submitButton;
    @FindBy(className = "values-tested")
    public static WebElement counter;
    @FindBy(xpath = "//input[@name='user_right_as_admin']")
    public static WebElement hiddenField;

    public void submitFormWithValue(String value) {
        firstNameField.sendKeys(value);
        submitButton.click();
    }

    public static int getCounter() {
        return Integer.parseInt(counter.getText());
    }

    public static void javaScriptexecution() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.getElementsByName('user_right_as_admin')[0].setAttribute('type', '');");
        hiddenField.sendKeys("1");
        submitButton.click();
    }

}