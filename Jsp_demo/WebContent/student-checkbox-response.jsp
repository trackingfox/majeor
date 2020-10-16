<html>

<head>
<title>

 Student Confirmation Title

</title>
</head>


<body>
   The student is confirmed: ${param.firstName} ${param.lastName}
   
   <br/><br/>
   
   Favorite Programming languages: <br/>
  <!-- display list of favorite language -->
  <ul>
     <%
         String[] langs= request.getParameterValues("favouriteLanguage");
         
         for(String tempLang :langs)
         {
        	 out.println("<li>"+tempLang +"</li>");
         }
        
      %>
  
  
  
  </ul>
  
</body>
</html>