package Utils;

import Pages.ChallengeOnePage;
import Pages.ChallengeTwoPage;

import static Utils.BrowserManager.webDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class Navigator {
    public static ChallengeOnePage openChallengeOnePage(){
        webDriver.navigate().to("http://testingchallenges.thetestingmap.org");
        return initElements(webDriver,ChallengeOnePage.class);
    }

    public static ChallengeTwoPage openChallengeTwoPage(){
        webDriver.navigate().to("http://testingchallenges.thetestingmap.org/challenge2.php");
        return initElements(webDriver, ChallengeTwoPage.class);
    }

}