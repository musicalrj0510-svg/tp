index.html

<form action="Validate.jsp" method="post">             
Enter Your Name<input type="text" name="name" ><br>     
Enter Your Age<input type="text" name="age" ><br>  
Select Hobbies 
<input type="checkbox" name="hob" value="Singing">Singing 
<input type="checkbox" name="hob" value="Reading">Reading Books 
<input type="checkbox" name="hob" value="Football">Playing Football
<br>             
Enter E-mail<input type="text" name="email" ><br>             
Select Gender 
<input type="radio" name="gender" value="male">Male 
<input type="radio" name="gender" value="female">Female <br> 
<input type="hidden" name="error" value=""> 
<input type="submit" value="Submit Form"> 
</form>




Validate.jsp
<html>
<head>
<title>JSP Page</title></head> 

<body> <h1>Validation Page</h1> 
 
<jsp:useBean id="obj" scope="request" class="mypack.CheckerBean"> 
<jsp:setProperty name="obj" property="*"/> 
</jsp:useBean> 
 
<%
if (obj.validate()) 
{ 
%> 
<jsp:forward page="successful.jsp"/> 
<%   
} 
else  
{
%> 
<jsp:include page="index.html"/> 
<%
}
%> 
<%=obj.getError() %> 
</body>
</html> 




CheckerBean.java
package mypack; 
 
public class CheckerBean 
{ 
private String name, age, hob, email, gender, error; 
public CheckerBean()
{
error="";
} 
public void setName(String n){name=n;} 
public void setAge(String a){age=a;} 
public void setHob(String h){hob=h;} 
public void setEmail(String e){email=e;} 
public void setGender(String g){gender=g;} 
public void setError(String e){error=e;} 
public String getName(){return name;} 
public String getAge(){return age;} 
public String getHob(){return hob;} 
public String getEmail(){return email;} 
public String getGender(){return gender;} 
public String getError(){return error;} 
public boolean validate()
{ 
boolean res=true; 
if(name.trim().equals("")) 
{
error+="<br>Enter First Name";
res=false;
} 
if(age.length() > 2 ) 
{
error+="<br>Age Invalid";
res=false;
} 
return res; 
} 
}