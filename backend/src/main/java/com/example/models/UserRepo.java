package com.example.models;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.models.UserModel; // Assuming you have a User model for MongoDB documents

public interface UserRepo extends MongoRepository<UserModel, String> {

    // Check if the user exists by their ID in the 'users' collection
    boolean existsById(String id); // Method to check existence of the user
}
