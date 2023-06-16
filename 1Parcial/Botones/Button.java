/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author yazminurzuac
 */

import javax.swing.*;
import java.awt.event.*;
public class Button extends BFrame implements ActionListener {
 
    private JButton boton1,boton2;
    private JLabel label1;
    public Button() {
        setLayout(null);
        boton1=new JButton("1");
        boton1.setBounds(10,100,90,30);
        add(boton1);
        boton1.addActionListener(this);
        boton2=new JButton("2");
        boton2.setBounds(210,100,90,30);
        add(boton2);
        boton2.addActionListener(this);
        label1=new JLabel("Bienvenido");
        label1.setBounds(10,100,90,30);
        add(label1);
        label1.setBounds(150, 50, 90, 30);
       
             	
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            label1.setText("Hola");
            
        }else if (e.getSource()==boton2) {
            label1.setText("Adiós");
        }
        
    }
    
    public static void main(String[] ar){
        Button button1=new Button();
        button1.setBounds(0,0,350,200);
        button1.setVisible(true);
        button1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}