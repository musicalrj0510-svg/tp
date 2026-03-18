import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;          // Fix 1: Missing import for HttpSession

/**
 * @author Vishal bhandari
 */
@WebServlet("/displaysession")
public class DisplaySession extends HttpServlet {  // Fix 2: Class name capitalized (convention)

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession mySession = request.getSession(true);  // Fix 3: HttpSession not Httpsession
        String heading;
        Integer counter = new Integer(0);                  // Fix 4: Integer not integer

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            if (mySession.isNew()) {
                heading = "This is the first time you are visiting this page";
            } else {
                heading = "Welcome back to this page";              // Fix 5: headibg → heading (typo)
                Integer oldCounter = (Integer) mySession.getAttribute("counter");  // Fix 6: Integer not integer
                if (oldCounter != null) {
                    counter = new Integer(oldCounter.intValue() + 1);  // Fix 7: intValue() not int value() (space removed), added missing semicolon
                }
            }

            mySession.setAttribute("counter", counter);   // Fix 8: setAttribute() not setattribute()

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Displaying Session Detail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>" + heading + "</h2>");                // Fix 9: added heading to output
            out.println("<p>You have visited this page <b>" + counter + "</b> time(s).</p>"); // Fix 10: added counter to output
            out.println("<p><b>Session ID:</b> " + mySession.getId() + "</p>");               // Fix 11: added session info
            out.println("<p><b>Session Created:</b> " + new java.util.Date(mySession.getCreationTime()) + "</p>");
            out.println("<p><b>Last Accessed:</b> " + new java.util.Date(mySession.getLastAccessedTime()) + "</p>");
            out.println("<h1>Servlet DisplaySession at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }
}