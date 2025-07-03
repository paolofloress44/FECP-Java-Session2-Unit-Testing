package org.example;


import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<BankAccount> bankAccount = new ArrayList<>();
    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("=== Bank Menu === \n1. Create Account\n2. View All Accounts\n3. Check Balance\n4. Deposit\n5. Withdraw\n6. Exit\n");
            System.out.print("Enter choice (1-5): ");
            choice = getUserChoice();
            switch (choice){
                case 1:
                    createAccnt();
                    break;
                case 2:
                    viewAccnts();
                    break;
                case 3:
                    checkBal();
                    break;
                case 4:
                    handleDeposit();
                    break;
                case 5:
                    handleWithdraw();
                    break;
                case 6:
                    System.out.println("=== Thank you! ===");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }while(choice!=6);
        sc.close();
    }
    private static int getUserChoice(){
        while(!sc.hasNextInt()){
            System.out.println("Invalid ");
            sc.next();
            System.out.println("Enter choice (1-5): ");
        }
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    private static void createAccnt(){
        System.out.print("Enter Account Number: ");
        int accountNum = sc.nextInt();
        if(accountNum <= 0){
            System.out.println("Invalid input.");
            return;
        }
        for(BankAccount account : bankAccount){
            if(account.getAccountNumber() == accountNum){
                System.out.println("Account number already exists");
                return;
            }
        }
        System.out.print("Enter Holder Name: ");
        String accountHolder = sc.next();
        System.out.print("Initial deposit? (yes/no): ");
        String initDepositQ = sc.next().toUpperCase();
        double initDepositAmnt = 0.0;
        if(initDepositQ.equals("YES")){
            System.out.print("Enter initial deposit amount: ");
            while(!sc.hasNextDouble()){
                System.out.println("Invalid input.");
                sc.next();
                System.out.println("Enter initial deposit amount: ");
            }
            initDepositAmnt = sc.nextDouble();
            sc.nextLine();

            if(initDepositAmnt<0){
                System.out.println("Initial deposit cannot be negative.");
                return;
            }
        }
        BankAccount newAccount = new BankAccount(accountNum, accountHolder, initDepositAmnt);
        bankAccount.add(newAccount);
        System.out.println("Account created syccessfully!");
    }
    private static BankAccount findAccount(int accountNumber){
        for(BankAccount account : bankAccount){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        return null;
    }
    private static void viewAccnts(){
        if(bankAccount.isEmpty()){
            System.out.println("No accounts to display");
            return;
        }
        System.out.println("\n--- All Bank Accounts ---");
        for (BankAccount account : bankAccount) {
            account.displayInformation();
            System.out.println("-------------------------");
        }
    }


    private static void checkBal() {
        System.out.print("Enter Account Number: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
            System.out.print("Enter Account Number: ");
        }
        int accountNumber = sc.nextInt();
        sc.nextLine();

        BankAccount foundAccount = findAccount(accountNumber);
        if (foundAccount != null) {
            System.out.println("\n--- Account Balance ---");
            foundAccount.displayInformation();
            System.out.println("-----------------------");
        } else {
            System.out.println("Account not found with number: " + accountNumber);
        }
    }

    private static void handleDeposit() {
        System.out.print("Enter Account Number: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
            System.out.print("Enter Account Number: ");
        }
        int accountNumber = sc.nextInt();
        sc.nextLine();

        BankAccount foundAccount = findAccount(accountNumber);
        if (foundAccount != null) {
            System.out.print("Enter amount to deposit: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid amount.");
                sc.next();
                System.out.print("Enter amount to deposit: ");
            }
            double depositAmount = sc.nextDouble();
            sc.nextLine();

            foundAccount.addDeposit(depositAmount);
        } else {
            System.out.println("Account not found with number: " + accountNumber);
        }
    }

    private static void handleWithdraw() {
        System.out.print("Enter Account Number: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
            System.out.print("Enter Account Number: ");
        }
        int accountNumber = sc.nextInt();
        sc.nextLine();

        BankAccount foundAccount = findAccount(accountNumber);
        if (foundAccount != null) {
            System.out.print("Enter amount to withdraw: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid amount.");
                sc.next();
                System.out.print("Enter amount to withdraw: ");
            }
            double withdrawAmount = sc.nextDouble();
            sc.nextLine();

            foundAccount.withdrawThat(withdrawAmount);
        } else {
            System.out.println("Account not found with number: " + accountNumber);
        }
    }
    //public static void createAccnt(ArrayList<Integer> bankAccount, int accountNum){}
}