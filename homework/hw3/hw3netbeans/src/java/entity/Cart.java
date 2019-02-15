/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author lx
 */
public class Cart extends Product{
    private ArrayList<Product> cart = null;
    
    public Cart() {
        cart = new ArrayList<Product>();
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

}
