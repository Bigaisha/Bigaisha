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

    static String genter = "Female";
    static String subject = "English";
    static String hobby = "Reading";
    static String fileUrl = "img/1.png";
    static String fileName = "1.png";
    static String state = "NCR";
    static String city = "Delhi";

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
                    .selectGenter(genter)
                    .typePhoneNumber(phoneNumber)
                    .typeAddress(currentAddress)
                    .setBirthDate("05", "November", "1991")
                    .selectSubject("Eng", subject)
                    .selectHobbies(hobby)
                    .uploadFiles(fileUrl)
                    .selectState(state)
                    .selectCity(city)
                    .clickSubmit();
           registrationPage.checkResultsValue("Student Name", firstName +" "+ lastName)
                            .checkResultsValue("Student Email", email)
                            .checkResultsValue("Gender", genter)
                            .checkResultsValue("Mobile", phoneNumber)
                            .checkResultsValue("Date of Birth", "05 November,1991")
                            .checkResultsValue("Subjects", subject)
                            .checkResultsValue("Hobbies", hobby)
                            .checkResultsValue("Picture", fileName)
                            .checkResultsValue("Address", currentAddress)
                            .checkResultsValue("State and City", state + " " + city);
    }
}



