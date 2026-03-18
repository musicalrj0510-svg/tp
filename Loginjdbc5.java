<h1>Welcome to Registration Page!!!</h1>
        <form action="Login" method="post">
            Enter the Username:<input type="text" name="user">
            <br>
            Enter the Password:<input type="text" name="pass">
            <br>
            Enter the Email:<input type="text" name="email">
            <br>
            Enter the Country:<input type="text" name="country">
            <br>
            <input type="submit" value="Register">
        </form>





import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String us=request.getParameter("user");
        String pass=request.getParameter("pass");
        String em=request.getParameter("email");
        String coun=request.getParameter("country");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","root123");
            PreparedStatement pst=con.prepareStatement("insert into users value(?,?,?,?)");
            pst.setString(1,us);
            pst.setString(2,pass);
            pst.setString(3,em);
            pst.setString(4,coun);
            int row=pst.executeUpdate();
            out.println("<h1>"+row+" Inserted Successfully!!!");
            } catch (Exception e) {
            out.println(e);
        } 
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
    }
}