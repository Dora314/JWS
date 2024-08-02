package com.vn.jewelry_management_system.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vn.jewelry_management_system.domain.User;

//crud: create, read, update, delete
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User anh);
}
