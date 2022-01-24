package gmail.bigaisha.pages.components;

import org.openqa.selenium.devtools.v85.runtime.model.StackTraceId;

import java.sql.Struct;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {

    public void setDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
//        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
//        $("[aria-label$='" + month + " " + day + "th, "+ year + "']").click();
        String dayLocater = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayLocater).click();
    }
}
