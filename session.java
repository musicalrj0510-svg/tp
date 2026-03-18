import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/displaysession")
public class DisplaySession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession mySession = request.getSession(true);
        String heading;
        Integer counter = 0;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            if (mySession.isNew()) {
                heading = "This is the first time you are visiting this page";
            } else {
                heading = "Welcome back to this page";
                Integer oldCounter = (Integer) mySession.getAttribute("counter");
                if (oldCounter != null) {
                    counter = oldCounter + 1;
                }
            }

            mySession.setAttribute("counter", counter);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Displaying Session Detail</title></head>");
            out.println("<body>");
            out.println("<h2>" + heading + "</h2>");
            out.println("<p>You have visited this page <b>" + counter + "</b> time(s).</p>");
            out.println("<p><b>Session ID:</b> " + mySession.getId() + "</p>");
            out.println("<p><b>Session Created:</b> " + new Date(mySession.getCreationTime()) + "</p>");
            out.println("<p><b>Last Accessed:</b> " + new Date(mySession.getLastAccessedTime()) + "</p>");
            out.println("<h1>Servlet DisplaySession at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }
}