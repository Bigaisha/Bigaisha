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
            thirdNameInput = $("#lastName"),
            resultsTable =  $(".table-responsive");

    public CalendarComponent calendarComponent = new СalendarComponent();

//    $("#firstName").setValue("Bigaisha");
//    $("#lastName").setValue("Shalabayeva");

    public RegistrationPage openPage (){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[alt=\"adplus-dvertising\"]").click();

        return this;
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
//
//    public void typeFirstName(String value){
//        firstNameInput.setValue(value);
//    }

    public RegistrationPage typeThirdName(String value){
        thirdNameInput.setValue(value);
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value){
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
