/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

/**
 *
 * @author Morten
 */
public class Order {

    private String top;
    private String bottom;
    private int price;

    public void setTop(String top) {
        this.top = top;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTop() {
        return top;
    }

    @Override
    public String toString() {
        return "Order:" + "top= " + top + ", bottom= " + bottom + ", price= " + price + "kr.";
    }

    public String getBottom() {
        return bottom;
    }

    public int getPrice() {
        return price;
    }

    public Order(String top, String bottom, int price) {
        this.top = top;
        this.bottom = bottom;
        this.price = price;
    }
}
