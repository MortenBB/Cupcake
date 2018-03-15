package logic;

import datamapper.DataMapper;
import datasource.DataSource1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Morten
 */
public class PriceCalculator {

    DataMapper hit = new DataMapper(new DataSource1().getDataSource());
/**
 * Calculates and returns the price of the cupcake
 * @param bottom
 * @param top
 * @param amount
 * @return 
 */
    public int calculator(String bottom, String top, int amount) {
        int topPrice = hit.priceTop(top);
        int bottomPrice = hit.priceBottom(bottom);
        return (topPrice + bottomPrice) * amount;
    }

}
