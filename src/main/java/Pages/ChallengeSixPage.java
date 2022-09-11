package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;

public class ChallengeSixPage {
    @FindBy(className = "inputbox")
    public WebElement inputField;

    @FindBy(xpath = "//input[@name='formSubmit']")
    public WebElement submitButton;

    @FindBy(className = "values-tested")
    public static WebElement validation;

    public void invalidDataCheck(String data) {
        inputField.click();
        inputField.clear();
        inputField.sendKeys(data);
        submitButton.click();
    }

    public static int verifyTheResult() {
        return parseInt(validation.getText());
    }

}
