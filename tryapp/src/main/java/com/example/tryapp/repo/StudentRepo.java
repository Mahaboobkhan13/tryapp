package com.example.tryapp.repo;

import com.example.tryapp.model.Students;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepo extends MongoRepository<Students,String> {




}
