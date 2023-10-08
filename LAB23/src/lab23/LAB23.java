/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab23;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Luu Bach
 */
public class LAB23 {

    public static void main(String[] args) {
        ManageShop manage = new ManageShop();
        ArrayList<Fruit> fruitList = new ArrayList();
        Hashtable<String, ArrayList<Order>> shoppingList = new Hashtable();
        while (true) {
            // step 1: Display 3 functions in Main Screen.
            functionMenu();
            // step 2 : User enter their choice.
            int Choice = userChoice();
            //step 3: Perform the function that user choose.
            switch (Choice) {
                case 1:
                    manage.manageCreateFruit(fruitList);
                    break;
                case 2:
                    manage.viewOrders(shoppingList);
                    break;
                case 3:
                    manage.shoppingManagement(fruitList, shoppingList);
                    break;
                case 4:
                    System.out.println("Exiting.... !!!");
                    System.exit(0);
                    break;
            }
        }
    }

    private static void functionMenu() {
        System.out.println("");
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit ");
        System.out.println("2. View orders");
        System.out.println("3. Shopping(for buyer)");
        System.out.println("4. Exit\n");
        System.out.println("(Please choose 1 to create product, 2 to view orders, 3 for shopping,4 to Exit program)");

    }

    private static int userChoice() {
        Scanner sc = new Scanner(System.in);
        int choice;
        try {
            //while loop with choice smaller than 0
            do {
                System.out.print("Enter your choice:");
                choice = Integer.parseInt(sc.nextLine());
                if (choice <= 0 || choice > 4) {
                    System.out.println("Must be between [1,4] !!!");
                    return userChoice();
                }

            } while (choice < 0);
        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid Option!!!");
            return userChoice();
        }
        return choice;
    }

}
