package example.org;

public class ListCalculator {
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
