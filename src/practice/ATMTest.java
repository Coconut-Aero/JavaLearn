package practice;

import java.util.Scanner;

public class ATMTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATM atm = new ATM();
        ATM.init();
        boolean exit;
        for (int i = 0; i < 100; i++) {
            System.out.print("Enter Customer ID: ");
            int id = input.nextInt();
            if(id > 9){
                System.out.println("Not invalid customer ID");
                exit = true;
            }
            else exit = false;
            while(!exit) {
                System.out.println("Main MENU");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw ");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.print("Enter your choice:");
                int choice = input.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println("The balance is: " + atm.checkBalance(id));
                        continue;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        int amountWithdraw = input.nextInt();
                        atm.withdraw(id, amountWithdraw);
                        continue;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        int amountDeposit = input.nextInt();
                        atm.deposit(id, amountDeposit);
                        continue;
                    case 4:
                        exit = true;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }
}

class ATM {
    static int[][] idAndBalance = new int[2][10];
    public static void init() {
        for (int i = 0; i < 10; i++) {
            idAndBalance[0][i] = i;
            idAndBalance[1][i] = 100;
        }
    }
    public int checkBalance(int id) {
        return idAndBalance[1][id];
    }
    public void withdraw(int id, int amount) {
        idAndBalance[1][id] += amount;
    }
    public void deposit(int id, int amount) {
        if(idAndBalance[1][id] >= amount) {
            idAndBalance[1][id] -= amount;
        }
        else {
            System.out.println("You don't have enough money.");
        }
    }
}
