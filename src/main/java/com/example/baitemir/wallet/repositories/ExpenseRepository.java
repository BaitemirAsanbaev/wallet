package com.example.baitemir.wallet.repositories;
import com.example.baitemir.wallet.enteties.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
