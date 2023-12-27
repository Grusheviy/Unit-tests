package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenOddNumberTest {
    EvenOddNumber checker;

    @BeforeEach
    void setUp() {
        checker = new EvenOddNumber();
    }

    @Test
    void evenNumberTest() {
        assertTrue(checker.evenOddNumber(4));
    }
    @Test
    void oddNumberTest(){
        assertFalse(checker.evenOddNumber(3));
    }
    @Test
    void zeroNumberTest(){
        assertTrue(checker.evenOddNumber(0));
    }
    @Test
    void negativeOddNumberTest(){
        assertTrue(checker.evenOddNumber(-10));
    }
    @Test
    void negativerEvenNumberTest(){
        assertFalse(checker.evenOddNumber(-11));
    }
}