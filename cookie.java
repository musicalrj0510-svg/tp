 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="DisplaySessionDetailsServlet",
urlPatterns={"/DisplaySessionDetailsServlet"})
public class DisplaySessionDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession mySession = request.getSession(true);
        String heading;
        Integer counter = new Integer(0);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          if (mySession.isNew()) {
 heading = "This is the first time you are visiting this page.";
            }
  else {
    heading = "Welcome back to this page";
   Integer oldCounter = (Integer)mySession.getAttribute("counter");
    if (oldCounter != null) {
    counter = new Integer(oldCounter.intValue() + 1);
                }
            }
  mySession.setAttribute ("counter", counter);

  out.println("<html><head><title>Displaying Session Details</title></head><body>");

  out.println("<h3>" + heading + "</h3><br>");
 out.println("<b>SESSION ID: </b>" + mySession.getId() + "<br>");

 out.println("<b>Creation Time of the Session: </b>" 
+ new Date(mySession.getCreationTime()) + "<br>");

  out.println("<b>Time of Last Access: </b>" + 
new Date(mySession.getLastAccessedTime()) + "<br><br>");

  out.println("You have visited this page " + (++counter));
   out.println((counter == 1) ? " time " : " times ");
    out.println("</body></html>");  
          
out.println("<h1>Servlet DisplaySessionDetailsServlet at " + request.getContextPath() + "</h1>");        
}}}