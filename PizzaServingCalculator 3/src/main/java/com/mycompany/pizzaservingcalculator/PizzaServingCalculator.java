/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pizzaservingcalculator;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author fatmaal-wasmi
 */
public class PizzaServingCalculator{


    
        

    
    public static void main(String[] args) {
        PizzaServingCalculatorGui labelFrame = new PizzaServingCalculatorGui();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(350,300);
        labelFrame.setVisible(true);
        

        
  
    }
}
