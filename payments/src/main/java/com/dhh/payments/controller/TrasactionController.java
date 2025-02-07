package com.dhh.payments.controller;

import com.dhh.payments.model.TransactionInputDTO;
import com.dhh.payments.model.TransactionOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "Transactions", description = "API for managing transactions")
public interface TrasactionController {

    @Operation(summary = "Get all transactions", description = "Retrieve all transactions")
    Flux<TransactionOutputDTO> getAllTransactions();

    @Operation(summary = "Get transaction by ID", description = "Retrieve a transaction by its ID")
    Mono<TransactionOutputDTO> getTransactionById(@PathVariable Long id);

    @Operation(summary = "Get transactions by debtor IBAN", description = "Retrieve transactions by debtor IBAN")
    Flux<TransactionOutputDTO> getTransactionsByDebtorIBAN(@PathVariable String debtorIBAN);

    @Operation(summary = "Get transactions by creditor IBAN", description = "Retrieve transactions by creditor IBAN")
    Flux<TransactionOutputDTO> getTransactionsByCreditorIBAN(@PathVariable String creditorIBAN);

    @Operation(summary = "Create a new transaction", description = "Create a new transaction")
    Mono<Void> createTransaction(@Valid @RequestBody TransactionInputDTO transactionInputDTO);

    @Operation(summary = "Update a transaction", description = "Update an existing transaction by ID")
    public Mono<Void> updateTransaction(@Valid @PathVariable Long id, @RequestBody TransactionInputDTO transactionInputDTO);

    @Operation(summary = "Delete a transaction", description = "Delete a transaction by ID")
    Mono<Void> deleteTransaction(@PathVariable Long id);
}
