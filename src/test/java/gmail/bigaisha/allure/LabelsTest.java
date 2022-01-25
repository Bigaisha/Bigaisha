package gmail.bigaisha.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    public void lambdaLabelTest() {
        Allure.label("owner", "eroshenkoam");
        Allure.feature("Issues");
        Allure.story("Создание Issue для авторизованного пользователя");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("Github", "https://github.com/");
    }
    @Test
    @Owner("eroshenkoam")
    @Feature("Issues")
    @Stories({
            @Story("Создание Issue для авторизованного пользователя"),
            @Story("Создание Issue со страницы репозитория")
    })
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com/")
    public void annotatedLabelTest() {

    }
}
