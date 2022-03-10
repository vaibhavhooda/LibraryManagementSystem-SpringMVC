<%@ page language="java" import="java.util.*, java.lang.*,model.PublisherModel" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Publisher</title>
</head>
<body>
	<h1> Publisher Page </h1>
	<form action="pubsubmit" method="post">
	   <table style="with: 80%">
	   <tr>
		     <td>Publisher Id</td>
		     <td><input type="text" name="pubId" /></td>
	    </tr>
	    <tr>
		     <td>Publisher Name</td>
		     <td><input type="text" name="pubName" /></td>
	    </tr>
	    
	    <tr>
		     <td>Publisher Address</td>
		     <td><input type="text" name="pubAddress" /></td>
	    </tr>
	    </table>
	    <input type="submit" name="register" value="Register Publisher">
	    <input type="submit" name="update" value="Update Publisher">
  </form>
  <br>
  <br>
   <table border="1" cellpadding="2" cellspacing="2">
	   <tr>
		     <th>Publisher Id</th>
		     <th>Publisher Name</th>
		     <th>Publisher Address</th>
	    </tr>
	    <%
	    ArrayList<PublisherModel> list = (ArrayList<PublisherModel>) request.getAttribute("publisher"); 
	    	    	PublisherModel pub = new PublisherModel();
	    	     	for (int i=0; i < list.size(); i++) {
	               		pub = list.get(i);
	    %>

            <tr>
                <td><%=pub.getPub_id()%></td>
                <td><%=pub.getPub_name()%></td>
                <td><%=pub.getPub_address()%></td>
            </tr>
            <%
            };
            %>
	</table>
  
</body>
</html>