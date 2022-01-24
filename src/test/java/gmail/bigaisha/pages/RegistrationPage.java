package gmail.bigaisha.pages;

import com.codeborne.selenide.SelenideElement;
import gmail.bigaisha.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            addressInput = $("#currentAddress"),
            genderInput = $("#genterWrapper"),
            hobbiesInput = $("#hobbiesWrapper"),
            subjectInput = $("#subjectsInput"),
            subjectWrapper = $("#subjectsWrapper"),
            uploadFile = $("#uploadPicture"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            resultsTable =  $(".table-responsive");


    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage (){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[alt=\"adplus-dvertising\"]").click();

        return this;
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
//      public void typeFirstName(String value){
//        firstNameInput.setValue(value);
    }

    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage typePhoneNumber(String value){
        numberInput.setValue(value);
        return this;
    }
    public RegistrationPage typeAddress (String value){
        addressInput.setValue(value);
        return this;
    }
    public RegistrationPage selectGenter (String value){
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage selectHobbies (String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectSubject (String value, String fullValue){
        subjectInput.setValue(value);
        subjectWrapper.$(byText(fullValue)).click();
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage uploadFiles (String value){
        uploadFile.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage selectState (String value){
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage selectCity (String value){
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value){
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
