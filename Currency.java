<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="CCServlet" method="post">

Enter the Amount <input type="text" name="amt" ><br>
Select Conversion Type <input type="radio" name="type" value="r2d" checked>Rupees to Dollar
<input type="radio" name="type" value="d2r">Dollar to Rupees <br>
<br>
<input type="submit" value="Convert" >
</form>
    </body>
</html>





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCServlet;

import CCBean.CCBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CCServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB CCBean obj;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double amt = Double.parseDouble(request.getParameter("amt"));
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("type").equals("r2d")){
            out.println("<h1>"+amt+ " Rupees = "+obj.r2Dollar(amt)+" Dollars</h1>");
            }
            if(request.getParameter("type").equals("d2r"))
            {
            out.println("<h1>"+amt+ " Dollars = "+obj.d2Rupees(amt)+" Rupees</h1>");
            }
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CCServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CCServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCBean;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class CCBean {
    public CCBean(){}
    public double r2Dollar(double r){
    return r/92;
    }
    public double d2Rupees(double d){
    return d*92;
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}