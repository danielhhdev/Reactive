package com.dhh.payments.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionOutputDTO {

    private Long id;

    private String debtorIBAN;

    private String creditorIBAN;

    private String amount;

    private String currencyType;

    private String createAt;

    private String executionAt;

}
