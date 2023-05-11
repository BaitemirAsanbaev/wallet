package com.example.baitemir.wallet.repositories;

import com.example.baitemir.wallet.enteties.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
