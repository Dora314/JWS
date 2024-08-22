package com.vn.jewelry_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.vn.jewelry_management_system.domain.GoldPrice;

@Repository
public interface GoldPriceRepository extends JpaRepository<GoldPrice, Integer> {
    Optional<GoldPrice> findByUpdateDate(Date updateDate);
}