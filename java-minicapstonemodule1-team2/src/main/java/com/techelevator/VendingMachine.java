package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.security.Key;
import java.util.HashMap;

public class VendingMachine {

    private double balance;
    private HashMap<String, Items> hashMap;

    public VendingMachine(HashMap<String, Items> hashMap) {

        this.hashMap = hashMap;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void feedMoney(double money) {
        if (money < 1.00) {
            System.out.println("Only whole dollar values, no change. ");
        }
        else {
            balance += money;
        }
    }


    public String listItems() {

        System.out.println("What type of item do you want? ");
        System.out.println("(1) Chips");
        System.out.println("(2) Gum");
        System.out.println("(3) Drink");
        System.out.println("(4) Candy");
        return "";
    }

    public String listRow(int num) {

        if (num == 1) {
            System.out.println(hashMap.get("A1").getItemInfo());
            System.out.println(hashMap.get("A2").getItemInfo());
            System.out.println(hashMap.get("A3").getItemInfo());
            System.out.println(hashMap.get("A4").getItemInfo());
        }
        else if (num == 2) {
            System.out.println(hashMap.get("B1").getItemInfo());
            System.out.println(hashMap.get("B2").getItemInfo());
            System.out.println(hashMap.get("B3").getItemInfo());
            System.out.println(hashMap.get("B4").getItemInfo());
        }
        else if (num == 3) {
            System.out.println(hashMap.get("C1").getItemInfo());
            System.out.println(hashMap.get("C2").getItemInfo());
            System.out.println(hashMap.get("C3").getItemInfo());
            System.out.println(hashMap.get("C4").getItemInfo());
        }
        else if (num == 4) {
            System.out.println(hashMap.get("D1").getItemInfo());
            System.out.println(hashMap.get("D2").getItemInfo());
            System.out.println(hashMap.get("D3").getItemInfo());
            System.out.println(hashMap.get("D4").getItemInfo());
        } else {
            System.out.println("Invalid input blind ass idiot");
        }
        return "";

    }

    public String dispenseItem(String key) {
        if (hashMap.get(key).getInventory() == 0) {
            return "OUT OF STOCK";
        }
        else if (balance >= hashMap.get(key).getPrice()) {
            String cornyQuote = "";
            hashMap.get(key).dispenseItems();
            withDrawMoney(hashMap.get(key).getPrice());
            System.out.println("There are now " + hashMap.get(key).getInventory() +  " left in stock");
            if (hashMap.get(key).getType().equals("Chip")) {
                cornyQuote = "Crunchy Crunchy, Yum!";
            }
            if (hashMap.get(key).getType().equals("Drink")) {
                cornyQuote = "Slurp Slurp, Yum!";
            }
            if (hashMap.get(key).getType().equals("Candy")) {
                cornyQuote = "Munch Munch, Yum!";
            }
            if (hashMap.get(key).getType().equals("Gum")) {
                cornyQuote = "Chewy Chewy, Yum!";
            }
            return "Here is your " + hashMap.get(key).getName() + " " + cornyQuote;
        }
        return "Not enough money, your balance is: $" + getBalance();
    }

    public double withDrawMoney(double price) {
        balance -= price;
        return balance;
    }


    public void buyItem(String slotLocation) {

        hashMap.get(slotLocation).getPrice();
        hashMap.get(slotLocation).dispenseItems();


    }

    public String returnChange() {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;


            while (balance >= 0.25) {
                balance -= 0.25;
                quarters++;
            }
            while (balance >= 0.10) {
                balance -= 0.10;
                dimes++;
            }
            if (balance < 0.06 && balance > 0.04) {
                balance -= (double) 0.05;
                nickels++;

            }

        balance = 0;
        return "Your change is: " + quarters + " quarters " + dimes + " dimes " +nickels +  " nickels ";


    }


}
