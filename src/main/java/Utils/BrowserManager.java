package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {

    public static WebDriver webDriver;

    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public static void closeBrowser(){
        webDriver.quit();
    }

}
