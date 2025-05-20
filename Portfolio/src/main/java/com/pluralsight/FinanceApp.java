package com.pluralsight;

import com.pluralsight.fiance.BankAccount;
import com.pluralsight.fiance.Valuable;

public class FinanceApp {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(123, "Pam", 12500);
        Valuable account2 = new BankAccount(456, "Gary", 1500);

        // attempt to deposit into both accounts
        account1.deposit(100);
        // account2.deposit(100);

        System.out.println("Account1 Balance: " + account1.getValue());
        System.out.println("Account2 Balance: " + account2.getValue());
    }
}


