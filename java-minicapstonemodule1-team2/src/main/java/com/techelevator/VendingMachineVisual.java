package com.techelevator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class VendingMachineVisual implements ActionListener{


        JFrame frame = new JFrame();
        JButton myButton = new JButton("Vending Machine");
        VendingMachineVisual() {
            myButton.setBounds(100,160,200,40);
            myButton.setFocusable(false);
            myButton.addActionListener(this);

            frame.add(myButton);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900,900);
            frame.setLayout(null);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()== myButton) {
                frame.dispose();
                VendingMachineVisualCode newWindow = new VendingMachineVisualCode();
            }
        }
    }

