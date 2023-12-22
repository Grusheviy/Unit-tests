package homework.first.Shop;

import java.util.*;

public class Shop {
    private List<Product> products;

    //Создаем конструктор для создания магазина с пустым списком продуктов
    public Shop() {
        this.products = new ArrayList<>();
    }

    //Создаем метод для добавления продукта в магазин
    public void addProduct(Product product) {
        products.add(product);
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        Collections.sort(products, Comparator.comparing(Product::getCost));
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (products == null || products.isEmpty()){
            return null; // Возвращаем null, если список продуктов пуст
        }
        return Collections.max(products, Comparator.comparing(Product::getCost));
    }



}