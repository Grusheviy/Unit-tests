package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberInIntervalTest {
    NumberInInterval checker;

    @BeforeEach
    void setUp() {
        checker = new NumberInInterval();
    }

//    (25;100) в интервал не входят
    @ParameterizedTest
    @ValueSource(ints = {26, 99})
    void trueLimitNumberInIntervalTest(int nums) {
        assertTrue(checker.numberInInterval(nums));
    }
    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    void falseLimitNumberInIntervalTest(int nums) {
        assertFalse(checker.numberInInterval(nums));
    }
}