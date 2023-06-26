package com.example.tryapp.repo;

import com.example.tryapp.model.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface StudentRepo extends MongoRepository<Students,String> {


    String findByName(String name);

    Optional<Students> findOneByNameAndPassword(String name, String password);
}
