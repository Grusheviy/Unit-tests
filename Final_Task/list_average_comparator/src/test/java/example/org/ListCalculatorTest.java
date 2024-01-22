package example.org;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функциональности {@link ListCalculator}.
 */
class ListCalculatorTest {
  /**
   * Тест для метода calculateAverage, когда входной массив пустой.
   */
  @Test
  void testCalculateAverageEmptyArray() {
    ListCalculator calculator = new ListCalculator();
    double[] arr = {};
    assertEquals(0, calculator.calculateAverage(arr));
  }

  /**
   * Тест для метода calculateAverage, когда входной массив не пустой.
   */
  @Test
  public void testCalculateAverage() {
    ListCalculator calculator = new ListCalculator();
    double[] arr = new double[]{1, 2, 3, 4, 5};
    assertEquals(3, calculator.calculateAverage(arr));
  }
}
