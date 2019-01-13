import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class NewFilter implements Filter{

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init() invoked.");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        out.println("Before Filter...");
//        BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
        String remoteAddr = req.getRemoteAddr();
        String requestURI = ((HttpServletRequest)req).getRequestURI();
        String protocol = req.getProtocol();
        System.out.println(remoteAddr + " has sent a " + protocol 
                + " request to " + requestURI +"\n");
//        bw.write(remoteAddr + " has sent a " + protocol + " request to " 
//                + requestURI + "\n");
//        bw.close();
        chain.doFilter(req, res);
        out.println("After Filter...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() invoked.");
    }  
}
