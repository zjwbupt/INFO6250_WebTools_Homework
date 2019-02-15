/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Product;
import DAO.ProductCatalog;
import entity.Cart;

/**
 *
 * @author lx
 */
public class ShoppingController extends HttpServlet {

    public ShoppingController() {
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ArrayList<Product> productList = new ProductCatalog().getProductList();
//        ArrayList<Product> myCart;
        Cart myCart;
        if(session.getAttribute("myCart")!=null){
            myCart = (Cart) session.getAttribute("myCart");
        }else{
            myCart = new Cart();
        }
        
        try{
            if(request.getParameter("action").equals("add")){
                String[] products = request.getParameterValues("product");
                for(String str : products){
                    for(Product prod : productList){
                        if(prod.getName().equals(str))
                            myCart.getCart().add(prod);
                    }
                }
            }
            else if(request.getParameter("action").equals("delete")){
                String[] products = request.getParameterValues("product");
                for(String str : products){
                    for(Product prod : myCart.getCart()){
                        if(prod.getName().equals(str))
                            myCart.getCart().remove(prod);
                    }                     
                }
            }
        }
        catch (Exception e) {
        //TODO: handle exception
        }
        session.setAttribute("myCart", myCart);
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
