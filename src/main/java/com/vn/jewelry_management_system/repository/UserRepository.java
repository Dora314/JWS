package com.vn.jewelry_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.jewelry_management_system.domain.User;

//crud: create, read, update, delete
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User anh);

    List<User> findAll();

    User findById(long id); // null

    void deleteById(long id);
}
