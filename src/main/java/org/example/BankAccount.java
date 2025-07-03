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
            System.out.println("Invalid input. Enter valid amount");
        }else{
            this.availableBalance += depositAmnt;
            System.out.println("Php " + depositAmnt + " deposited");
        }
        return 0.0;
    }
    public double withdrawThat(double withdrawAmnt){
        if(withdrawAmnt<=0 || withdrawAmnt > this.availableBalance){
            System.out.println("Invalid input. Enter valid amount");
        }else{
            this.availableBalance -= withdrawAmnt;
            System.out.println("Php " + withdrawAmnt + " withdrawed");
        }
        return 0.0;
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
