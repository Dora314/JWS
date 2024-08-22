package com.vn.jewelry_management_system.service;

import org.springframework.stereotype.Service;

import com.vn.jewelry_management_system.domain.GoldPrice;
import com.vn.jewelry_management_system.domain.Product;
import com.vn.jewelry_management_system.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final GoldPriceService goldPriceService; // Inject GoldPriceService

    public ProductService(ProductRepository productRepository, GoldPriceService goldPriceService) {
        this.productRepository = productRepository;
        this.goldPriceService = goldPriceService;
    }

    public BigDecimal calculateSellingPrice(Product product) {
        // Lấy giá vàng hiện tại
        Optional<GoldPrice> latestGoldPrice = goldPriceService.getLatestGoldPrice();

        // Kiểm tra xem Optional có chứa giá trị hay không
        if (latestGoldPrice.isPresent()) {
            BigDecimal goldPrice = latestGoldPrice.get().getGoldPrice(); // Lấy giá trị từ Optional

            // Tính giá vốn sản phẩm
            BigDecimal costPrice = goldPrice.multiply(product.getWeight())
                    .add(product.getMakingFee())
                    .add(product.getGemstonePrice());

            // Tính giá bán
            BigDecimal sellingPrice = costPrice.multiply(product.getMarkupRatio().add(BigDecimal.ONE));

            return sellingPrice;
        } else {
            // Xử lý trường hợp không tìm thấy giá vàng,
            // ví dụ: throw exception, trả về giá trị mặc định, ...
            throw new RuntimeException("Không tìm thấy giá vàng!");
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }
}