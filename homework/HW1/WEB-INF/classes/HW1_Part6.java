
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class HW1_Part6 extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        out.println("<html>");  
        out.println("<head>");  
        out.println("<title>HW1_Part6</title>");  
        out.println("</head>");  
        out.println("<body>");  
        out.println("<form action = 'part6_2' method = 'get'>");
        out.println("How Many Children do you have</label>");  
        out.println("<input type='text' name='Number'><br/><br/>");
        out.println("<input type='submit' value='next' name='button'>");
        out.println("</form>");
        out.println("</body>");  
        out.println("</html>");  
    }  
}  


