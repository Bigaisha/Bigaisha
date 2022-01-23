package gmail.bigaisha.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import gmail.bigaisha.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormWithDSL() {
        registrationPage
                        .openPage()
                        .typeFirstName("Bigaisha")
                        .typeLastName("Shalabayeva");
        $("#userEmail").setValue("bigaisha@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7023998900");
        $("#currentAddress").setValue("Samal-1-19-3");
        registrationPage.setBirthDate("05", "November", "1991");
        $("#subjectsInput").setValue("Eng");
        $("#subjectsWrapper").$(byText("English")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.checkResultsValue("Student Name", "Bigaisha Shalabayeva");
        $(".table").shouldHave(
                text("Bigaisha Shalabayeva"), text("bigaisha@gmail.com"),
                text("Female"), text("7023998900"),
                text("05 November,1991"), text("English"),
                text("Reading"), text("1.png"),
                text("Samal-1-19-3"), text("NCR Delhi")
        );

    }
}



