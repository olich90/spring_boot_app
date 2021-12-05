package ru.gb.springbootdemoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ru.gb.springbootdemoapp.dto.Product;
import ru.gb.springbootdemoapp.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public Product getProductByID(int id) {
        return productRepository.getProductByID(id);
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public void deleteProductByID(int id) {
        productRepository.deleteProductByID(id);
    }
}
