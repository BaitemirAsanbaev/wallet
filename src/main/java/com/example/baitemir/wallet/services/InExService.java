package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.dto.ExpenseRequest;
import com.example.baitemir.wallet.dto.IncomeRequest;
import com.example.baitemir.wallet.enteties.Balance;
import com.example.baitemir.wallet.enteties.Expense;
import com.example.baitemir.wallet.enteties.Income;

import java.util.List;

public interface InExService {
    public List<Income> getIncome();
    public List<Expense> getExpense();
    public String addExpense(Long id, ExpenseRequest request);
    public String addIncome(Long id, IncomeRequest request);
}
