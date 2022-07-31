package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netolody.domain.Book;
import ru.netolody.domain.Product;
import ru.netolody.domain.ProductManager;
import ru.netolody.domain.Smartpone;

public class ProductManagerTest {
    Product book1 = new Book(101, "Idiot", 500, "Dostoevskiy");
    Product book2 = new Book(102, "TikhiyDon", 700, "Sholokhov");
    Product smartphone1 = new Smartpone(103, "Iphone13", 80000, "Apple");
    Product smartphone2 = new Smartpone(104, "GalaxyS20", 50000, "Samsung");

    @Test
    public void test() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);

    }
}
