package com.techelevator;

public class Drink extends Items {

    private int inventory;

    public Drink(String name, double price, String slotLocation, String type, int inventory) {

        super(name, price, slotLocation, type, inventory);


    }



    //methods
    public void getDrink() {

        if (inventory == 0) {
            System.out.println("SOLD OUT");
        }
        else {
            inventory -= 1;
        }
    }
}
