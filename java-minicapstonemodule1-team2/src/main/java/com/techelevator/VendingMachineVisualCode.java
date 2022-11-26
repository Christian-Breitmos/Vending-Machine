package com.techelevator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class VendingMachineVisualCode implements ActionListener {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("Welcome to Tech Vending Machine");
        JButton displayItems = new JButton("1) Display Items");
        JButton purchaseItems = new JButton("2 Purchase Items");
        JButton exitButton = new JButton("Exit");

        VendingMachineVisualCode() {

            label.setBounds(0,0,500,50);
            label.setFont(new Font(null,Font.PLAIN,25));

            frame.add(label);

            displayItems.setBounds(100,160,200,40);
            displayItems.setFocusable(false);
            displayItems.addActionListener(this);

            purchaseItems.setBounds(100,260,200,40);
            purchaseItems.setFocusable(false);
            purchaseItems.addActionListener(this);

            exitButton.setBounds(100,360,200,40);
            exitButton.setFocusable(false);
            exitButton.addActionListener(this);

            frame.add(displayItems);
            frame.add(purchaseItems);
            frame.add(exitButton);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 900);
            frame.setLayout(null);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == displayItems) {
                frame.dispose();
                VendingMachineVisualItems newWindow = new VendingMachineVisualItems();
            }



        }
    }

