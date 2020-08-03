package com.harold.app.test.dataBaseTest.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.harold.app.test.dataBaseTest.domain.UserEntity;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Component
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}

