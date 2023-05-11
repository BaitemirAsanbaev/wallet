package com.example.baitemir.wallet.repositories;

import com.example.baitemir.wallet.enteties.IncomeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTypesRepository extends JpaRepository<IncomeTypes, Long> {
}
