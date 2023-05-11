package com.example.baitemir.wallet.dto;

public record ExpenseRequest(
        int value,

        String type,
        String description
) {
}
