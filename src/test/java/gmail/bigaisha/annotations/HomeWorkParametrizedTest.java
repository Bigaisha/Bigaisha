package gmail.bigaisha.annotations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkParametrizedTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x800";
        Configuration.browser = "Chrome";
    }

    @BeforeEach
    void openAgentPolis() {
        Selenide.clearBrowserCookies();
        open("https://agent-polis.kz/login");
    }

    @CsvSource(value = {
            "7777768435, 1234567",
            "7023998900, 1234567"
    })

    @ParameterizedTest(name = "Test for users in Agent Polis")
    public void agentPolisTest(String userName, String password) {
        $("#username").setValue(userName);
        $("#pwd").setValue(password);
        $("#btnLogin").click();
        $("#sidebarMenu").$(byText("Все полисы")).pressEnter();
        $(".btn-toolbar").shouldHave(Condition.text("Все полисы"));
    }
}