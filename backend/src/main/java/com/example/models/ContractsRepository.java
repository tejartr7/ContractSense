package com.example.models;

import com.example.models.ContractsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractsRepository extends MongoRepository<ContractsModel, String> {

    // Custom query to find contracts by status
    List<ContractsModel> findByStatus(String status);

    // Custom query to find contracts assigned to a specific person
    List<ContractsModel> findByAssignedTo(String assignedTo);
}
