package Utils;

import Pages.ChallengeOnePage;

import static Utils.BrowserManager.webDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class Navigator {
    public static ChallengeOnePage openChallengeOnePage(){
        webDriver.navigate().to("http://testingchallenges.thetestingmap.org");
        return initElements(webDriver,ChallengeOnePage.class);
    }
}
