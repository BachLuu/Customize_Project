/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab23;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Luu Bach
 */
class Order {

    String customerName;
    ArrayList<Fruit> fruitListOrder = new ArrayList();

    public Order(String customerName, ArrayList<Fruit> fruitListOrder) {
        this.customerName = customerName;
        this.fruitListOrder = fruitListOrder;
    }

    public Order() {
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitListOrder = fruitList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitListOrder;
    }

}
