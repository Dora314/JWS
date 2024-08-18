package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.ProductType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTypeTest {

    @Test
    public void testProductTypeConstructorAndGettersAndSetters() {
        // Create a ProductType object
        ProductType productType = new ProductType("Necklace");

        // Assert that the constructor and getter work correctly
        assertEquals("Necklace", productType.getProductTypeName());

        // Update the product type's name using the setter
        productType.setProductTypeName("Ring");

        // Assert that the setter works correctly
        assertEquals("Ring", productType.getProductTypeName());
    }

    @Test
    public void testProductTypeToString() {
        // Create a ProductType object
        ProductType productType = new ProductType("Necklace");

        // Set the product type ID (normally done by the database)
        productType.setProductTypeId(1);

        // Assert that the toString method produces the expected output
        String expectedToString = "ProductType [productTypeId=1, productTypeName=Necklace]";
        assertEquals(expectedToString, productType.toString());
    }
}