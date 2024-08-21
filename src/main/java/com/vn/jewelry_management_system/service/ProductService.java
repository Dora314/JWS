package com.vn.jewelry_management_system.service;
import com.vn.jewelry_management_system.entity.Product;
import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}