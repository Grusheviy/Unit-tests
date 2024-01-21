package example.org;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функциональности {@link ListCalculator}.
 */
class ListCalculatorTest {
  /**
   * Погрешность, используемая для сравнения чисел с плавающей запятой.
   */
  private static final double DELTA = 0.001;

  /**
   * Тест для метода calculateAverage, когда входной массив пустой.
   */
  @Test
  void testCalculateAverageEmptyArray() {
    ListCalculator calculator = new ListCalculator();
    double[] arr = {};
    assertEquals(0, calculator.calculateAverage(arr), DELTA);
  }

  @Test
  public void testCalculateAverage() {
    ListCalculator calculator = new ListCalculator();
    double[] arr = {1, 2, 3, 4, 5};
    assertEquals(3, calculator.calculateAverage(arr), DELTA);
  }
}
