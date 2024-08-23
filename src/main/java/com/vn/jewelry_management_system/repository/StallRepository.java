package com.vn.jewelry_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vn.jewelry_management_system.domain.Stall;
import org.springframework.lang.NonNull;
import java.util.Optional;
import java.util.List;

@Repository
public interface StallRepository extends JpaRepository<Stall, Integer> {
    Optional<Stall> findByStallName(String stallName);

    @SuppressWarnings("null")
    @NonNull
    List<Stall> findAll();

}