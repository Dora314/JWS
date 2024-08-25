package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.controller.ProductController;
import com.vn.jewelry_management_system.domain.Product;
import com.vn.jewelry_management_system.domain.ProductType;
import com.vn.jewelry_management_system.service.ProductService;
import com.vn.jewelry_management_system.service.ProductTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductTypeService productTypeService;

    @Test
    public void testShowAllProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of(new Product()));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/product/table-product"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products"));
    }

    @Test
    public void testShowCreateForm() throws Exception {
        when(productTypeService.getAllProductTypes()).thenReturn(List.of(new ProductType()));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/products/create"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/product/create"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("product"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("productTypes"));
    }

    @Test
    public void testCreateProduct() throws Exception {
        ProductType productType = new ProductType();
        productType.setProductTypeId(1);
        when(productTypeService.getProductTypeById(anyInt())).thenReturn(Optional.of(productType));
        when(productService.calculateSellingPrice(any(Product.class))).thenReturn(BigDecimal.TEN);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products/create")
                        .param("productName", "Test Product")
                        .param("productType.productTypeId", "1"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/admin/products"));
    }

    @Test
    public void testShowEditForm() throws Exception {
        Product product = new Product();
        when(productService.getProductById(anyInt())).thenReturn(Optional.of(product));
        when(productTypeService.getAllProductTypes()).thenReturn(List.of(new ProductType()));

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/products/edit/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("admin/product/edit"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("product"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("productTypes"));
    }

    @Test
    public void testUpdateProduct() throws Exception {
        ProductType productType = new ProductType();
        productType.setProductTypeId(1);
        when(productTypeService.getProductTypeById(anyInt())).thenReturn(Optional.of(productType));
        when(productService.calculateSellingPrice(any(Product.class))).thenReturn(BigDecimal.TEN);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products/edit/1")
                        .param("productName", "Updated Product")
                        .param("productType.productTypeId", "1"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/admin/products"));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/products/delete/1"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/admin/products"));
    }

    @Test
    public void testGetProductPrice() throws Exception {
        Product product = new Product();
        when(productService.getProductById(anyInt())).thenReturn(Optional.of(product));
        when(productService.calculateSellingPrice(any(Product.class))).thenReturn(BigDecimal.TEN);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/products/price/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("10"));
    }
}