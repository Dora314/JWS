package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Promotion;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class PromotionTest {

    @Test
    public void testPromotionConstructorAndGettersAndSetters() {
        // Create a Promotion object
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24 * 7)); // End date one week after start date
        Promotion promotion = new Promotion("Summer Sale", "Discount", "Percentage", new BigDecimal("0.20"), startDate, endDate);

        // Assert that the constructor and getters work correctly
        assertEquals("Summer Sale", promotion.getPromotionName());
        assertEquals("Discount", promotion.getPromotionType());
        assertEquals("Percentage", promotion.getCdt());
        assertEquals(new BigDecimal("0.20"), promotion.getValue());
        assertEquals(startDate, promotion.getStartDate());
        assertEquals(endDate, promotion.getEndDate());

        // Update the promotion's information using setters
        Date newStartDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24)); // Start date one day later
        Date newEndDate = new Date(newStartDate.getTime() + (1000 * 60 * 60 * 24 * 14)); // End date two weeks after new start date
        promotion.setPromotionName("Winter Sale");
        promotion.setPromotionType("Gift");
        promotion.setCdt("Fixed Amount");
        promotion.setValue(new BigDecimal("50"));
        promotion.setStartDate(newStartDate);
        promotion.setEndDate(newEndDate);

        // Assert that the setters work correctly
        assertEquals("Winter Sale", promotion.getPromotionName());
        assertEquals("Gift", promotion.getPromotionType());
        assertEquals("Fixed Amount", promotion.getCdt());
        assertEquals(new BigDecimal("50"), promotion.getValue());
        assertEquals(newStartDate, promotion.getStartDate());
        assertEquals(newEndDate, promotion.getEndDate());
    }

    @Test
    public void testPromotionToString() {
        // Create a Promotion object
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24 * 7)); // End date one week after start date
        Promotion promotion = new Promotion("Summer Sale", "Discount", "Percentage", new BigDecimal("0.20"), startDate, endDate);

        // Set the promotion ID (normally done by the database)
        promotion.setPromotionId(1);

        // Assert that the toString method produces the expected output (date format might vary)
        String expectedToString = "Promotion [promotionId=1, promotionName=Summer Sale, promotionType=Discount, cdt=Percentage, value=0.20, startDate=" + startDate.toString() + ", endDate=" + endDate.toString() + "]";
        assertEquals(expectedToString, promotion.toString());
    }
}