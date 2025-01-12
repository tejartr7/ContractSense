package com.example.models;

import com.example.models.ContractsModel;
import com.example.models.ContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractsRepository repository;

    // Add a contract
    public ContractsModel addContract(ContractsModel contract) {
        return repository.save(contract);
    }

    // Get all contracts
    public List<ContractsModel> getAllContracts() {
        return repository.findAll();
    }

    // Find a contract by ID
    public ContractsModel getContractById(String id) {
        return repository.findById(id).orElse(null);
    }

    // Delete a contract by ID
    public void deleteContract(String id) {
        repository.deleteById(id);
    }

    // Update an existing contract
    public ContractsModel updateContract(String id, ContractsModel updatedContract) {
        Optional<ContractsModel> existingContract = repository.findById(id);
        if (existingContract.isPresent()) {
            ContractsModel contract = existingContract.get();
            contract.setTitle(updatedContract.getTitle());
            contract.setContent(updatedContract.getContent());
            contract.setSignedDate(updatedContract.getSignedDate());
            contract.setEndDate(updatedContract.getEndDate());
            contract.setAutoRenewal(updatedContract.isAutoRenewal());
            contract.setRenewalNoticePeriod(updatedContract.getRenewalNoticePeriod());
            contract.setStatus(updatedContract.getStatus());
            contract.setAiAnalysis(updatedContract.getAiAnalysis());
            contract.setLastReviewDate(updatedContract.getLastReviewDate());
            contract.setAssignedTo(updatedContract.getAssignedTo());
            contract.setTags(updatedContract.getTags());

            return repository.save(contract);
        }
        return null; // Return null if the contract doesn't exist
    }

    // Get contracts by status
    public List<ContractsModel> getContractsByStatus(String status) {
        return repository.findByStatus(status);
    }

    // Get contracts assigned to a specific person
    public List<ContractsModel> getContractsAssignedTo(String assignedTo) {
        return repository.findByAssignedTo(assignedTo);
    }
}
