package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;

public class Chips extends Items{

    private int inventory;
    private HashMap <String, Chips> chipsHashMap;


    public Chips(String name, double price, String slotLocation, String type, int inventory) {

        super(name, price, slotLocation, type, inventory);


    }

    //getters and setters



    //methods
    public void getChip() {

        if (inventory == 0) {
            System.out.println("SOLD OUT");
        }
        else {
            inventory -= 1;
        }
    }

    public void addChip(Chips chip) {
        chipsHashMap.put("A1", chip);
    }




}
