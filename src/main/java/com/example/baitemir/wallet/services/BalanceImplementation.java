package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.dto.BalanceRequest;
import com.example.baitemir.wallet.enteties.Balance;
import com.example.baitemir.wallet.repositories.BalanceRepository;
import com.example.baitemir.wallet.repositories.ExpenseRepository;
import com.example.baitemir.wallet.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceImplementation implements BalanceService {
    @Autowired
    private BalanceRepository balanceRepo;
    @Autowired
    private IncomeRepository incomeRepo;
    @Autowired
    private ExpenseRepository expenseRepo;
    @Override
    public Balance saveBalance (BalanceRequest request){
        Balance balance = new Balance();
        balance.setBalance(request.balance());
        balance.setTitle(request.title());
        return balanceRepo.saveAndFlush(balance);
    }
    @Override
    public void updateBalance(BalanceRequest request, Long id){
        Optional<Balance> balance = balanceRepo.findById(id);
        balance.get().setTitle(request.title());
        balanceRepo.save(balance.get());
    }
    @Override
    public String deleteBalance (Long id){
        balanceRepo.deleteById(id);
        return "Deleted";
    }
    @Override   
    public Optional<Balance> getBalance(Long id){
        return balanceRepo.findById(id);
    }
    @Override
    public List<Balance> getAllBalances(){
        return balanceRepo.findAll();
    }

}
