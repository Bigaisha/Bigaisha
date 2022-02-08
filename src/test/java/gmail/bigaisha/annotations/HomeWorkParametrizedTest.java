package gmail.bigaisha.annotations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
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
        open("https://agent-polis.kz/login");
    }

    @CsvSource(value = {
            "7777768435, 1234567",
            "7023998900, 1234567"
    })

    @Owner("Bigaisha Shalabayeva")
    @Feature("Role Test")
    @Stories({
            @Story("Тест для определения роли юзера на сайте agent-polis"),
            @Story("Авторизоваться на сайте Agent-Polis"),
            @Story("Проверить роль юзера в зависимости от функционала")
    })
    @ParameterizedTest(name = "Test for users in Agent Polis")
    public void agentPolisTest(String userName, String password) {
        $("#username").setValue(userName);
        $("#pwd").setValue(password);
        $("#btnLogin").click();
        $("#sidebarMenu").$(byText("Все полисы")).pressEnter();
        $(".btn-toolbar").shouldHave(Condition.text("Все полисы"));
        System.out.println(userName + " is Admin");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
}