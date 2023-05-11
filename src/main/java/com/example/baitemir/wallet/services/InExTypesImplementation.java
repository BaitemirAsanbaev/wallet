package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.enteties.ExpenseTypes;
import com.example.baitemir.wallet.enteties.IncomeTypes;
import com.example.baitemir.wallet.repositories.ExpenseRepository;
import com.example.baitemir.wallet.repositories.ExpenseTypesRepository;
import com.example.baitemir.wallet.repositories.IncomeRepository;
import com.example.baitemir.wallet.repositories.IncomeTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InExTypesImplementation implements InExTypesService {
    @Autowired
    IncomeTypesRepository incomeTypesRepo;
    @Autowired
    ExpenseTypesRepository expenseTypesRepo;

    @Override
    public List<IncomeTypes> getIncomeTypes(){
        return incomeTypesRepo.findAll();
    }

    @Override
    public List<ExpenseTypes> getExpenseTypes(){
        return expenseTypesRepo.findAll();
    }

    @Override
    public void addIncomeTypes(IncomeTypes incomeTypes){
        incomeTypesRepo.save(incomeTypes);
    }
    @Override
    public void addExpenseTypes(ExpenseTypes expenseTypes){
        expenseTypesRepo.save(expenseTypes);
    }

}
