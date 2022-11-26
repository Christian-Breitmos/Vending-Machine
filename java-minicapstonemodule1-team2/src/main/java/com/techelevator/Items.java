package com.techelevator;

import java.math.BigDecimal;

public abstract class Items {

    private String name;
    private double price;
    private String slotLocation;
    private String type;
    private int inventory;


    public Items(String name, double price, String slotLocation, String type, int inventory) {
        this.name = name;
        this.price = price;
        this.slotLocation = slotLocation;
        this.type = type;
        this.inventory = inventory;
    }

    public void dispenseItems() {

        if (inventory == 0 ) {

        }
        else {
            inventory -= 1;
        }
    }

    public String getItemInfo() {
        String info = slotLocation + ") " + name + " " + "$" + price;

        return info;
    }

    public int getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getType() {
        return type;
    }


}
