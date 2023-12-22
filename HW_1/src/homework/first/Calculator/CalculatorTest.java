package homework.first.Calculator;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    public static void main(String[] args) {

        // Домашнаяя работа к семинару 1
        // Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
        // Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
        // Не забудьте написать тесты для проверки этого поведения.

        //Обрабатываем случай без скидки, когда размер скидки равен 0.
            assertThat(Calculator.calculatingDiscount(100.0, 0)).isEqualTo(100.0);
        System.out.println("Проверка без скидки успешна");

        //Обрабатываем случай с учетом скидки для валидных входных данных.
            assertThat(Calculator.calculatingDiscount(100.0,10)).isEqualTo(90.0);
        System.out.println("Проверка валидных входных данных успешна");

        //Обрабатываем случай с учетом скидки с учетом погрешности для валидных входных данных.
            assertThat(Calculator.calculatingDiscount(100.0,10))
                    .isEqualTo(90.0, Assertions.within(0.0001));
        System.out.println("Проверка с учетом погрешности для валидных входных данных успешна");

        //Обрабатываем негативный случай если сумма покупки отрицательна.
            Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(-100.0, 10))
                    .isInstanceOf(ArithmeticException.class).hasMessage("Purchase amount cannot be negative");
            System.out.println("Проверка обработки ошибки с отрицательной суммой покупки успешна");
        //Обрабатываем негативный случай если скидка невалидна.

            Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(100.0, 110))
                    .isInstanceOf(ArithmeticException.class).hasMessage("DiscountAmount must be between 0 and 100");
            Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(100.0, -10))
                    .isInstanceOf(ArithmeticException.class).hasMessage("DiscountAmount must be between 0 and 100");
            System.out.println("Проверка обработки ошибки невалидной скидкой успешна");

//            возможно ненужный тест

        }
    }