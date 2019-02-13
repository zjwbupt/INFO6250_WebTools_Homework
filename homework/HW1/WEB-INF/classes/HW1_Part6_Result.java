import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


public class HW1_Part6_Result extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Enumeration paramNames = request.getParameterNames();

        while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            out.print("<tr><td> Your Children`s name are : </td>\n");
            String[] paramValues = request.getParameterValues(paramName);

            // 读取单个值的数据
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.println("<td><i> You didn`t type your children`s name </i></td><br/>");
                else
                    out.println("<td>" + paramValue + " </td><br/>");
            } else {

                // 读取多个值的数据
                out.println("<td><ul>");
                for(int i=0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i]+"<br/>");
                }
                out.println("</ul></td>");
            }
            out.print("</tr>");
        }
        out.println("\n</table>\n</body></html>");

    }

}