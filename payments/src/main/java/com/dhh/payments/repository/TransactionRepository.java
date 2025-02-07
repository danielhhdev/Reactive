package com.dhh.payments.repository;

import com.dhh.payments.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Long> {
    Flux<Transaction> findByDebtorIBAN(String debtorIBAN);

    Flux<Transaction> findByCreditorIBAN(String creditorIBAN);


}