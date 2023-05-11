package com.example.baitemir.wallet.enteties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int balance;

    @OneToMany(mappedBy = "balance", cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<Income> income;

    @OneToMany(mappedBy = "balance", cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<Expense> expense;



    @OneToMany(mappedBy = "from", cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<Transaction> lostTransaction;

    @OneToMany(mappedBy = "to", cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<Transaction> gotTransaction;

    public Balance(long id, String title, int balance, Set<Income> income, Set<Expense> expense, Set<Transaction> lostTransaction, Set<Transaction> gotTransaction) {
        this.id = id;
        this.title = title;
        this.balance = balance;
        this.income = income;
        this.expense = expense;
        this.gotTransaction = gotTransaction;
        this.lostTransaction = lostTransaction;
    }

    public Set<Income> getIncome() {
        return income;
    }

    public void setIncome(Set<Income> income) {
        this.income = income;
    }

    public Set<Expense> getExpense() {
        return expense;
    }

    public void setExpense(Set<Expense> expense) {
        this.expense = expense;
    }

    public Balance() {
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getBalance() {
        return balance;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Set<Transaction> getLostTransaction() {
        return lostTransaction;
    }

    public void setLostTransaction(Set<Transaction> lostTransaction) {
        this.lostTransaction = lostTransaction;
    }

    public Set<Transaction> getGotTransaction() {
        return gotTransaction;
    }

    public void setGotTransaction(Set<Transaction> gotTransaction) {
        this.gotTransaction = gotTransaction;
    }
}
