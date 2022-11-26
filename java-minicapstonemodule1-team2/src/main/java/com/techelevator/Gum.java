package com.techelevator;

public class Gum extends Items {

    private int inventory;

    public Gum(String name, double price, String slotLocation, String type, int inventory) {

        super(name, price, slotLocation, type, inventory);

    }


    //methods
    public void getGum() {

        if (inventory == 0) {
            System.out.println("SOLD OUT");
        }
        else {
            inventory -= 1;
        }
    }


}
