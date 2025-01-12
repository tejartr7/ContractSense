package com.example.routes;

import com.example.models.ContractsModel;
import com.example.models.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractsController {

    @Autowired
    private ContractService service;

    // Add a new contract
    @PostMapping
    public ContractsModel addContract(@RequestBody ContractsModel contract) {
        return service.addContract(contract);
    }

    // Get all contracts
    @GetMapping
    public List<ContractsModel> getAllContracts() {
        return service.getAllContracts();
    }

    // Get a contract by ID
    @GetMapping("/{id}")
    public ContractsModel getContractById(@PathVariable String id) {
        return service.getContractById(id);
    }

    // Delete a contract by ID
    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable String id) {
        service.deleteContract(id);
    }

    // Update an existing contract
    @PutMapping("/{id}")
    public ContractsModel updateContract(@PathVariable String id, @RequestBody ContractsModel updatedContract) {
        return service.updateContract(id, updatedContract);
    }

    // Get contracts by status
    @GetMapping("/status/{status}")
    public List<ContractsModel> getContractsByStatus(@PathVariable String status) {
        return service.getContractsByStatus(status);
    }

    // Get contracts assigned to a specific person
    @GetMapping("/assigned/{assignedTo}")
    public List<ContractsModel> getContractsAssignedTo(@PathVariable String assignedTo) {
        return service.getContractsAssignedTo(assignedTo);
    }
}
