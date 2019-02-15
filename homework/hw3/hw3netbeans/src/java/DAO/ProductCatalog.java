/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Product;
import java.util.ArrayList;

/**
 *
 * @author lx
 */
public class ProductCatalog {
    
    private ArrayList<Product> productList;
    public ProductCatalog() {
        productList = new ArrayList<>();
        String[] b = new String[5];
        b[0] = "Java Servlet Programming  "; 
        b[1] = "Oracle Database Programming  ";
        b[2] = "System Analysis and Design with UML  "; 
        b[3] = "Object Oriented Software Engineering  "; 
        b[4] = "Java Web Services  "; 
        
        for(int i=1;i<=5;i++){
            Product book = new Product();
            book.setName(b[i-1]);
            book.setPrice(i);
            book.setType("book");
            productList.add(book);
        }
        
        String[] m = new String[5];
        m[0] = "I am going to tell you a secret by Madonna  ";
        m[1] = "Baby One More Time by Britney Spears  ";
        m[2] = "Justified by Justin  ";
        m[3] = "Loose by Nelly  "; 
        m[4] = "Gold Digger by Kaney West  ";

        for(int i=1;i<=5;i++){
            Product music = new Product();
            music.setName(m[i-1]);
            music.setPrice(i);
            music.setType("music");
            productList.add(music);
        }
        
        String[] c = new String[5];
        c[0] = "Apple MacBook Pro with 13.3 Display  "; 
        c[1] = "Asus Laptop  "; 
        c[2] = "HP Laptop  ";
        c[3] = "Lenovo Laptop  "; 
        c[4] = "Sony VALO Laptop  "; 
        
        for(int i=1;i<=5;i++){
            Product computer = new Product();
            computer.setName(c[i-1]);
            computer.setPrice(i);
            computer.setType("computer");
            productList.add(computer);
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
      
}
