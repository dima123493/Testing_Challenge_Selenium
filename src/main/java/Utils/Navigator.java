package Utils;

import Pages.*;

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

    public static ChallengeFourPage openChallengeFourPage(){
        webDriver.navigate().to("http://testingchallenges.thetestingmap.org/challenge4.php");
        return initElements(webDriver, ChallengeFourPage.class);
    }

    public static ChallengeSixPage openChallengeSixPage(){
        webDriver.navigate().to("http://testingchallenges.thetestingmap.org/challenge6.php");
        return initElements(webDriver, ChallengeSixPage.class);
    }

}