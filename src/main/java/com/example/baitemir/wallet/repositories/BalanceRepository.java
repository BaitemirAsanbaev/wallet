package com.example.baitemir.wallet.repositories;

import com.example.baitemir.wallet.enteties.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
