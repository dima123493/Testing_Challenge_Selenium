import Pages.ChallengeOnePage;
import Pages.ChallengeTwoPage;
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
        String [] values = new String[17];
        values[0] = "Dmytro";
        values[1] = "D";
        values[3] = "maxLengthqqqqqqqqqqqqqqqqqqqqq";
        values[2] = "moreThenMaxLengthqqqqqqqqqqqqqq";
        values[4] = "";
        values[5] = " ";
        values[6] = " SpaceInTheFront";
        values[7] = "SpaceInThe Middle";
        values[8] = "SpaceInTheEnd ";
        values[9] = "£";
        values[10] = "%&*";
        values[11] = "'basic sql'";
        values[12] = "<li></li>";
        values[13] = "oi32jnxd42390slk345";
        values[14] = "detailsoverviewnow.css";
        values[15] = "dfjwGGe82H43g3uRiy53h";
        values[16] = "<script>alert(\"I hacked this!”)</script>";

        ChallengeOnePage page = Navigator.openChallengeOnePage();
        for (String insertValue : values) {
            page.submitFormWithValue(insertValue);
        }
        ChallengeOnePage.javaScriptexecution();
        assertEquals(ChallengeOnePage.getCounter(), 18);

/*1)     ChallengeOnePage challengeOnePage =  Navigator.openChallengeOnePage().submitFormWithValue("Dmytro");
       assertEquals(challengeOnePage.getCounter(), 1);
       assertEquals(challengeOnePage.getCheckValue(),"Average value","Value is incorrect");*/

/*2)    ChallengeOnePage page = Navigator.openChallengeOnePage();
        Arrays.stream(values).forEach(page::submitFormWithValue);
        assertEquals(ChallengeOnePage.getCounter(), values.length-1);*/
    }

    @Test
    public void ChallengeTwoTest(){
        ChallengeTwoPage page = Navigator.openChallengeTwoPage();
        page.changeFieldType();
        page.submitFieldWithValue("This is string field now!");
        assertEquals(page.verifyTheResult(),"YOU HAVE DONE IT. Please enter your name.");
    }

    @AfterMethod
    public void after(){
    BrowserManager.closeBrowser();
    }

}