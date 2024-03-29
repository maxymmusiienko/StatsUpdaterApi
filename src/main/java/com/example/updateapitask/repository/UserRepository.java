package com.example.updateapitask.repository;

import com.example.updateapitask.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findUserByEmail(String email);
}
