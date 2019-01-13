
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
    public static int user=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {       
//        HttpRequest
//        String user = (String)req.getAttribute("user");
//        PrintWriter out = resp.getWriter();
//        out.println("Welcome : " + user);

//        HttpSession
//        HttpSession s = req.getSession();
//        String user = (String)s.getAttribute("user");
//        PrintWriter out = resp.getWriter();
//        out.println("Welcome: " + user);
        
//        Cookies
       
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie[] ck = req.getCookies();
        user+=1;
//        for(Cookie cook:ck){
//            out.println("Cookie\nName : " + cook.getName() + "\nValue : " + cook.getValue());
//        }
        out.println("Hello!");
        out.println("User "+user);
        out.println("<br><a href = '/SessionApp/LogoutCookie'>LOGOUT</a>");
   
//        URL Rewriting
//        resp.getWriter().println("Welcome : " + req.getParameter("user"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
//        Hidden Form Fields
//        resp.getWriter().println("Welcome : " + req.getParameter("user"));
    
    }  
}
