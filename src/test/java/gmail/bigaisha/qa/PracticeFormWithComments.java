package gmail.bigaisha.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithComments {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practice() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[alt=\"adplus-dvertising\"]").click();

        $("#firstName").setValue("Bigaisha");
        $("#lastName").setValue("Shalabayeva");
        $("#userEmail").setValue("bigaisha@gmail.com");

//        $("#gender-radio-3").click(); // NOT WORKING
//        $("#gender-radio-3").doubleClick(); // BUT WHY?
//        $("#gender-radio-3").parent().click();
//        $("label[for=gender-radio-3]").click();
//        $(byText("Other")).click(); // BAD PRACTICE
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7023998900");
        $("#currentAddress").setValue("Samal-1-19-3");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1991");

//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--030")
//                .filter(not(cssClass(".react-datepicker__day--outside-month")))
//                .first() // or .get(0)
//                .click();
//        $("[aria-label=Choose Wednesday, July 30th, 2008]").click(); // NOT WORKING
//        $("[aria-label=\"Choose Wednesday, July 30th, 2008\"]").click();
//        $("[aria-label='Choose Wednesday, July 30th, 2008']").click();
        $("[aria-label$='November 5th, 1991']").click();

        //        $x("//*[contains(@aria-label, \"July 30th, 2008\")]").click();

// <div class="react-datepicker__day--030 react-datepicker__day--outside-month"  aria-label="Choose Monday, June 30th, 2008">30</div>
// <div class="react-datepicker__day--030"                                       aria-label="Choose Wednesday, July 30th, 2008">30</div>


        $("#subjectsInput").setValue("Eng");
        $("#subjectsWrapper").$(byText("English")).click();
//        $("#subjectsInput").setValue("M"); // todo Why not working
//        $("#subjectsWrapper").$(byText("Math")).click();

        $("#hobbiesWrapper").$(byText("Reading")).click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
//        File someFile = new File("src/test/resources/img/1.png");
//        $("#uploadPicture").uploadFile(someFile);


        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        sleep(5000);

        $(".table").shouldHave(
                text("Bigaisha Shalabayeva"), text("bigaisha@gmail.com"),
                text("Female"), text("7023998900"),
                text("05 November,1991"), text("English"),
                text("Reading"), text("1.png"),
                text("Samal-1-19-3"), text("NCR Delhi"),
                text("7023998900"), text("7023998900")
        );
    }
}



