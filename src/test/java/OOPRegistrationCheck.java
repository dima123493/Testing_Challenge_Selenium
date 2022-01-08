import Pages.ChallengeOnePage;
import Utils.BrowserManager;
import Utils.Navigator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OOPRegistrationCheck {

    @BeforeMethod
    public void before(){
        BrowserManager.openBrowser();
    }

    @Test
    public void challengeOneTest(){
        ChallengeOnePage challengeOnePage =  Navigator.openChallengeOnePage().submitFormWithValue("Dmytro");

        assertEquals(challengeOnePage.getCounter(),1);
        assertEquals(challengeOnePage.getCheckValue(),"Average value","Value is incorrect");
    }

    @AfterMethod
    public void after(){
    BrowserManager.closeBrowser();
    }

}
