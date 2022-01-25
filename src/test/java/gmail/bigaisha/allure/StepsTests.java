package gmail.bigaisha.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsTests {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 68;
    @Test
    public void lambdaStepTest() {
      step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
      step("щем репозиторий" + REPOSITORY, () -> {
          $(".header-search-input").click();
          $(".header-search-input").sendKeys(REPOSITORY);
          $(".header-search-input").submit();
      });
      step("Переходим в репозиторий" + REPOSITORY, () -> {
          $(linkText("eroshenkoam/allure-example")).click();
      });
      step("Открываем таб Issues", () -> {
          $(partialLinkText("Issues")).click();
      });
      step("Проверяем наличие Issue с номером" + NUMBER, () -> {
          $(withText("#" + NUMBER)).should(Condition.visible);
      });
    }
    @Test
    public void annotatedStepsTest(){
        WebSteps steps = new WebSteps();
            steps.openMainPage();
            steps.searchForReposirory(REPOSITORY);
            steps.openRepositoryPage(REPOSITORY);
            steps.openIssuesTab();
            steps.shouldSeeIssueWithNumber(NUMBER);
        }
    }
