package com.company;


public class BankAccount {
    private long accNumber;
    private String owner;
    private String name;
    private double balance;

public BankAccount() {
    this.accNumber = accNumber;
    this.owner = owner;
    this.name = name;
    this.balance = balance;
}

    public long getAccNumber() {
        return accNumber;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static class Builder {
        private long accNumber;
        private String owner;
        private String name;
        private double balance;

        public Builder(long accNumber) {
            this.accNumber = accNumber;
        }

        public Builder() {

        }

        public Builder Owner(String owner) {
            this.owner = owner;

            return this;
        }

        public Builder Name(String name) {
            this.name = name;

            return this;
        }

        public Builder Balance(double balance) {
            this.balance = balance;

            return this;
        }

        public BankAccount build() {
            BankAccount account = new BankAccount();
            account.accNumber = this.accNumber;
            account.owner = this.owner;
            account.balance = this.balance;
            return account;
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount.Builder().build();
    }

}