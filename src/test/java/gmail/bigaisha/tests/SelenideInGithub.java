package gmail.bigaisha.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class SelenideInGithub {
    @Test

    void selenideInGit(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(Condition.text("Soft assertions"));
        $("#wiki-content").$(byText("Soft assertions")).click();
        $("#wiki-content").shouldHave(Condition.text("JUnit5"));
    }

}
