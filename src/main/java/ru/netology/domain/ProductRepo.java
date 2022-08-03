package ru.netology.domain;

public class ProductRepo {
    private Product[] products = new Product[0];

    public void save(Product newProduct) {
        int id = newProduct.getId();
        Product check = new Product();
        check = findById(id);
        if (check != null) {
            throw new AlreadyExistsException("Element with id: " + id + " already exists");
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        Product check = new Product();
        check = findById(id);
        if (check == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


}
