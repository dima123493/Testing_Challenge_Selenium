package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class ChallengeFourPage {
    static final Random RND = new Random(42);
    private static int randomInt(int from, int upTo) {
        return from + RND.nextInt(upTo - from);
    }

    @FindBy(className = "inputbox")
    public WebElement inputField;
    @FindBy(xpath = "//input[@name='formSubmit']")
    public WebElement submitButton;
    @FindBy(className = "values-tested")
    public WebElement validation;
    @FindBy(xpath = "//font[normalize-space()='YOU HAVE DONE IT. Please enter your name.']")
    public static WebElement correctSubmission;

    public String generateCNP() {
        String base = generateCNP12baseDigits();
        return base + calculateControlDigit(base);
    }

/*    boolean validateCNP(String cnp) {
        if (cnp.length() != 13) {
            throw new IllegalArgumentException();
        }
        String base = cnp.substring(0, 12);
        String controlDigit = calculateControlDigit(base);
        return controlDigit.equals(cnp.substring(12));
    }*/

    private String calculateControlDigit(String base) {
        if (base.length() != 12) {
            throw new IllegalArgumentException();
        }
        final String vector = "279146358279";
        int sum = 0;
        for (int i = 0; i < vector.length(); i++) {
            sum += (base.charAt(i) - '0') * (vector.charAt(i) - '0');
        }
        sum %= 11;
        sum = sum == 10 ? 1 : sum;
        return String.valueOf(sum);
    }

/*    String generate3digitNumber() {
        return String.format("%03d", new Random().nextInt(0, 1000));
    }*/

    String generateCNP12baseDigits() {
        int year = randomInt(1800,2100);
        int day = randomInt(1, 366);
        LocalDate birthDate = LocalDate.ofYearDay(year, day);
        int first = randomInt(1, 10);
        int areaNumber = randomInt(1, 53);
        String date = birthDate.format(DateTimeFormatter.ofPattern("yyMMdd"));
        int orderNumber = RND.nextInt(1000);
        return String.format("%d%s%02d%03d",
                first, date, areaNumber, orderNumber);
    }

/*    public void cnpNumberCheck(String birthDate) {
        int regionGenerator = ThreadLocalRandom.current().nextInt(1, 10);

        String[] dateArray = birthDate.split("");
        int year1 = parseInt(dateArray[8]);
        int year2 = parseInt(dateArray[9]);
        int month1 = parseInt(dateArray[3]);
        int month2 = parseInt(dateArray[4]);
        int day1 = parseInt(dateArray[0]);
        int day2 = parseInt(dateArray[1]);

        List<Integer> number = new ArrayList<>();
        number.add(regionGenerator);
        number.add(year1);
        number.add(year2);
        number.add(month1);
        number.add(month2);
        number.add(day1);
        number.add(day2);

        int randomAreaNumber = ThreadLocalRandom.current().nextInt(1, 53);
        String newRandomAreaNumber = "";
        newRandomAreaNumber = "" + randomAreaNumber;
*//*        if (randomAreaNumber == 0) {
            ThreadLocalRandom.current().nextInt(52);
        }
        if (randomAreaNumber > 0 && randomAreaNumber < 10) {
            newRandomAreaNumber = "0" + randomAreaNumber;
        } else {
            newRandomAreaNumber = "" + randomAreaNumber;
        }*//*
        String[] str = newRandomAreaNumber.split("");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
            number.add(arr[i]);
        }

        int orderNumber = ThreadLocalRandom.current().nextInt(999);
        String newRandomOrderNumber = "";
        if (orderNumber < 10) {
            newRandomOrderNumber = "00" + orderNumber;
        }
        if (orderNumber >= 10 && orderNumber < 100) {
            newRandomOrderNumber = "0" + orderNumber;
        } else {
            newRandomOrderNumber = "" + orderNumber;
        }

        String[] str1 = newRandomOrderNumber.split("");
        int[] arr1 = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
            number.add(arr1[i]);
        }

        List<Integer> controlNumber = Arrays.stream("279146358279".split(""))
                .map(s -> s.charAt(0) - '0').collect(Collectors.toList());
//        controlNumber.add(2);
//        controlNumber.add(7);
//        controlNumber.add(9);
//        controlNumber.add(1);
//        controlNumber.add(4);
//        controlNumber.add(6);
//        controlNumber.add(3);
//        controlNumber.add(5);
//        controlNumber.add(8);
//        controlNumber.add(2);
//        controlNumber.add(7);
//        controlNumber.add(9);

        int sum = 0;
        for (int i = 0; i < controlNumber.size(); i++) {
            sum += controlNumber.get(i) * number.get(i);
        }
        int result = sum % 11;
        if (result == 10) {
            result = 1;
        }
        number.add(result);
        String finalNumber = number.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        inputField.sendKeys(finalNumber);
        submitButton.click();
    }*/

    public int verifyTheResult() {
        return parseInt(validation.getText());
    }

}
// 1 digit - (1-9)
// 2 digit - last 2 digits of the birth year
// 2 digit - 2 digit of the month of birth
// 2 digit - 2 digit of the day of birth
// 2 digit - (random number) 01-52 included
// 3 digit - (random number) 000-999 included
// 1 step - multiply result number on the control number
// 2 step - sum numbers from the step 1 and (% 11) = result = last digit