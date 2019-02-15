/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prospace
 */
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.relique.jdbc.csv.CsvDriver;


public class csvReader extends HttpServlet{

    private static final String CSV_JDBC_DRIVER = "org.relique.jdbc.csv.CsvDriver";
    private static final String CSV_JDBC_HEADER = "jdbc:relique:csv:";

       public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
            String FileName = request.getParameter("Name");
            String path = request.getRealPath("/file");

       String s = "";
       List<String> strs = new ArrayList<>();
       Map<Integer, List<String> > de_strs = new HashMap<>();
       try{
            
            Class.forName(CSV_JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(CSV_JDBC_HEADER + path);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from " + FileName);
            ResultSetMetaData data = results.getMetaData();
            
            
            int cnt = data.getColumnCount();
            for (int i = 1 ; i <=cnt ; i++)
                 strs.add((String)data.getColumnName(i));
            int ci = 0;
            while (results.next()){   
                List<String> tmps = new ArrayList<>();
                for (int i = 1; i<=cnt; i++)
                    tmps.add(results.getString(i));
                de_strs.put(ci, tmps);
                ci++;
            }
           
            request.getSession().setAttribute("title", strs);
            for (int i = 1 ; i <=cnt ; i++)
                request.getSession().setAttribute("content", de_strs);
       }catch(Exception e){
           
       }
       response.sendRedirect("showCsv.jsp");
    }
}
