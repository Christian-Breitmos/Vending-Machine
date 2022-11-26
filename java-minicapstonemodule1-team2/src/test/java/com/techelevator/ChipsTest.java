package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipsTest {


    @Test
    public void chip_test_extract_1() {

        //Arrange
        Chips name = new Chips("Ruffles", 1.50, "A1", "Chips", 5);
        int expected = 0;

        //Act
        name.getChip();
        name.getChip();
        name.getChip();
        name.getChip();
        name.getChip();
        name.getChip();
        int actual = name.getInventory();

        //Act
        Assert.assertEquals(expected, actual);


    }
    @Test
    public void chip_test_specific_inventory() {

        //Arrange
        Chips test = new Chips("Ruffles", 1.50, "A1", "Chips", 5);
        Chips name = new Chips("Ruffles", 1.50, "A1", "Chips", 5);
        int expected = 5;

        //Act
        name.getChip();
        int actual = test.getInventory();

        //Assert
        System.out.println(expected);
        System.out.println(actual);
        System.out.println(name.getInventory());
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void chip_test_get_price() {

        //Arrange
        Chips name = new Chips("Ruffles", 1.50, "A1", "Chips", 5);
        double expected = 1.50;

        //Act
//        double actual = name.getPrice();

        //Assert
//        Assert.assertEquals(expected, actual, 1);

    }

    @Test
    public void chip_test_get_name() {

        //Arrange
        Chips name = new Chips("Ruffles", 1.50, "A1", "Chips", 5);
        String expected = name.getName();

        //Act
        String actual = "Ruffles";

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void chip_test_get_location() {

        //Arrange
        Chips name = new Chips("Ruffles", 1.50, "A1", "Chips", 5);
        String expected = name.getSlotLocation();

        //Act
        String actual = "A1";

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void chip_test_get_map() {

        //Arrange
        Chips name = new Chips("Ruffles", 1.50, "A1", "Chips", 5);
//        name.addChip("A1", name);

    }

}
