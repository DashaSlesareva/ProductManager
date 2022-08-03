package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductManagerTest {
    Product book1 = new Book(101, "Idiot", 500, "Dostoevskiy");
    Product book2 = new Book(102, "TikhiyDot", 700, "Sholokhov");
    Product smartphone1 = new Smartpone(103, "iphone13", 80000, "Apple");
    Product smartphone2 = new Smartpone(104, "GalaxiS20", 50000, "Samsung");
    Product book3 = new Book(101, "Pachinko", 450, "LeeMinJin");

    //тестирую репозиторий

    // Тесты, которые проверяют успешность добавления нового элемента в репозиторий
    @Test
    public void repoSavingSeveralItemsTest() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void repoSavingZeroItemsTest() {
        ProductRepo repo = new ProductRepo();
        Product[] actual = repo.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    // Тест, который проверяет генерацию AlreadyExistsException при попытке добавления элемента
    // с id, который уже есть в репрзитории
    @Test
    public void repoAlreadyExistsExceptionTest() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(book3);
        });
    }

    // Тесты, которые проверяют успешность удаления существующего элемента из репозитория
    @Test
    public void repoDeleteOneItemTest() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        repo.removeById(101);
        Product[] actual = repo.findAll();
        Product[] expected = {book2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void repoDeleteAllItemTest() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        repo.removeById(101);
        repo.removeById(102);
        Product[] actual = repo.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    // Тест, который проверяет генерацию NotFoundException при попытке удаления несуществующего элемента
    @Test
    public void repoNotFoundIDTest() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(105);
        });
    }


    //тестирую менеждер

    @Test
    public void managerAddingTest() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void managerSearhByTest() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("ot");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void managerSearhByDidntFindTest() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("this");
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void managerSearhByFoundAllTest() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("i");
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void managerSearhByBookTest() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("ev");
        Product[] expected = {book1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void managerSearhBySmartphoneTest() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("pp");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(actual, expected);
    }


}
