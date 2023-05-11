package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.dto.BalanceRequest;
import com.example.baitemir.wallet.enteties.Balance;
import com.example.baitemir.wallet.enteties.Expense;
import com.example.baitemir.wallet.enteties.Income;

import java.util.List;
import java.util.Optional;


public interface BalanceService {
    public Optional<Balance> getBalance(Long id);
    public Balance saveBalance(BalanceRequest request);
    public void updateBalance(BalanceRequest request, Long id);
    public String deleteBalance(Long id);
    public List<Balance> getAllBalances();
}
