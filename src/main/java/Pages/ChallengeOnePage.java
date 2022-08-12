package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengeOnePage {

    @FindBy(id = "firstname")
    public WebElement firstNameField;
    @FindBy(name = "formSubmit")
    public WebElement submitButton;
    @FindBy(className = "values-tested")
    public static WebElement counter;
    @FindBy(xpath = "//ul[@class='values-description t10']/li")
    public WebElement checkValue;

    public ChallengeOnePage submitFormWithValue(String value) {
        firstNameField.sendKeys(value);
        submitButton.click();
        return this;
    }

    public static int getCounter() {
        return Integer.parseInt(counter.getText());
    }

    public String getCheckValue() {
        return checkValue.getText();
    }
}
