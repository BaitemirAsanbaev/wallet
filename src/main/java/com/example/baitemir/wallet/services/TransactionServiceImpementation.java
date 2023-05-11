package com.example.baitemir.wallet.services;

import com.example.baitemir.wallet.dto.TransactionRequest;
import com.example.baitemir.wallet.enteties.Balance;
import com.example.baitemir.wallet.enteties.Transaction;
import com.example.baitemir.wallet.repositories.BalanceRepository;
import com.example.baitemir.wallet.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpementation implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private BalanceRepository balanceRepo;


    @Override
    public String transaction(Long from, Long to, TransactionRequest request){
        Balance fromBalance= balanceRepo.findById(from)
                .orElseThrow(()->new RuntimeException("Balance not found!"));
        Balance toBalance= balanceRepo.findById(to)
                .orElseThrow(()->new RuntimeException("Balance not found!"));
        fromBalance.setBalance(fromBalance.getBalance() - request.value());
        toBalance.setBalance(toBalance.getBalance() + request.value());
        Transaction transaction= new Transaction();
        transaction.setValue(request.value());
        transaction.setFromBalance(fromBalance);
        transaction.setToBalance(toBalance);
        balanceRepo.save(fromBalance);
        balanceRepo.save(toBalance);
        transactionRepo.save(transaction);
        return "Success";
    }
}
