
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class HW1_Part6_2 extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String numGet = request.getParameter("Number");
        int numOfChild = Integer.parseInt(numGet);

        out.println("<html>");  
        out.println("<head>");  
        out.println("<title>HW1_Part6</title>");  
        out.println("</head>");  
        out.println("<body>"); 
        out.println("<form action = 'part6_result' method = 'post'>");
 
        for(int i=0 ; i<numOfChild; i++){
            out.println("How Many Children do you have</label>");  
            out.println("<input type='text' name='Number'><br/><br/>");
        }
        
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body>");  
        out.println("</html>");  
    }  

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}  


