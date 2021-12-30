package ru.gb.springbootdemoapp;

import org.springframework.stereotype.Component;
import ru.gb.springbootdemoapp.dto.Product;
import ru.gb.springbootdemoapp.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final ProductRepository productRepository;
    private final List<Product> products;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        products = new ArrayList<>();
    }

    public void addProductById(Long id) {
        products.add(productRepository.getById(id));
    }

    public void deleteProductById(Long id) {
        products.remove(productRepository.getById(id));
    }

    @Override
    public String toString() {
        return "Cart {products=" +
                products +
                '}';
    }
}
