import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationCheckNoOOP {

    private WebDriver webDriver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver0.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void challengeOneTest(){
        webDriver.navigate().to("http://testingchallenges.thetestingmap.org");
        webDriver.findElement(By.id("firstname")).sendKeys("Dmytro");
        webDriver.findElement(By.name("formSubmit")).click();
        String counter = webDriver.findElement(By.className("values-tested")).getText();
        String text = webDriver.findElement(By.xpath("//ul[@class='values-description t10']/li")).getText();

        assertEquals(counter,"1");
        assertEquals(text,"Average value","Value is incorrect");
}

    @AfterMethod
    public void after(){
        webDriver.quit();
    }

}
