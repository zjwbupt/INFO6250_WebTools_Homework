import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


public class HW1_Part2 extends HttpServlet{


    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // out.println("HTTP headers sent by your client:<br>");

        Enumeration enums = request.getHeaderNames();
        while (enums.hasMoreElements()) {
            String headerName = (String) enums.nextElement();
            String headerValue = request.getHeader(headerName);
            out.print("<b>" + headerName + "</b>: ");
            out.println(headerValue + "<br/>");
        }
    }

}