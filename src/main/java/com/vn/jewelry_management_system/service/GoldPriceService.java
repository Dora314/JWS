package com.vn.jewelry_management_system.service;

import org.springframework.stereotype.Service;
import com.vn.jewelry_management_system.domain.GoldPrice;
import com.vn.jewelry_management_system.repository.GoldPriceRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GoldPriceService {
    private final GoldPriceRepository goldPriceRepository;

    public GoldPriceService(GoldPriceRepository goldPriceRepository) {
        this.goldPriceRepository = goldPriceRepository;
    }

    public List<GoldPrice> getAllGoldPrices() {
        return goldPriceRepository.findAll();
    }

    public Optional<GoldPrice> getGoldPriceById(int id) {
        return goldPriceRepository.findById(id);
    }

    public GoldPrice saveGoldPrice(GoldPrice goldPrice) {
        return goldPriceRepository.save(goldPrice);
    }

    public void deleteGoldPrice(int id) {
        goldPriceRepository.deleteById(id);
    }

    public Optional<GoldPrice> findByUpdateDate(Date updateDate) {
        return goldPriceRepository.findByUpdateDate(updateDate);
    }
}