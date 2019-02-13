import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 把数据存到sesssion
 *
 * @version 1.0
 * @since JDK1.7
 * @date 2016年3月1日 上午10:24:40
 */
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //或取所有的值
        String [] book=request.getParameterValues("book");
        //把图书信息放到HttpSession中
        request.getSession().setAttribute("book", book);

        //重定向(绝对路径)
        response.sendRedirect(request.getContextPath()+"/sessionByShoppingCart/userinfo.jsp");
    }

}
