package ru.gb.springbootdemoapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootdemoapp.dto.Product;
import ru.gb.springbootdemoapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductRestController {

  private ProductService productService;

  public ProductRestController(ProductService productService) {
    this.productService = productService;
  }

  // MVC
  // http://localhost:8080/app/rest/all GET
  @GetMapping("/all")
  public List<Product> getAllProduct(Model model) {
    return productService.getProductList();
  }

  // http://localhost:8080/app/rest/info/3 GET
  @GetMapping("/info/{id}")
  public Product getProductInfo(@PathVariable Integer id, Model model) {
    return productService.getProductByID(id);
  }

  // http://localhost:8080/app/rest/add POST
  @PostMapping("/add")
  public Product saveProduct(@RequestBody Product product) {
    productService.saveProduct(product);
    return product;
  }
}
