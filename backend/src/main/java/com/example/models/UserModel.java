package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserModel {
    @Id
    private String id; // MongoDB document ID
    private String name; // Corresponds to 'name' in Mongoose schema
    private String email; // Corresponds to 'email' in Mongoose schema
    private String password; // Corresponds to 'password' in Mongoose schema
    private String image; // Corresponds to 'image' in Mongoose schema
    private String role; // Corresponds to 'role' in Mongoose schema
    private String provider; // Corresponds to 'provider' in Mongoose schema
    private Date emailVerified; // Corresponds to 'emailVerified' in Mongoose schema
    private boolean isTwoFactorEnabled; // Corresponds to 'isTwoFactorEnabled' in Mongoose schema
    private String emailPendingVerification; // Corresponds to 'emailPendingVerification' in Mongoose schema
    private Date createdAt; // Timestamp for account creation
    private Date lastLoginAt; // Timestamp for last login
    private boolean isActive; // Corresponds to the active status of the user

    // Enums for role and provider (you can create these as Java enums or simply as strings)
    public enum UserRole {
        USER, ADMIN
    }

    public enum UserProvider {
        CREDENTIALS, GOOGLE
    }
}
