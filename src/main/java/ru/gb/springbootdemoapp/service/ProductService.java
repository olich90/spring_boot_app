package ru.gb.springbootdemoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ru.gb.springbootdemoapp.dto.Product;
import ru.gb.springbootdemoapp.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProductByID(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductByID(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCost(Float minCost, Float maxCost) {
        return productRepository.findAllByCostGreaterThanAndCostLessThan(minCost, maxCost);
    }
}
