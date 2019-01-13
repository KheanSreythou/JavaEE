
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {  
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {   
        Cookie cookies[] = request.getCookies();
        Cookie cookie;
        for(int i=0;i<cookies.length;i++) {
            cookie= new Cookie(cookies[i].getName(),"");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        request.getRequestDispatcher("index.html").forward(request,response);
    }
    
    
}
