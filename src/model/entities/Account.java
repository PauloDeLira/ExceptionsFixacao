package model.entities;

import model.exceptions.AccountException;

import java.nio.channels.AcceptPendingException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;


    public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws AccountException {
        if(balance < 0){
            throw new AccountException("Balance can't be negative");
        }

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }


    public void deposit(Double amount) throws AccountException{
        if(amount < 0 ){
            throw new AccountException("Amount to deposite can't be negative.");
        }

        balance += amount;
        System.out.println(amount + " deposited in the account");
        System.out.println("Current balance: " + balance);
    }

    public void withdraw(Double amount) throws AccountException{
        if (amount > withdrawLimit){
            throw new AccountException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > balance){
            throw new AccountException("Withdraw error: Not enough balance");
        }


        balance -= amount;
        System.out.println("New balance after withdraw: " + balance);

    }




    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }


    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                ", withdrawLimit=" + withdrawLimit +
                '}';
    }
}
