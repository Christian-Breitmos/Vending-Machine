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

public class VendingMachineVisualItems implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Here are the list of items");
    JButton displayChips = new JButton("Display Chips");
    JButton displayDrinks = new JButton("Display Drinks");
    JButton displayGum = new JButton("Display Gum");
    JButton displayCandy = new JButton("Display Candy");

    public VendingMachineVisualItems() {

        label.setBounds(300, 100, 400, 100);
        label.setFont(new Font(null,Font.PLAIN,25));
        frame.add(label);

        displayChips.setBounds(250, 400, 400, 100);
        displayChips.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(displayChips);

        displayDrinks.setBounds(250, 250, 400, 100);
        displayDrinks.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(displayDrinks);

        displayGum.setBounds(250, 550, 400, 100);
        displayGum.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(displayGum);

        displayCandy.setBounds(250, 700, 400, 100);
        displayCandy.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(displayCandy);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setLayout(null);
        frame.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
