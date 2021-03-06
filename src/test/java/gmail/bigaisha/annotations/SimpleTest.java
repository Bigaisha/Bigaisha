package gmail.bigaisha.annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Class asserting 3 N 2")
public class SimpleTest {
    @Test
    @DisplayName("Test asserts 3 < 0")
    void test0() {
        Assertions.assertTrue(3 < 0);
    }
    @Test
    @DisplayName("Test asserts 3 > 1")
    void test1() {
        Assertions.assertTrue(3 > 1);
    }
    @Test
    @DisplayName("Test asserts 3 > 2")
    void test2() {
        Assertions.assertTrue(3 > 2);
    }
}
