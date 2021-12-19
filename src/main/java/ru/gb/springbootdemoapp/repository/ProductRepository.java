package ru.gb.springbootdemoapp.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import ru.gb.springbootdemoapp.dto.Product;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Notebook Lenovo", 1000));
        productList.add(new Product(2, "Notebook Dell", 900));
        productList.add(new Product(3, "Notebook Acer", 1100));
        productList.add(new Product(4, "Notebook HP", 800));
        productList.add(new Product(5, "Notebook Asus", 600));
    }

    public List<Product> getProductList() {
        return List.copyOf(productList);
    }

    public Product getProductByID(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public void saveProduct(Product product) {
        productList.add(product);
    }


    public void deleteProductByID(int id) {
        productList.stream().filter(product -> product.getId() == id).findFirst().ifPresent(productList::remove);
    }
}
