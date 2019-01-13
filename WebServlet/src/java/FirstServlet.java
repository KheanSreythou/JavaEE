import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		String userName = request.getParameter("user");
		PrintWriter out = res.getWriter();
		if(userName.equalsIgnoreCase("Sreythou")) {
                    out.println("hello");
                    RequestDispatcher rd = request.getRequestDispatcher("/SuccessServlet");
                    rd.forward(request, res);
		}
		else if(userName.toLowerCase()=="s") {
			out.println("Welcome " + userName);
		}
		else if(userName.contains("s")) {
			out.println("Welcome " + userName);
		}
		else {
			out.println("Please register ...");
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
                String userName = request.getParameter("user");
		PrintWriter out = res.getWriter();
		if(userName.equalsIgnoreCase("Sreythou")) {
                    RequestDispatcher rd = request.getRequestDispatcher("/SuccessServlet");
                    request.setAttribute("userN", userName);
                    rd.forward(request, res);
		}
	}
}