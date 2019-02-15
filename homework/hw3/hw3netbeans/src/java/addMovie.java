/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prospace
 */
import DAO.MovieDao;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.relique.jdbc.csv.CsvDriver;
import org.apache.poi.hssf.usermodel.*;

public class addMovie extends HttpServlet{
//    private static final String jdbc_dir = "com.mysql.jdbc.Driver";
//    private static final String db_url = "jdbc:mysql://localhost:3306/moviedb";
//    private static final String user = "root";
//    private static final String passwords = "p@ssw0rd";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String mtitle = request.getParameter("title");
       String mactor = request.getParameter("actor");
       String mactress = request.getParameter("actress");
       String genre = request.getParameter("genre");
       String year = request.getParameter("year");

       MovieDao md = new MovieDao();
       md.addMovie(mtitle, mactor, mactress, genre, Integer.parseInt(year));
       response.sendRedirect("addOutput.jsp");
    }
}
