package gmail.bigaisha.annotations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


public class ParameterizedWebTest {
    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
    }
//    @ValueSource(strings = {"Selenide", "Junit"})
    static Stream<Arguments> commonSearchTestValueSource() {
        return Stream.of(
                Arguments.of("Selenide"),
                Arguments.of("Junit")
        );
    }
//    @CsvSource(value = {
//            "Selenide, Вышла Selenide",
//            "Junit, Unit 5 is the next generation of JUnit. The goal is to creat"
//    })
    static Stream<Arguments> commonSearchTestCsvSource() {
        return Stream.of(
                Arguments.of("Selenide", "Вышла Selenide"),
                Arguments.of("Junit", "Unit 5 is the next generation of JUnit. The goal is to creat")
        );
    }
    static Stream<Arguments> commonSearchTestDataProvider() {
        return Stream.of(
                Arguments.of("Selenide", false, List.of("1", "2")),
                Arguments.of("Junit", true, List.of("3", "4"))
        );
    }
    @MethodSource("commonSearchTestDataProvider")
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData, boolean flag,  List<String> list) {
        System.out.println("Flag: " + flag);
        System.out.println("List: " + list.toString());
        Selenide.open("https://yandex.kz/");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(testData));
    }
}
