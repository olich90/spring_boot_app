package ru.gb.springbootdemoapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.springbootdemoapp.dto.Product;
import ru.gb.springbootdemoapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    // MVC
    // http://localhost:8080/app/rest/products GET
    @GetMapping("/products")
    public List<Product> getAllProduct(@RequestParam(defaultValue = "0") Float minCost, @RequestParam(defaultValue = "99999999") Float maxCost) {
        return productService.findAllByCost(minCost, maxCost);
    }

    // http://localhost:8080/app/rest/products/10 GET
    @GetMapping("/products/{id}")
    public Product getProductInfo(@PathVariable Long id, Model model) {
        return productService.getProductByID(id);
    }

    // http://localhost:8080/app/rest/add POST
    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    // http://localhost:8080/app/rest/products/delete/4
    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductByID(id);
        return "redirect:/products";
    }
}
