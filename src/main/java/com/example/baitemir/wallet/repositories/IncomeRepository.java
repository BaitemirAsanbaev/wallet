package com.example.baitemir.wallet.repositories;

import com.example.baitemir.wallet.enteties.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

}
