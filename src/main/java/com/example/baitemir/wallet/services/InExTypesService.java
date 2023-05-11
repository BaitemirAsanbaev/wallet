package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.enteties.ExpenseTypes;
import com.example.baitemir.wallet.enteties.IncomeTypes;

import java.util.List;

public interface InExTypesService {
    public List<IncomeTypes> getIncomeTypes();
    public List<ExpenseTypes> getExpenseTypes();
    public void addIncomeTypes(IncomeTypes  incomeTypes);
    public void addExpenseTypes(ExpenseTypes expenseTypes);
}
