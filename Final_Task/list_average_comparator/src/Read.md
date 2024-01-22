# Отчет о выполнении задания

## 1. Отчет Checkstyle

### Скриншот Checkstyle
!{https://github.com/Grusheviy/Unit-tests/blob/3e61d3e0e39017142c9c2c45cefbf4dc89834350/Final_Task/list_average_comparator/images/CheckStyle.jpg}

### Объяснение
   1. **Скрытые поля**: Поля 'list1' и 'list2' в классе ListComparator
больше не скрываются в методах.
   2. **Пропущены Javadoc комментарии**: Добавлены Javadoc комментарии
для переменных, констант, классов и пакета в целом.
   3. **Неправильные уровени отступа**:
Исправлены отступы для соответствия стандарту.

## 2. Отчет о покрытии тестами

### Скриншоты run with coverage
![](https://github.com/Grusheviy/Unit-tests/blob/dc2c78d4a651da0df1039204236d0985b6c12e18/Final_Task/list_average_comparator/images/Test_coverage.jpg)

### Объяснение
1. Тестирование **calculateAverage** в **ListCalculator**: 
Включает сценарии с пустым массивом и массивом {1, 2, 3, 4, 5}.
2. Тестирование **compareLists** в **ListComparator**:
Включает сценарии сравнения списков с различными средними значениями.

Выбор сценариев основан на полном покрытии функциональности обоих классов.
Покрытие тестами включает проверку корректного вычисления среднего
значения массива в **ListCalculator** и правильного сравнения списков
по их средним значениям в **ListComparator**.
