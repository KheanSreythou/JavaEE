
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NewFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException{
        System.out.println("doFilter: Hello World!");
        String user = req.getParameter("user").trim();
        String email=req.getParameter("email").trim();
        if(user==null||user.equals("")){
            if(email==null||email.equals("")){
                req.getRequestDispatcher("index.html").forward(req, res);
            }
            else{
                chain.doFilter(req, res);
            }
        }
        else{   
            chain.doFilter(req, res);
        }  
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init(): Hello World!");
    }
    
    
    
    public void destroy(){;
        System.out.println("destroy(): Hello World!");
    }
}
