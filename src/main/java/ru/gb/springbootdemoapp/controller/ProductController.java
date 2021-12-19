package ru.gb.springbootdemoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootdemoapp.dto.Product;
import ru.gb.springbootdemoapp.service.ProductService;

import java.util.List;

@Controller
//@RequestMapping("product") // префикс для всех методов нашего класса во избежание колизий URL-ов разных контроллеров
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // MVC
    // http://localhost:8080/app/all GET
    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getProductList());
        return "product_list";
    }

    // http://localhost:8080/app/info/3 GET
    @GetMapping("/info/{id}")
    public String getProductInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductByID(id));
        return "product_info";
    }

    // http://localhost:8080/app/add GET
    @GetMapping("/add")
    public String getProductAddFrom() {
        return "product_form";
    }

    // http://localhost:8080/app/add POST
    @PostMapping("/add")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/all";
    }

    @PostMapping("/delete/{id}")
    public String saveProduct(@PathVariable Integer id) {
        productService.deleteProductByID(id);
        return "redirect:/all";
    }


// хотим отдать голые данные в формате JSON, когда пишем API
//    @GetMapping("/all/rest")
//    @ResponseBody // хотим вернуть данные в формате JSON, а не ссылки на template
//    public List<Product> getAllRest() {
//        return productService.getProductList();
//    }
//
//    // сохранение продукта
//    @PostMapping("add/rest")
//    @ResponseBody
//    public List<Product> saveProductRest(@RequestBody /* считать продукт из тела запроса */ Product product) {
//        productService.saveProduct(product);
//        return productService.getProductList();
//    }
}
