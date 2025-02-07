package com.dhh.payments.service;

import com.dhh.payments.model.Transaction;
import com.dhh.payments.model.TransactionInputDTO;
import com.dhh.payments.model.TransactionOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    TransactionOutputDTO toTransactionOutputDTO(Transaction transaction);

    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "executionAt", ignore = true)
    Transaction toTransaction(TransactionInputDTO transactionInputDTO);
}