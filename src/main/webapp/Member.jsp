<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.MemberModel"%>
<!DOCTYPE html>
<html>
<head>
<style>
table th,td,tr {
  border:1px solid black;
  border-spacing: 30px;
}

</style>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h1> Member Page </h1>
<!--call the ServletClassname as StudentServlet.java --> 

 <form action="membersubmit" method="post">
   <table style="with: 80%">
    <tr>
     <td>Member Name</td>
     <td><input type="text" name="memName" /></td>
    </tr>
    <tr>
     <td>Member Id</td>
     <td><input type="text" name="memId" /></td>
    </tr>
    <tr>
     <td>Member Address</td>
     <td><input type="text" name="memAddress" /></td>
    </tr>
    <tr>
     <td>Member Type</td>
     <td><input type="text" name="memType" /></td>
    </tr>
    <tr>
     <td>Membership Start date</td>
     <td><input type="date" name="memStartdate" min="2022-03-01" max="2022-12-31" /></td>
    </tr>
    <tr>
     <td>Membership Expiry date</td>
     <td><input type="date" name="memExpirydate" min="2022-03-01" max="2022-12-31" /></td>
    </tr>
    </table>
    <input type="submit" name="register" value="Register Member">
    <input type="submit" name="update" value="Update Member">
  </form><br><br>
    
  
    <table style="with: 80%; ">
	    <tr>
	     <th>Member Id</th>
	     <th>Member Name</th>
	     <th>Member Address</th>
	     <th>Member Type</th>
	     <th>Membership Start date</th>
	     <th>Membership Expiry date</th>
	    </tr>
	    
	    <% 
		    ArrayList<MemberModel> list = (ArrayList<MemberModel>) request.getAttribute("memberList"); 
	    	MemberModel mmbr = new MemberModel();
	    	if(list != null){
	     	for (int i=0; i < list.size(); i++) {
	     		mmbr = list.get(i);
	     	
	    %>
	    <tr>
	    	<td><%= mmbr.getMem_id() %></td>
	    	<td><%= mmbr.getMem_name() %></td>
	    	<td><%= mmbr.getMem_address() %></td>
	    	<td><%= mmbr.getMem_type() %></td>
	    	<td><%= mmbr.getMem_date() %></td>
	    	<td><%= mmbr.getExpiry_date() %></td>
        </tr>
        
        <%
	     	}};
            %>
    </table>
   
   
  
</body>
</html>