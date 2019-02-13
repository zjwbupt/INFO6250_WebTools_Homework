import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HW1_Part3 extends HttpServlet{
            
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String passwordConfirmed = request.getParameter("PasswordConfirmed");
        String fileToUpload = request.getParameter("FileToUpload");
        String gender = request.getParameter("Gender");
        String country = request.getParameter("Country");
        String hobby = request.getParameter("Hobby");
        String address = request.getParameter("Address");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Quiz</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p> Email is : " + email +"</p>");
        out.println("<p> Password is : " + password +"</p>");
        out.println("<p> Confirmed Password is : " + passwordConfirmed +"</p>");
        out.println("<p> Gender is : " + gender +"</p>");
        out.println("<p> Picture is : " + fileToUpload +"</p>");
        out.println("<p> Country is : " + country +"</p>");

        out.println("<p> Hobby is : " + hobby +"</p>");
        out.println("<p> Address is : " + address +"</p>");

       
        out.println("</body>");
        out.println("</html>");
    }

}