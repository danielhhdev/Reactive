package com.dhh.payments.controller;

import com.dhh.payments.model.TransactionInputDTO;
import com.dhh.payments.model.TransactionOutputDTO;
import com.dhh.payments.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transactions")
public class TransactionControllerImpl implements TrasactionController{

    @Autowired
    private TransactionService service;

    @GetMapping
    public Flux<TransactionOutputDTO> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Mono<TransactionOutputDTO> getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    @GetMapping("/debtor/{debtorIBAN}")
    public Flux<TransactionOutputDTO> getTransactionsByDebtorIBAN(@PathVariable String debtorIBAN) {
        return service.getTransactionsByDebtorIBAN(debtorIBAN);
    }

    @GetMapping("/creditor/{creditorIBAN}")
    public Flux<TransactionOutputDTO> getTransactionsByCreditorIBAN(@PathVariable String creditorIBAN) {
        return service.getTransactionsByCreditorIBAN(creditorIBAN);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> createTransaction(@RequestBody TransactionInputDTO transactionInputDTO) {
        return service.saveTransaction(transactionInputDTO);
    }

    @PutMapping("/{id}")
    public Mono<Void> updateTransaction(@PathVariable Long id, @RequestBody TransactionInputDTO transactionInputDTO) {
        transactionInputDTO.setId(id);
        return service.saveTransaction(transactionInputDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTransaction(@PathVariable Long id) {
        return service.deleteTransaction(id);
    }
}
