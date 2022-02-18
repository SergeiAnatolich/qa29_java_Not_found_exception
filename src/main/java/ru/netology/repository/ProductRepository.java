package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product[] findById(int id) {
        Product[] findProduct = new Product[1];
        for (Product product : products) {
            if (id == product.getId()) {
                findProduct[0] = product;
                return findProduct;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            Product[] tmp = new Product[products.length - 1];
            int index = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[index] = product;
                    index++;
                }
            }
            products = tmp;
        } else {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
    }
}