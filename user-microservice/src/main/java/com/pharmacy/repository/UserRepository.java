package com.pharmacy.repository;
import org.springframework.data.repository.CrudRepository;


import com.pharmacy.model.UserDao;
import com.pharmacy.model.UserDto;
public interface UserRepository extends CrudRepository<UserDao, Long> {
    UserDao findByUsername(String username);

	UserDao getById(Long userID);
}