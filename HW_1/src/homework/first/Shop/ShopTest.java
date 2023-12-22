package homework.first.Shop;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    public static void main(String[] args) {

        //Создаем магазин, добавляем продукты, устанавливаем им цену
        Shop shop = new Shop();
        Product product1 = new Product();
        product1.setCost(30);
        Product product2 = new Product();
        product2.setCost(10);
        Product product3 = new Product();
        product3.setCost(20);

        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        List<Product> products = shop.getProducts();

//  1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
//  (правильное количество продуктов, верное содержимое корзины).
        assertThat(products).hasSize(3).containsExactly(product1, product2, product3);
        System.out.println("Проверка правильного хранения продуктов и их количества успешна");

//  2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        List<Product> sortedProducts = shop.sortProductsByPrice();
        List<Product> expectedSortedProducts = Arrays.asList(product2, product3, product1);
        assertThat(sortedProducts).containsExactlyElementsOf(expectedSortedProducts);
        System.out.println("Проверка корректности работы метода getMostExpensiveProduct успешна");

//  3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(product1);
        System.out.println("Проверка корректности работы метода sortProductsByPrice успешна");

// Дополнительная проверка, что магазин пустой (Для практики)
        shop = new Shop();
        List<Product> emptyProducts = shop.getProducts();
        assertThat(emptyProducts).isEmpty();
        System.out.println("Проверка, что магазин пустой успешна");

// Дополнительная проверка, что getMostExpensiveProduct возвращает null для пустого магазина
        assertThat(shop.getMostExpensiveProduct()).isNull();
        System.out.println("Проверка, что getMostExpensiveProduct возвращает null для пустого магазина успешна");

// Дополнительная проверка, что sortProductsByPrice возвращает пустой список для пустого магазина
        List<Product> emptySortedProducts = shop.sortProductsByPrice();
        assertThat(emptySortedProducts).isEmpty();
        System.out.println("Проверка, что sortProductsByPrice возвращает пустой список для пустого магазина успешна");
    }
}