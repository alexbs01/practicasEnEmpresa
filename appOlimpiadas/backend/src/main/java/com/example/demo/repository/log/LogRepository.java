package com.example.demo.repository.log;

import com.example.demo.entitites.log.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
