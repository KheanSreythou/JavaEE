
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse res) 
            throws ServletException, IOException{
        PrintWriter out = res.getWriter();
        out.println("Successful");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse res) 
            throws ServletException, IOException{
        PrintWriter out = res.getWriter();
        String userName = (String) request.getAttribute("userN");
        res.setContentType("text/html");
        out.println("You are : " + userName);
        out.println("<br><a href='LogoutServ'>Logout</a>");
    }
}
