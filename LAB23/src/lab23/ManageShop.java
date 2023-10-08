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
class ManageShop {

    InputData input = new InputData();

    void manageCreateFruit(ArrayList<Fruit> fruitList) {
        String option = "";
        //do while loop with option is equal to "Y"
        do {
            createFruit(fruitList);
            System.out.println("Do you want to continue (Y/N)?");
            option = input.enterChoiceForYesNo();
        } while (option.equals("Y"));
        // option is equal to "N"
        if (option.equals("N")) {
            displayListFruitForOwner(fruitList);
            return;
        }
    }

    void createFruit(ArrayList<Fruit> fruitList) {
        String id = input.enterID();
        //loop access to every fruit in the FruitList
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitID().equals(id)) {
                System.out.println("That Fruit's Id is already exist!!!");
                return;
            }
        }
        String name = input.enterString("Enter Fruit Name: ");
        int price = input.enterPrice();
        int quantity = input.enterQuantity();
        String Origin = input.enterString("Enter Origin: ");
        fruitList.add(new Fruit(id, name, price, quantity, Origin));
    }

    void displayListFruitForOwner(ArrayList<Fruit> fruitList) {
        System.out.println("List of all your products:");
        System.out.println("ID  |  Name  |  Price  |  Quantity  |  Origin");
        // Loop to access each element in the Fruit List
        for (Fruit fruit : fruitList) {
            System.out.printf("%-4s   %-6s   %-7d  %-9d   %-6s%n",
                    fruit.getFruitID(),
                    fruit.getFruitName(),
                    fruit.getPrice(),
                    fruit.getQuantity(),
                    fruit.getOrigin());
        }
    }

    void viewOrders(Hashtable<String, ArrayList<Order>> shoppingList) {
        //shoppingList is empty
        if (shoppingList.isEmpty()) {
            System.out.println("There are currently no orders !!! ");
            return;
        }
        System.out.println("");
        //loop through all element the key set of shopping which contain name of customer
        for (String i : shoppingList.keySet()) {
            ArrayList<Order> viewOrder = new ArrayList();
            viewOrder = shoppingList.get(i);
            //loop access from the first element to the last element of ViewOrder array list
            for (int j = 0; j < viewOrder.size(); j++) {
                int totalValue = 0;
                System.out.print("Customer:");
                System.out.println(i);
                System.out.println("Product | Quantity | Price | Amount");
                for (int k = 0; k < viewOrder.get(j).fruitListOrder.size(); k++) {
                    System.out.println(k + 1 + "." + viewOrder.get(j).getFruitList().get(k).getFruitName() + "       " + viewOrder.get(j).getFruitList().get(k).getQuantity() + "     " + viewOrder.get(j).getFruitList().get(k).getPrice() + "     " + viewOrder.get(j).getFruitList().get(k).getAmount());
                    totalValue += viewOrder.get(j).getFruitList().get(k).getAmount();
                }
                System.out.print("Total: ");
                System.out.println(totalValue + "$");
                System.out.println("");
            }
        }
    }

    void shoppingManagement(ArrayList<Fruit> fruitList, Hashtable<String, ArrayList<Order>> shoppingList) {
        deleteFruitWithQuantity0(fruitList);
        ArrayList<Fruit> orderList = new ArrayList();
        //check if the array list is empty or not
        if (fruitList.isEmpty()) {
            System.out.println("Don't have any product left, please come back later!!!");
            return;
        }
        //while loop woth true
        while (true) {
            displayFruitForShopping(fruitList);
            int item = input.enterItemBuyer(fruitList.size());
            //loop access from the first element to the last element of FruitList array list
            for (int i = 0; i < fruitList.size(); i++) {
                //check if item is exist in the list
                if (item == i + 1) {
                    System.out.println("You selected: " + fruitList.get(i).getFruitName());
                    int buyerQuantity = input.enterQuantity();
                    //check if quantity is in valid number
                    if (fruitList.get(i).getQuantity() < buyerQuantity) {
                        System.out.println("We don't have the amount that you need!!!");
                        break;
                    } else {
                        orderList.add(new Fruit(fruitList.get(i).getFruitName(), buyerQuantity, fruitList.get(i).getPrice()));
                        fruitList.get(i).setQuantity(fruitList.get(i).getQuantity() - buyerQuantity);
                        deleteFruitWithQuantity0(fruitList);
                        if (fruitList.isEmpty()) {
                            System.out.println("Sold out!!!");
                            payOrder(orderList, shoppingList);
                            return;
                        }
                    }
                }
            }
            System.out.println("Do you want to order now (Y/N)?");
            String option = input.enterChoiceForYesNo();
            //while loop check if option is equal to "N"
            if (option.equals("N")) {
                continue;
            }
            //check if option is equal to "Y"
            if (option.equals("Y")) {
                if (orderList.isEmpty()) {
                    System.out.println("There are nothing for you to order!!!");
                    return;
                }
                payOrder(orderList, shoppingList);
                break;
            }
        }
    }

    void displayFruitForShopping(ArrayList<Fruit> FruitList) {
        System.out.println("List of Fruit: ");
        System.out.println("|++ Item ++|++ Fruit Name ++|++ Origin ++|++ Price ++|");
        //loop access to each element in the Fruit List
        for (int i = 0; i < FruitList.size(); i++) {
            Fruit fruit = FruitList.get(i);
            System.out.printf("  %-9d   %-15s   %-11s   %-11s  %n",
                    i + 1,
                    fruit.getFruitName(),
                    fruit.getOrigin(),
                    fruit.getPrice());
        }
    }

    ArrayList<Fruit> deleteFruitWithQuantity0(ArrayList<Fruit> FruitList) {
        //loop access to all fruit in the FruitList
        for (int i = 0; i < FruitList.size(); i++) {
            //if that fruit doesn't have any left
            if (FruitList.get(i).getQuantity() == 0) {
                FruitList.remove(i);
            }
        }
        return FruitList;
    }

    private void payOrder(ArrayList<Fruit> orderList, Hashtable<String, ArrayList<Order>> shoppingList) {
        System.out.println("Here is your bill!!!");
        System.out.println("Product | Quantity | Price | Amount");
        //loop access from the first element to the last element of ListOrder array list
        for (Fruit i : orderList) {
            System.out.printf("  %-7s   %-9s   %-4s   %-5s %n",
                    i.getFruitName(),
                    i.getQuantity(),
                    i.getPrice(),
                    i.getAmount());
        }
        String customerName = input.enterString("Customer Name: ");
        Order order = new Order(customerName, orderList);
        //loop shoppingList
        for (String i : shoppingList.keySet()) {
            //if cutomer name is equal to one of the key name in the shopping list
            if (customerName.equals(i)) {
                shoppingList.get(i).add(order);
                return;
            }
        }
        ArrayList<Order> newList = new ArrayList();
        newList.add(order);
        shoppingList.put(customerName, newList);
    }
}
