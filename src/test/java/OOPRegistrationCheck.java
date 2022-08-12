import Pages.ChallengeOnePage;
import Utils.BrowserManager;
import Utils.Navigator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class OOPRegistrationCheck {

    @BeforeMethod
    public void before(){
        BrowserManager.openBrowser();
    }

    @Test
    public void challengeOneTest(){
        String [] arr = new String[8];
        arr[0] = "D";
        arr[1] = "\".\"";
        arr[2] = " ";
        arr[3] = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        arr[4] = "15";
        arr[5] = " hjhhg";
        arr[6] = "sdfd ";
        arr[7] = " jhjh ";

/* 1)  ChallengeOnePage challengeOnePage =  Navigator.openChallengeOnePage().submitFormWithValue("Dmytro");
       assertEquals(challengeOnePage.getCounter(), 1);
       assertEquals(challengeOnePage.getCheckValue(),"Average value","Value is incorrect");*/

        ChallengeOnePage page = Navigator.openChallengeOnePage();
        for (String s : arr) {
            page.submitFormWithValue(s);
        }
        assertEquals(page.getCounter(), 7);

/*    ChallengeOnePage page = Navigator.openChallengeOnePage();
        Arrays.stream(arr).forEach(page::submitFormWithValue);
        assertEquals(ChallengeOnePage.getCounter(), arr.length-1);*/

    }

    @AfterMethod
    public void after(){
    BrowserManager.closeBrowser();
    }

}
