package example.org;

/**
 * Класс ListComparator сравнивает два списка чисел по их средним значениям.
 */
public class ListComparator {

  /**
     * Первый список чисел.
     */
  private final double[] list1;

  /**
     * Второй список чисел.
     */
  private final double[] list2;

  /**
   * Калькулятор для выполнения математических операций.
   */
  private final ListCalculator calculator;

  /**
   * Конструктор класса ListComparator.
   *
   * @param list1 Первый список чисел.
   * @param list2 Второй список чисел.
   */
  public ListComparator(final double[] list1, final double[] list2) {
    this.list1 = list1;
    this.list2 = list2;
    this.calculator = new ListCalculator();
  }

  /**
   * Сравнивает средние значения двух списков.
   *
   * @return Сообщение о сравнении списков.
   */
  public String compareLists() {
    double averageList1 = calculator.calculateAverage(this.list1);
    double averageList2 = calculator.calculateAverage(this.list2);

    if (averageList1 > averageList2) {
      return "Первый список имеет большее среднее значение";
    } else if (averageList2 > averageList1) {
      return "Второй список имеет большее среднее значение";
    } else {
      return "Средние значения равны";
    }
  }
}
