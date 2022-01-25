package gmail.bigaisha.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class ParametersTest {
    @Test
    public void lambdaLabelTest() {
        Allure.parameter("Регион", "Алматы");
        Allure.parameter("Область", "Алматинская");

    }
}
