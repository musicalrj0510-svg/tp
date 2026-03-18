pract1

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action ="cal" method="post">
            Enter First num:<input type="text" name="n1" size="20">
            <br>
            Enter Second num:<input type="text" name="n2" size="20">
            <br>
            Select Operations:
            <input type="radio" name="opr" value="+">ADD
            <input type="radio" name="opr" value="-">SUB
            <input type="radio" name="opr" value="/">DIV
            <input type="radio" name="opr" value="*">MUL
            <br>
            <input type="submit" value="Calculate">
            
        </form>
    </body>
</html>
   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class cal extends HttpServlet {

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
        double val1=Double.parseDouble(request.getParameter("n1"));
        double val2=Double.parseDouble(request.getParameter("n2"));
        double result=0;
        String opr = request.getParameter("opr");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(opr.equals("+")){
                result = val1+val2;
            }
            if(opr.equals("-")){
                result = val1-val2;
            }
            if(opr.equals("/")){
                result = val1/val2;
            }
            if(opr.equals("*")){
                result = val1*val2;
            }
            out.println("the Calculation is:"+result);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

pract2

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>Even Or ODD number Checker</h2>
        <form action="evenodd" method="post">
        Enter  Number:
        <input type="text" name="num" ><br><br>
        <input type="Submit" value="check">
        </form>
    </body>
</html>


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class evenodd extends HttpServlet {

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
        int number=Integer.parseInt(request.getParameter("num"));
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (number % 2==0){
                out.println("<h3>Number is even</h3>");
            }
            else{
                out.println("<h3>Number is odd</h3>");
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet evenodd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet evenodd at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}


pract3

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="fact" method="post">
            Enter the Number <input type="text" size="20" name="text">
            <br>
            <input type="Submit" value="Submit">
            
            
        </form>
    </body>
</html>


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class fact extends HttpServlet {

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
        String s=request.getParameter("text");
        int number=Integer.parseInt(s);
        long factorial = 1;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(number<0){
                out.println("fctoriaol is not defined for negative number");
                
            }
            else{
                for(int i=1; i <= number ;i++){
                    factorial=factorial *i;
                }
            }
            out.println(factorial);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet fact</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fact at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}


PRACT 4
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>User Login Info</h1>
        <form action="login" method="post">
            Enter User name: <input type="text" name="utxt"><br>
            Enter User Password : <input type="password" name="ptxt"><br>
            <input type="submit" name="Click to login">
        </form>
    </body>
</html>


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class login extends HttpServlet {

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
        String uname=request.getParameter("utxt");
        String upass=request.getParameter("ptxt");
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            if (uname.equals("admin") && upass.equals("1234")){
                out.println("<h1>Welcome!!"+uname+"</h1>");
            }
            else{
                out.println("<bodu bgcolor=red>");
                out.println("<h1>Login Failed!!!!</h1>");
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 
}


pract 6
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="dispatcher" method="post">
            Enter your name :<input type="text" name="txtid" size="20"><br>
            Enter your password :<input type="text" name="txtpass" size="20"><br>
            <input type="submit" name="Submit">
        </form>
    </body>
</html>


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class dispatcher extends HttpServlet {

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
        String uid= request.getParameter("txtid");
        String pass=request.getParameter("txtpass");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(uid.equals("admin")&&pass.equals("123456")){
                Requestdispatcher rd1=Request.getRequestDispatcher("welcome");
                rd1.forward(request,response);
            }else{
                out.println("Login Failed!!!");
                RequestDispatcher rd2=request.getRequestDispatecher("index.html");
                rd2.forward(request,response);
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dispatcher</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dispatcher at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}


pract 9

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TO DO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="quiz" method="post">
            Q1)What is 2 + 2?<br/>
            <input type="radio" name="q1" value="2">2<br/>
            <input type="radio" name="q1" value="3">3<br/>
            <input type="radio" name="q1" value="4">4<br/>
            Q2)What is 2 + 3?<br/>
            <input type="radio" name="q2" value="2">2<br/>
            <input type="radio" name="q2" value="3">5<br/>
            <input type="radio" name="q2" value="4">4<br/>
            Q3)What is 2 + 7?<br/>
            <input type="radio" name="q3" value="2">1<br/>
            <input type="radio" name="q3" value="3">3<br/>
            <input type="radio" name="q3" value="9">9<br/>
            <input type="submit" value="check"/>
            
        </form>
    </body>
</html>


 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class quiz extends HttpServlet {

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
        int correct =0, incorrect= 0;
        String a1=request.getParameter("q1");
        String a2=request.getParameter("q3");
        String a3=request.getParameter("q4");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(a1.equals("4")){
                correct++;
            }else{
                incorrect++;
            }
            if(a2.equals("5")){
                correct++;
            }else{
                incorrect++;
            }
            if(a3.equals("9")){
                correct++;
            }else{
                incorrect++;
            }
            out.println("the Number of Coorect Answer si:"+correct+"in the number inccorect is:"+incorrect);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet quiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet quiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
}

