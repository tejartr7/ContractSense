package com.example.models;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "contracts")
public class ContractsModel {
    @Id
    private String id;

    // Required fields
    private String title;

    private String content;

    private Date signedDate;

    // Optional fields
    @Nullable
    private Date endDate;

    private boolean autoRenewal = false;  // default value

    @Nullable
    private Integer renewalNoticePeriod;  // Using Integer instead of int to allow null

    private String status = "DRAFT";  // default value

    @Nullable
    private Map<String, Object> aiAnalysis;

    @Nullable
    private Date lastReviewDate;

    @Nullable
    private String assignedTo;

    private List<String> tags = new ArrayList<>();  // initialize empty list

    // User references
    @DBRef
    private UserModel addedBy;

    private Date addedAt;

    @Nullable
    @DBRef
    private UserModel lastModifiedBy;

    @Nullable
    private Date lastModifiedAt;
}