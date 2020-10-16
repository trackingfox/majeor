<%@ page import="java.util.*"%>

<html>

<body>

	<!-- step1: Create HTML form -->
	<form action="todo-demo.jsp">
		Add new item:<input type="text" name="theItem" /> <input
			type="submit" value="Submit" />

	</form>
	
	<!-- Add new item to to-do List -->
	<%
		//get the to do items from the session
	List<String> items = (List<String>) session.getAttribute("myToDoList");

	//if the to do items doesn't exist then create a  new one

	if (items == null) {
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}

	//see if there is form data to add
	String theItem = request.getParameter("theItem");
	if (theItem != null) {
		items.add(theItem);
	}
	%>

	<!-- Step 3: display all to do items from session -->

	<hr>
	<b>To List Items</b>
	<br />

	<ol>

		<%
			for (String temp : items) {
			out.println("<li>" + temp + "</li>");
		}
		%>

	</ol>



</body>
</html>