package ru.netology.domain;

public class ProductManager {
    private ProductRepo repo;

    public ProductManager(ProductRepo repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int index = 0;
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[]  tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
                result[index] = product;
                index++;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
