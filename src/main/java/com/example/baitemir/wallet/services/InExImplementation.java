package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.dto.ExpenseRequest;
import com.example.baitemir.wallet.dto.IncomeRequest;
import com.example.baitemir.wallet.enteties.Balance;
import com.example.baitemir.wallet.enteties.Expense;
import com.example.baitemir.wallet.enteties.Income;
import com.example.baitemir.wallet.repositories.BalanceRepository;
import com.example.baitemir.wallet.repositories.ExpenseRepository;
import com.example.baitemir.wallet.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InExImplementation implements InExService {
    @Autowired
    private IncomeRepository incomeRepo;

    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private BalanceRepository balanceRepo;
    @Override
    public List<Income> getIncome() {
        return incomeRepo.findAll();
    }
    @Override
    public List<Expense> getExpense() {
        return expenseRepo.findAll();
    }
    @Override
    public String addIncome(Long id, IncomeRequest request){
        Balance balance= balanceRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Balance not found!"));
        Income income = new Income();
        income.setValue(request.value());
        income.setType(request.type());
        income.setDescription(request.description());
        income.setBalance(balance);
        balance.setBalance(balance.getBalance() + request.value());
        balanceRepo.save(balance);
        incomeRepo.save(income);
        return "Success";

    }

    @Override
    public String addExpense(Long id, ExpenseRequest request){
        Balance balance= balanceRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Balance not found!"));
        Expense expense = new Expense();
        expense.setValue(request.value());
        expense.setType(request.type());
        expense.setDescription(request.description());
        expense.setBalance(balance);
        balance.setBalance(balance.getBalance() - request.value());
        balanceRepo.save(balance);
        expenseRepo.save(expense);
        return "Success";
    }
}
