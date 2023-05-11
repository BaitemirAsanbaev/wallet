package com.example.baitemir.wallet.controllers;
import com.example.baitemir.wallet.dto.BalanceRequest;
import com.example.baitemir.wallet.dto.ExpenseRequest;
import com.example.baitemir.wallet.dto.IncomeRequest;
import com.example.baitemir.wallet.dto.TransactionRequest;
import com.example.baitemir.wallet.enteties.*;
import com.example.baitemir.wallet.services.BalanceService;
import com.example.baitemir.wallet.services.InExService;
import com.example.baitemir.wallet.services.InExTypesService;
import com.example.baitemir.wallet.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/balances")
@CrossOrigin
public class BalanceController {
    @Autowired
    private BalanceService balanceService;

    @Autowired
    private InExService inExService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private InExTypesService inExTypesService;

    @GetMapping("")
    public List<Balance> getAllPosts(){
        return balanceService.getAllBalances();
    }
    @GetMapping("{id}")
    public Optional<Balance> getPost(@PathVariable("id") Long id){
        return balanceService.getBalance(id);
    }
    @PostMapping("/create/")
    public String add(@RequestBody BalanceRequest request){
        balanceService.saveBalance(request);
        return "balance created";
    }
    @PostMapping("/update/{id}")
    public void update(@RequestBody BalanceRequest request, @PathVariable("id") Long id){
        balanceService.updateBalance(request, id);
    }
    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable("id") Long id){
        balanceService.deleteBalance(id);
        return "Success";
    }
    @GetMapping("/incomes")
    public List<Income> getIncomes(){
        return inExService.getIncome();
    }
    @GetMapping("/expenses")
    public List<Expense> getExpense(){
        return inExService.getExpense();
    }
    @PostMapping("/income/{id}")
    public String addIncome(@PathVariable Long id, @RequestBody IncomeRequest request){
        inExService.addIncome(id, request);
        return "Success";
    }
    @PostMapping("/expense/{id}")
    public String addExpense(@PathVariable Long id, @RequestBody ExpenseRequest request){
        inExService.addExpense(id, request);
        return "Success";
    }

    @PostMapping("/transaction/{from}/{to}")
    public String transaction(@PathVariable("from") Long from, @PathVariable("to") Long to, @RequestBody TransactionRequest request){
        transactionService.transaction(from, to, request);
        return "Success";
    }
    @GetMapping("/income/types")
    public List<IncomeTypes> getIncomeTypes(){
        return inExTypesService.getIncomeTypes();
    }
    @GetMapping("/expense/types")
    public List<ExpenseTypes> getExpenseTypes(){
        return inExTypesService.getExpenseTypes();
    }
    @PostMapping("/income/types/add")
    public void addIncomeTypes(@RequestBody IncomeTypes incomeTypes){
        inExTypesService.addIncomeTypes(incomeTypes);
    }
    @PostMapping("/expense/types/add")
    public void addExpenseTypes(@RequestBody ExpenseTypes expenseTypes){
        inExTypesService.addExpenseTypes(expenseTypes);
    }
}