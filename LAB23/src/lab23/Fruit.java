/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab23;

/**
 *
 * @author Luu Bach
 */
class Fruit {

    String fruitID;
    String fruitName;
    int price;
    int quantity;
    String origin;
    int amount;

    public Fruit(String fruitID, String fruitName, int price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit(String fruitName, int quantity, int price) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
        this.amount = price * quantity;
    }

    public Fruit() {
    }

    public String getFruitID() {
        return fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
