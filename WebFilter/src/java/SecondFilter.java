
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        String user = req.getParameter("user").trim();
        String email = req.getParameter("email").trim();
        String regex = "(.)*(\\d)(.)*";      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user);

        boolean isMatched = matcher.matches();
        
        if(isMatched){
           req.getRequestDispatcher("index.html").forward(req, res);
        }
        else{
            if(email.contains("@")&&email.contains(".")){
                chain.doFilter(req, res);
            }
            else{
               req.getRequestDispatcher("index.html").forward(req, res);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()");
    }
    
    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
    
}
