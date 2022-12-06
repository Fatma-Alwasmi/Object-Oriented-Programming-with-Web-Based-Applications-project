/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.loanaccount;

/**
 *
 * @author fatmaal-wasmi
 */

// class called LoanAccount with 2 instance variables annualInterestRate and principle
public class LoanAccount {
    
    private static double annualInterestRate; // stores the annual interest rate for all account holders
    private double principal; 
    
    //constructor to set annual interest rate
    public static void setAnnualInterestRate(double newVal){
        annualInterestRate = newVal;
        
    }
    // constructor, indicates the ammount a person is borrowing
    public LoanAccount(double amount){
        
        principal = amount;
                
    }
    //method to calculate monthly payment
    public double calculateMonthlyPayment(int numberOfPayments){
        
        double monthlyInterest = annualInterestRate/12;
        double monthlyPayment = principal * ( monthlyInterest / (1 - Math.pow(1 + monthlyInterest, -numberOfPayments)));
        
        return monthlyPayment;
    }
    
    //instantiates 2 loan account objects with 2 principle ammounts with annualInterestRate set to 
    //1% and 5% and calculates monthly payments for for 36 months, 60 months, and 72 months and 
    //prints the monthly payment amounts for both loans
    public static void main(String[] args) {
        LoanAccount loan1 = new LoanAccount(5000.00);
        LoanAccount loan2 = new LoanAccount(31000.00);
        
        LoanAccount.setAnnualInterestRate(.01);
        
        double loan1a = loan1.calculateMonthlyPayment(36);
        double loan1b = loan1.calculateMonthlyPayment(60);
        double loan1c = loan1.calculateMonthlyPayment(72);
        
        
        double loan2a = loan2.calculateMonthlyPayment(36);
        double loan2b = loan2.calculateMonthlyPayment(60);
        double loan2c = loan2.calculateMonthlyPayment(72);
        
        
        LoanAccount.setAnnualInterestRate(.05);
        
        double loan1d = loan1.calculateMonthlyPayment(36);
        double loan1e = loan1.calculateMonthlyPayment(60);
        double loan1f = loan1.calculateMonthlyPayment(72);
        
        
        double loan2d = loan2.calculateMonthlyPayment(36);
        double loan2e = loan2.calculateMonthlyPayment(60);
        double loan2f = loan2.calculateMonthlyPayment(72);
        
        System.out.println("Monthly paments for loan1 of $5000.00 and loan2 $31000.00 for 3, 5, and 6 years at 1% interest.");
        
        System.out.printf("%-7s%-9s%-9s%-9s\n", "Loan","3 years", "5 years", "6 years");
        System.out.printf("%-7s%-9.2f%-9.2f%-9.2f\n", "Loan1",loan1a, loan1b, loan1c);
        System.out.printf("%-7s%-9.2f%-9.2f%-9.2f\n", "Loan2",loan2a, loan2b, loan2c);
        
        System.out.print(" \n");
        
        System.out.println("Monthly paments for loan1 of $5000.00 and loan2 $31000.00 for 3, 5, and 6 years at 5% interest.");
       
        System.out.printf("%-7s%-9s%-9s%-9s\n", "Loan","3 years", "5 years", "6 years");
        System.out.printf("%-7s%-9.2f%-9.2f%-9.2f\n", "Loan1",loan1d, loan1e, loan1f);
        System.out.printf("%-7s%-9.2f%-9.2f%-9.2f\n", "Loan2",loan2d, loan2e, loan2f);
        
        
        
    }
}
