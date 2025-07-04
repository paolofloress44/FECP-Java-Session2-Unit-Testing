package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double availableBalance;

    public BankAccount(int accountNumber, String name, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = name;
        this.availableBalance = balance;
    }
    public double addDeposit(double depositAmnt){
        if(depositAmnt<=0){
            System.out.println("Invalid input. Enter a positive amount for deposit.");
        }else{
            this.availableBalance += depositAmnt;
            System.out.println("Php " + depositAmnt + " deposited");
            return depositAmnt;
        }
        return depositAmnt;
    }
    public double withdrawThat(double withdrawAmnt){
        if(withdrawAmnt<=0){
            System.out.println("Invalid input. Enter a positive amount for withdrawal.");
        }else if (withdrawAmnt > this.availableBalance){
            System.out.println("Insufficient balance. Available: Php " + this.availableBalance);
            return this.availableBalance;
        } else {
            this.availableBalance -= withdrawAmnt;
            System.out.println("Php " + withdrawAmnt + " withdrawn");
            return withdrawAmnt;
        }
        return withdrawAmnt;
    }
    public void displayInformation(){
        System.out.println("Account Holder: " + this.accountHolderName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Available Balance: " + this.availableBalance);
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
}
