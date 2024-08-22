package homework;

import java.util.Date;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the type of account: (1.Checking, 2.Saving)");
        int type = input.nextInt();
        System.out.print("Enter the account ID: ");
        int id = input.nextInt();
        System.out.print("Enter the balance: ");
        double balance = input.nextDouble();
        double limit = 0;
        if (type == 1) {
            System.out.print("Enter the limit: ");
            limit = input.nextDouble();
            CheckingAccount checkingAccount = new CheckingAccount(id, balance, limit);
        }
        else if (type == 2) {
            SavingsAccount savingsAccount = new SavingsAccount(id, balance);
        }
        for (int i = 0; i < 100; i++) {
            menu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    Account.withdraw(id,balance);
                    continue;
                case 2:
                    if (type == 1) {
                        System.out.print("Enter the amount to deposit: ");
                        double amount = input.nextDouble();
                        Account.CheckingDeposit(id,amount,limit);
                    }
                    else if (type == 2) {
                        System.out.print("Enter the amount to deposit: ");
                        double amount = input.nextDouble();
                        Account.deposit(id,amount);
                    }
                    continue;
                case 3:
                    System.out.println("Balance: " + Account.getBalance());
                    continue;
                case 4:
                    System.out.println("Date created: " + Account.getDateCreated());
                    continue;
                case 5:
                    System.out.println("Annual Interest Rate: " + Account.getAnnualInterestRate());
                    continue;
                case 6:
                    System.out.println("Monthly Interest Rate: " + Account.getMonthlyInterestRate());
                    continue;
                case 7:
                    System.out.print("Enter the new balance: ");
                    double newBalance = input.nextDouble();
                    Account.setBalance(newBalance);
                    continue;
                case 8:
                    System.out.print("Enter the new Annual Interest Rate: ");
                    double newAnnualInterestRate = input.nextDouble();
                    Account.setAnnualInterestRate(newAnnualInterestRate);
                    continue;
                case 9:
                    System.out.print("Enter the new ID: ");
                    int newID = input.nextInt();
                    Account.changeId(newID);
                    continue;
                case 10:
                    System.out.print("Enter the new limit: ");
                    double newLimit = input.nextDouble();
                    CheckingAccount.setLimit(newLimit);
                    continue;
                case 11:
                    System.out.println("Limit: " + CheckingAccount.getLimit());
                    continue;
                case 12:
                    System.out.println(Account.MaketoString());
                case 13:
                    break;
            }
        }
    }
    public static void menu(){
        System.out.println("Enter your command:");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Check Balance");
        System.out.println("4.Check Date Created");
        System.out.println("5.Check Annual Interest Rate");
        System.out.println("6.Check Monthly Interest Rate");
        System.out.println("7.Set Balance");
        System.out.println("8.Set Annual Interest Rate");
        System.out.println("9.Set ID");
        System.out.println("10.Set Limit");
        System.out.println("11.Check Limit");
        System.out.println("12.To String");
        System.out.println("13.Exit Account");
        System.out.print("Enter your choice: ");
    }
}

class Account {
    private static int id = 0;
    private static double balance = 0;
    private static double annualInterestRate = 0;
    private static Date dateCreated;
    private static double limit = 0;
    public Account() {}
    public Account(int id, double balance) {
        dateCreated = new Date();
        Account.id = id;
        Account.balance = balance;
    }
    public static void withdraw(double balance, double amount) {
        balance += amount;
    }
    public static void deposit(double id, double amount) {
        if(balance >= amount) {
            balance -= amount;
        }
        else {
            System.out.println("You don't have enough money.");
        }
    }
    public static void CheckingDeposit(int id, double amount, double limit) {
        if(balance + limit >= amount) {
            balance -= amount;
        }
        else {
            System.out.println("You don't have enough money or over the limit.");
        }
    }
    public static int getId() {
        return id;
    }
    public static double getBalance() {
        return balance;
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public static Date getDateCreated() {
        return dateCreated;
    }
    public static void setBalance(double balance) {
        Account.balance = balance;
    }
    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }
    public static void changeId(int id) {
        Account.id = id;
    }
    public static double getMonthlyInterestRate() {
        return annualInterestRate/12;
    }
    public static double getMonthlyInterest() {
        return balance*getMonthlyInterestRate();
    }
    public static double getLimit() {
        return limit;
    }
    public static void setLimit(double limit) {
        Account.limit = limit;
    }


    public static String MaketoString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", dateCreated=" + dateCreated +
                ", limit=" + limit +
                '}';
    }
}

class CheckingAccount extends Account {
    private static double limit = 0;
    public CheckingAccount() {}
    public CheckingAccount(int id, double balance, double limit) {
        super(id, balance);
        CheckingAccount.limit = limit;
    }
    public void withdraw(int id, int amount) {
        Account.withdraw(id, amount);
    }
    public void deposit(int id, int amount) {
        CheckingDeposit(id, amount, limit);
    }
    public static String MaketoString(){
        return Account.MaketoString();
    }
    public static double getLimit() {
        return limit;
    }
    public static void setLimit(double limit) {
        CheckingAccount.limit = limit;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount() {}
    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }
    public void withdraw(int id, int amount) {
        Account.withdraw(id, amount);
    }
    public void deposit(int id, int amount) {
        Account.deposit(id, amount);
    }
    public static String MaketoString(){
        return Account.MaketoString();
    }
}