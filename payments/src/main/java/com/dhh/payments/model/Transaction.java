package com.dhh.payments.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("transactions")
@Builder
@Data
public class Transaction {

    @Id
    private Long id;

    private String debtorIBAN;

    private String creditorIBAN;

    private String amount;

    private String currencyType;

    private String createAt;

    private String executionAt;

}
