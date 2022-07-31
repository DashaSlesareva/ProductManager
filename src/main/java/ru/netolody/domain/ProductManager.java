package ru.netolody.domain;

public class ProductManager {
//    ProductManager manager = new ProductManager();
  private Product [] products = new Product[0];
  public void add (Product newProduct) {
    Product [] tmp = new Product[products.length +1];
    for (int i = 0; i < products.length; i++) {
      tmp[i] = products[i];
          }
    tmp[tmp.length - 1] = newProduct;
    products = tmp;
  }


}
