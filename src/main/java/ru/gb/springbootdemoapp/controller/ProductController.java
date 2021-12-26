package ru.gb.springbootdemoapp.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.springbootdemoapp.dto.Product;
import ru.gb.springbootdemoapp.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/app/products GET
    @GetMapping("/products")
    public String getAllProducts(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("products", productService.findAll(pageable));
        List<Integer> pageNumbers  = IntStream.rangeClosed(1, productService.getProductList().size() / 10)
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("list",  pageNumbers);
        return "product_list";
    }

    // http://localhost:8080/app/products/3 GET
    @GetMapping("/products/{id}")
    public String getProductInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductByID(id));
        return "product_info";
    }

    // http://localhost:8080/app/add GET
    @GetMapping("/add")
    public String getProductAddFrom() {
        return "product_form";
    }

    // http://localhost:8080/app/products POST
    @PostMapping("/add")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // http://localhost:8080/app/products/delete/4
    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductByID(id);
        return "redirect:/products";
    }
}
