/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zhangjianwei
 */
public class addOrDelete extends HttpServlet {

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
//        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        List<String> myCart;
        if(session.getAttribute("Cart") != null){
            myCart = (ArrayList<String>)session.getAttribute("Cart");           
        }
        else{
            myCart = new ArrayList<String>();
        }
        
        String b1 = "Java Servlet Programming  [$1.00]"; 
        String b2 = "Oracle Database Programming  [$2.00]";
        String b3 = "System Analysis and Design with UML  [$3.00]"; 
        String b4 = "Object Oriented Software Engineering  [$4.00]"; 
        String b5 = "Java Web Services  [$5.00]"; 

        String m1 = "I am going to tell you a secret by Madonna  [$1.00]";
        String m2 = "Baby One More Time by Britney Spears  [$2.00]";
        String m3 = "Justified by Justin  [$3.00]";
        String m4 = "Loose by Nelly  [$4.00]"; 
        String m5 = "Gold Digger by Kaney West  [$5.00]";

        String c1 = "Apple MacBook Pro with 13.3 Display  [$1.00]"; 
        String c2 = "Asus Laptop  [$2.00]"; 
        String c3 = "HP Laptop  [$3.00]";
        String c4 = "Lenovo Laptop  [$4.00]"; 
        String c5 = "Sony VALO Laptop  [$5.00]"; 
        
        //add myCart to cart
    try {
        if(action.equals("add")){
            String[] products = request.getParameterValues("product");
            for(String item : products){
                if(item.equals("b1")){
                    myCart.add(b1);
                }
                if(item.equals("b2")){
                    myCart.add(b2);
                }
                if(item.equals("b3")){
                    myCart.add(b3);
                }
                if(item.equals("b4")){
                    myCart.add(b4);
                }
                if(item.equals("b5")){
                    myCart.add(b5);
                }

                if(item.equals("m1")){
                    myCart.add(m1);
                }
                if(item.equals("m2")){
                    myCart.add(m2);
                }
                if(item.equals("m3")){
                    myCart.add(m3);
                }
                if(item.equals("m4")){
                    myCart.add(m4);
                }
                if(item.equals("m5")){
                    myCart.add(m5);
                }
                
                if(item.equals("c1")){
                    myCart.add(c1);
                }
                if(item.equals("c2")){
                    myCart.add(c2);
                }
                if(item.equals("c3")){
                    myCart.add(c3);
                }
                if(item.equals("c4")){
                    myCart.add(c4);
                }
                if(item.equals("c5")){
                    myCart.add(c5);
                }
            }
        }else if(action.equals("delete")){
            String[] products = request.getParameterValues("selectedProduct");
                for(String str : products){
                    if(myCart.contains(str))
                        myCart.remove(str);
                }           
        }
    } catch (Exception e) {
        //TODO: handle exception
        e.printStackTrace();
    }
        session.setAttribute("Cart", myCart);
        cart(request,response);
    }
    
    protected void cart(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
        out.println(docType + 
                "<head>"+
                "   <title>Shopping Cart</title>"+
                "</head>"+
                "<body>"+
                "   <div>"+
                "       <a href=\"book.html\">Book</a>"+
                "       <a href=\"music.html\">Music</a>"+
                "       <a href=\"computer.html\">Computer</a> "+
                "   </div>"+
                "   <h1>View Shopping Cart</h1><br/><br/>"+
                "<form action='addOrDelete' method='post'>");
        List<String> cart = (ArrayList<String>)session.getAttribute("Cart");
        for (int i=0;i<cart.size();i++){  
            	String str = cart.get(i);
            	out.println("<label><input type='checkbox' name='selectedProduct' value = '"+str+"' />");                              
                out.println(str + " </label><br/><br/>" );                              
            }
        out.println("<input type='submit' name='action' value = 'delete' /><br/></form>");
        
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
