package com.dhh.payments.service;

import com.dhh.payments.model.Transaction;
import com.dhh.payments.model.TransactionInputDTO;
import com.dhh.payments.model.TransactionOutputDTO;
import com.dhh.payments.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;

    private final TransactionMapper mapper = TransactionMapper.INSTANCE;

    public Flux<TransactionOutputDTO> getAllTransactions() {
        return repository.findAll().map(mapper::toTransactionOutputDTO);
    }

    public Mono<TransactionOutputDTO> getTransactionById(Long id) {
        return repository.findById(id).map(mapper::toTransactionOutputDTO);
    }

    public Flux<TransactionOutputDTO> getTransactionsByDebtorIBAN(String debtorIBAN) {
        return repository.findByDebtorIBAN(debtorIBAN).map(mapper::toTransactionOutputDTO);
    }

    public Flux<TransactionOutputDTO> getTransactionsByCreditorIBAN(String creditorIBAN) {
        return repository.findByCreditorIBAN(creditorIBAN).map(mapper::toTransactionOutputDTO);
    }

    public Mono<Void> saveTransaction(TransactionInputDTO transactionInputDTO) {
        Transaction transaction = mapper.toTransaction(transactionInputDTO);
        return repository.save(transaction).then();
    }

    public Mono<Void> deleteTransaction(Long id) {
        return repository.deleteById(id);
    }
}