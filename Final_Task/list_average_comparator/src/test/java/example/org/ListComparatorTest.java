package example.org;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функциональности {@link ListComparator}.
 */
public class ListComparatorTest {
  /**
   * Тест для сравнения списков, когда второй список
   * имеет большее среднее значение.
   */
  @Test
  public void testCompareListsWithGreaterAverage() {
    double[] list1 = {1, 2, 3, 4, 5};
    double[] list2 = {6, 7, 8, 9, 10};

    ListComparator comparator = new ListComparator(list1, list2);
    assertEquals("Второй список имеет большее среднее значение",
            comparator.compareLists());
  }

  /**
   * Тест для сравнения списков, когда оба списка
   * имеют одинаковое среднее значение.
   */
  @Test
  public void testCompareListsWithEqualAverage() {
    double[] list1 = {1, 2, 3};
    double[] list2 = {1, 2, 3};

    ListComparator comparator = new ListComparator(list1, list2);
    assertEquals("Средние значения равны", comparator.compareLists());
  }

  /**
   * Тест для сравнения списков, когда первый список
   * имеет большее среднее значение.
   */
  @Test
  public void testCompareListsWithLowerAverage() {
    double[] list1 = {5, 6, 7, 8};
    double[] list2 = {1, 2, 3, 4};

    ListComparator comparator = new ListComparator(list1, list2);
    assertEquals("Первый список имеет большее среднее значение",
            comparator.compareLists());
  }
}
