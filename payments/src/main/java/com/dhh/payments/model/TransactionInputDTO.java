package com.dhh.payments.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionInputDTO {

    private Long id;

    @NotBlank
    @Size(min = 15, max = 34, message = "IBAN should be between 15 and 34 characters")
    @Pattern(regexp = "^[A-Z]{2}[0-9A-Z]{13,32}$", message = "Invalid IBAN format")
    private String debtorIBAN;

    @NotBlank
    @Size(min = 15, max = 34, message = "IBAN should be between 15 and 34 characters")
    @Pattern(regexp = "^[A-Z]{2}[0-9A-Z]{13,32}$", message = "Invalid IBAN format")
    private String creditorIBAN;

    @NotBlank
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$", message = "Invalid currency type")
    private String currencyType;
}
