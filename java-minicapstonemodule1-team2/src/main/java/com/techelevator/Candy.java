package com.techelevator;

public class Candy extends Items {

    private int inventory;

    public Candy(String name, double price, String slotLocation, String type, int inventory) {

        super(name, price, slotLocation, type, inventory);

    }


    //methods
    public void getCandy() {

        if (inventory == 0) {
            System.out.println("SOLD OUT");
        }
        else {
            inventory -= 1;
        }
    }

}
