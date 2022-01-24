package gmail.bigaisha.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import gmail.bigaisha.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static gmail.bigaisha.utils.RandomUtils.getRandomEmail;
import static gmail.bigaisha.utils.RandomUtils.getRandomString;

public class PracticeFormWithFaker {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.number().digits(10);
//    String currentAddress = faker.lebowski().quote();
    String currentAddress = faker.gameOfThrones().house();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practice() {
            registrationPage
                    .openPage()
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeEmail(email)
                    .typePhoneNumber(phoneNumber)
                    .typeAddress(currentAddress);
            registrationPage.setBirthDate("05", "November", "1991");
        $("#genterWrapper").$(byText("Female")).click();
        $("#subjectsInput").setValue("Eng");
        $("#subjectsWrapper").$(byText("English")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.checkResultsValue("Student Name", firstName +" "+ lastName);
        $(".table").shouldHave(
                text(email), text("Female"), text(phoneNumber),
                text("05 November,1991"), text("English"),
                text("Reading"), text("1.png"),
                text(currentAddress), text("NCR Delhi")
        );
    }
}



