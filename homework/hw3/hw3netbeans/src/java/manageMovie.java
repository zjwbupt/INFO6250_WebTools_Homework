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
import entity.Movie;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.relique.jdbc.csv.CsvDriver;
import org.apache.poi.hssf.usermodel.*;

public class manageMovie extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       MovieDao search = new MovieDao();
       String kind = request.getParameter("kind");
       String keywords = request.getParameter("keywords");
       List<Movie> result = search.getMovies(kind,keywords);
       request.setAttribute("keywords",keywords);
       request.setAttribute("result",result);
//       response.sendRedirect("browseOutput.jsp");
       request.getRequestDispatcher("browseOutput.jsp").forward(request,response);
    }
}
