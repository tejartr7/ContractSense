package com.example.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.UserRepo; // Assuming you have a MongoDB repository for users
import com.example.models.UserModel; // Assuming your User model exists in the backend

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository; // Injecting user repository to query MongoDB collection

    /**
     * Checks if the user exists by their ID in the 'users' collection.
     * @param userId The ID of the user to check.
     * @return true if the user exists, otherwise false.
     */
    public boolean existsById(String userId) {
        // Query the users collection using the userId
        return userRepository.existsById(userId); // Check if the user exists by their ID
    }
}
