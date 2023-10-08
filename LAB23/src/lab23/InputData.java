/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab23;

import java.util.Scanner;

/**
 *
 * @author Luu Bach
 */
class InputData {

    Scanner sc = new Scanner(System.in);

    String enterID() {
        System.out.print("Enter Fruit's Id:");
        String Id = sc.nextLine().trim();
        //check if Id is empty
        if (Id.isEmpty()) {
            System.out.println("Id can't be empty!!!");
            return enterID();
        }
        //check if Name cointains (one or many)character from a to z or A to Z or space frm the start to the end of the string
        if (!Id.matches("^[a-zA-Z0-9]+$")) {
            System.out.println("Invalid Id type!!!");
            return enterID();
        }
        return Id;

    }

    String enterString(String message) {
        System.out.print(message);
        String Name = sc.nextLine().trim();
        //check if Name cointains (one or many)character from a to z or A to Z or space frm the start to the end of the string
        if (!Name.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Invalid type!!!");
            return enterString(message);
        }
        return Name;
    }

    int enterPrice() {
        int Price;
        try {
            //while loop with price smaller than 0
            System.out.print("Enter price: ");
            Price = Integer.parseInt(sc.nextLine());
            if (Price <= 0) {
                System.out.println("Price must bigger than 0 !!!");
                return enterPrice();
            }
        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid Price!!!");
            return enterPrice();
        }
        return Price;
    }

    int enterQuantity() {
        int Quantity;
        try {

            System.out.print("Input quantity: ");
            Quantity = Integer.parseInt(sc.nextLine());
            if (Quantity == 0) {
                System.out.println("Quantity can't be 0!!!");
                return enterQuantity();
            }
        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid price must be a positive number!!!");
            return enterQuantity();
        }
        return Quantity;
    }

    String enterChoiceForYesNo() {
        String choice = sc.nextLine().trim();
        //check choice with zero or many space follow by Y or N follow by zero or many space
        if (!choice.matches("^[YN]$")) {
            System.out.println("Not a valid option, please type again!!!");
            return enterChoiceForYesNo();
        }
        return choice;
    }

    int enterItemBuyer(int size) {
        int choice;
        try {
            System.out.print("Enter item you want to buy: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice <= 0 || choice > size) {
                System.out.println("There is no such item !!!");
                return enterItemBuyer(size);
            }

        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid Option!!!");
            return enterItemBuyer(size);
        }
        return choice;
    }
}
