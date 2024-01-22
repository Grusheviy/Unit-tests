package example.org;

/**
 * Класс ListCalculator предоставляет метод
 * для вычисления среднего значения массива чисел.
 */
public class ListCalculator {

  /**
   * Вычисляет среднее значение массива чисел.
   *
   * @param arr Массив чисел.
   * @return Среднее значение массива.
   */
  public final double calculateAverage(final double[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    double sum = 0;
    for (double num : arr) {
      sum += num;
    }
    return sum / arr.length;
  }
}
