package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utils.BrowserManager.webDriver;

public class ChallengeTwoPage {
    @FindBy(xpath = "//input[@name='valuesadded']")
    public static WebElement field;

    @FindBy(xpath = "//input[@name='formSubmit']")
    public static WebElement submitButton;

    @FindBy(xpath = "//font[normalize-space()='YOU HAVE DONE IT. Please enter your name.']")
    public static WebElement correctSubmission;

    public void changeFieldType() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.querySelector(\"input[type='number']\").setAttribute('type', 'string');");
    }
    //getElementsByName(valuesadded)
    public void submitFieldWithValue(String submitFieldWithValue) {
        field.sendKeys(submitFieldWithValue);
        submitButton.click();
    }

    public String verifyTheResult() {
        return correctSubmission.getText();
    }

}