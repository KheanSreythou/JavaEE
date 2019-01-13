import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {    
//        Parameter
//        ServletConfig con = getServletConfig();
//        String school = con.getInitParameter("school");
//        PrintWriter pw= resp.getWriter();
//        pw.println(school);
//        
//        HttpRequest
//        String user = req.getParameter("user");
//        req.setAttribute("user", user);
//        
//        RequestDispatcher rd = req.getRequestDispatcher("/SecondServlet");
//        rd.forward(req, resp);
        
//        HttpSession
//        String user = req.getParameter("user");
//        HttpSession s = req.getSession();
//        s.setAttribute("user", user);
//        RequestDispatcher rd = req.getRequestDispatcher("/SecondServlet");
//        rd.forward(req, resp);
        
//        Cookies
        resp.setContentType("text/html");
        String user = req.getParameter("user");
        Cookie ck = new Cookie("user", user);
        resp.addCookie(ck);
        PrintWriter out = resp.getWriter();
        out.println("<br><a href = '/SessionApp/SecondServlet'>Click me</a>");
        
//        URL Rewriting
//        resp.setContentType("text/html");
//        String name = req.getParameter("user");
//        PrintWriter out = resp.getWriter();
//        out.println("<a href='/SessionApp/SecondServlet?user=" + name + "'>Click here</a>");

//        Hidden Form Fields
//        resp.setContentType("text/html");
//        String name = req.getParameter("user");
//        PrintWriter out = resp.getWriter();
//        out.println("<form action='SecondServlet' method='post'>" //cannot use method='post', 
////                                  if the SecondServlet have the code only in doGet() method
//                + "<input type = 'hidden' name = 'user' value = '" + name + "'>"
//                + "<input type = 'submit' value = 'Second'>"
//                + "</form>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        doPost(req,resp);
    }
}
