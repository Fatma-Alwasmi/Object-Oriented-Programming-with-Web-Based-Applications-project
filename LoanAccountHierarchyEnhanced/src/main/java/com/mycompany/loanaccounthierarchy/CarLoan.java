/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loanaccounthierarchy;

/**
 *
 * @author fatmaal-wasmi
 */
public class CarLoan extends LoanAccount{
    
    private String vehicleVIN;
    
    public CarLoan(double principle, double annualInterestRate, int months, String vehicleVIN) {
        
        super(principle,annualInterestRate, months);
        this.vehicleVIN = vehicleVIN;
    }
    
    @Override
    public String toString(){
        return "Car Loan with:\n" + super.toString() + "Vehicle VIN: "+ vehicleVIN + "\n";
    }
}
