package gmail.bigaisha.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @Test

    void successTest() {
        open( "https://demoqa.com/text-box");

        $("#userName").setValue("Bigaisha");
        $("#userEmail").setValue("bigaisha@gmail.com");
        $("#currentAddress").setValue("Almaty");
        $("#permanentAddress").setValue("Alma-Ata");
        $("#submit").scrollTo().click();

        $("#output").shouldBe(visible);
        $("#name").shouldHave(text("Bigaisha"));
        $("#email").shouldHave(text("bigaisha@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Almaty"));
        $("#output").$("#permanentAddress").shouldHave(text("Alma-Ata"));
    }
}
