/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaservingcalculator;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Font;


/**
 *
 * @author fatmaal-wasmi
 */
public class PizzaServingCalculatorGui extends JFrame{
    private JLabel title;
    private JLabel instruction;
    private JLabel result;
    private JTextField text;
    private JButton button;
    private GridLayout grid_layout;
    private JPanel panel;
    private JPanel line2;


        
    public PizzaServingCalculatorGui(){
        
        
        
        super("Pizza Servings Calculator");
        setLayout(new FlowLayout());
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new GridLayout(4,1));

        title = new JLabel("Pizza Servings Calculator",JLabel.CENTER);
        title.setForeground(Color.red);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 20));  
        
        
        
        instruction = new JLabel("Enter the size of the pizza in inches: ");
        instruction.setHorizontalTextPosition(SwingConstants.CENTER);


        text = new JTextField(4);
        
        
        button = new JButton("Calculate Servings");

        
        ButtonHandler handler = new ButtonHandler();
        button.addActionListener(handler);
        
        result = new JLabel(" ");
        
        
        line2 = new JPanel();
        setContentPane(line2);
        line2.add(instruction);
        line2.add(text);
        
        
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new GridLayout(4,1));
        panel.add(title);
        panel.add(line2);
        panel.add(button);
        panel.add(result);
                
        
        

        
    }
        private class ButtonHandler implements ActionListener{
            
            @Override
            public void actionPerformed(ActionEvent event){
            String input = text.getText();
            double size = Double.parseDouble(input);
            double servings = Math.pow(size/8,2);

            result.setText(String.format("             A "+ size +" inch pizza will serve " + String.format("%.2f",servings)  + " people"));
            
            }    
        }
        
        
        
    }
