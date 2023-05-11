package com.example.baitemir.wallet.dto;

public record IncomeRequest(
        int value,
        String type,
        String description
) {
}
