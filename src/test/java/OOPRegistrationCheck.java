import Pages.*;
import Utils.BrowserManager;
import Utils.Navigator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class OOPRegistrationCheck {

    @BeforeMethod
    public void before() {
        BrowserManager.openBrowser();
    }

    @Test
    public void challengeOneTest() {
        String[] values = new String[]{
                "Dmytro",
                "D",
                "maxLengthqqqqqqqqqqqqqqqqqqqqq",
                "moreThenMaxLengthqqqqqqqqqqqqqq",
                "",
                " ",
                " SpaceInTheFront",
                "SpaceInThe Middle",
                "SpaceInTheEnd ",
                "%&*",
                "£",
                "'basic sql'",
                "<li></li>",
                "oi32jnxd42390slk345",
                "detailsoverviewnow.css",
                "dfjwGGe82H43g3uRiy53h",
                "<script>alert(\"I hacked this!”)</script>"};

        ChallengeOnePage page = Navigator.openChallengeOnePage();
        for (int i = 0; i < values.length; i++) {
            page.submitFormWithValue(values[i]);
            assertThat(ChallengeOnePage.getCounter()).isEqualTo(i + 1);
        }
        ChallengeOnePage.javaScriptexecution();
        assertEquals(ChallengeOnePage.getCounter(), 18);

/*0)       for (String insertValue : values) {
           page.submitFormWithValue(insertValue);
        }
        ChallengeOnePage.javaScriptexecution();
        assertEquals(ChallengeOnePage.getCounter(), 18);*/

/*1)     ChallengeOnePage challengeOnePage =  Navigator.openChallengeOnePage().submitFormWithValue("Dmytro");
       assertEquals(challengeOnePage.getCounter(), 1);
       assertEquals(challengeOnePage.getCheckValue(),"Average value","Value is incorrect");*/

/*2)    ChallengeOnePage page = Navigator.openChallengeOnePage();
        Arrays.stream(values).forEach(page::submitFormWithValue);
        assertEquals(ChallengeOnePage.getCounter(), values.length-1);*/
    }

    @Test
    public void ChallengeTwoTest() {
        ChallengeTwoPage page = Navigator.openChallengeTwoPage();
        page.changeFieldType();
        page.submitFieldWithValue("This is string field now!");
        assertEquals(page.verifyTheResult(), "YOU HAVE DONE IT. Please enter your name.");
    }

    @Test
    public void ChallengeFourTest() {
/*              LocalDate[] birthLocalDates = new LocalDate[] {
                LocalDate.of(1995, 11, 7)
        };
        String[] birthDate = new String[]{
                "07.11.1995",
                "13.06.2001",
                "08.09.1999",
                "01.01.2000",
                "30.07.2022"};
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yy");
        LocalDate[] birthLocalDates = Arrays.stream(birthDate)
                .map(str -> LocalDate.parse(str, format))
                .toArray(LocalDate[]::new);*/

        ChallengeFourPage page = Navigator.openChallengeFourPage();
        final int attempts = 5;
        for (int i = 1; i <= attempts - 1; i++) {
            page.inputField.sendKeys(page.generateCNP());
            page.submitButton.click();
            assertThat(page.verifyTheResult()).isEqualTo(i);
        }
        page.inputField.sendKeys(page.generateCNP());
        page.submitButton.click();
        assertThat(ChallengeFourPage.correctSubmission.getText())
                .contains("YOU HAVE DONE IT. Please enter your name.");
/*        page.cnpNumberCheck("07.11.1995");
        assertEquals(page.validation.getText(), "1");
        page.cnpNumberCheck("13.06.2001");
        assertEquals(page.validation.getText(), "2");
        page.cnpNumberCheck("08.09.1999");
        assertEquals(page.validation.getText(), "3");
        page.cnpNumberCheck("01.01.2000");
        assertEquals(page.validation.getText(), "4");
        page.cnpNumberCheck("30.07.2022");
        assertEquals(page.verifyTheResult(), "YOU HAVE DONE IT. Please enter your name.");*/
    }

    @Test
    public void ChallengeSixTest() {
        ChallengeSixPage page = Navigator.openChallengeSixPage();
        String[] invalidData = new String[]{
                "31/12/2016 23:59",
                "11/00/2017 1:34",
                "01/01/2017 00:00",
                "01/01/2017 00:60",
                "01/01/2017 24:00",
                "29/02/2017 00:00",
                "00/09/2017 1:35",
                "31/09/2017 1:28",
                "32/12/2017 1:28",
                "11/13/2017 1:33",
                "01/01/2018 00:00"};
        for (int i = 0; i < invalidData.length; i++) {
            page.invalidDataCheck(invalidData[i]);
            assertThat(ChallengeSixPage.verifyTheResult()).isEqualTo(i + 1);
        }
       /* page.invalidDataCheck("31/12/2016 23:59");
        assertEquals(page.verifyTheResult(), "1");
        page.invalidDataCheck("11/00/2017 1:34");
        assertEquals(page.verifyTheResult(), "2");
        page.invalidDataCheck("01/01/2017 00:00");
        assertEquals(page.verifyTheResult(), "3");
        page.invalidDataCheck("01/01/2017 00:60");
        assertEquals(page.verifyTheResult(), "4");
        page.invalidDataCheck("01/01/2017 24:00");
        assertEquals(page.verifyTheResult(), "5");
        page.invalidDataCheck("29/02/2017 00:00");
        assertEquals(page.verifyTheResult(), "6");
        page.invalidDataCheck("00/09/2017 1:35");
        assertEquals(page.verifyTheResult(), "7");
        page.invalidDataCheck("31/09/2017 1:28");
        assertEquals(page.verifyTheResult(), "8");
        page.invalidDataCheck("32/12/2017 1:28");
        assertEquals(page.verifyTheResult(), "9");
        page.invalidDataCheck("11/13/2017 1:33");
        assertEquals(page.verifyTheResult(), "10");
        page.invalidDataCheck("01/01/2018 00:00");
        assertEquals(page.verifyTheResult(), "11");*/
    }

    @AfterMethod
    public void after() {
        BrowserManager.closeBrowser();
    }

}