<html>


<body>
<h3>Training Portal</h3>
<!-- read the fav program lang -->


	<%
		//the default...if there are no cookies
		String favLang="java";
	    //get the cookies from browser request
	    
	    Cookie[] theCookies=request.getCookies();
	    
	    //find our favorite language cookie
	    if(theCookies!=null)
	    {
	    	for(Cookie tempCookie :theCookies)
	    	{
	    		if("myApp.favoriteLanguage".equals(tempCookie.getName()))
	    		{
	    			favLang=tempCookie.getValue();
	    			break;
	    		}
	    	}
	    }
	    
	%>
	
	<!-- now show personalized page... use favLang -->
	
	<!-- show new books for this lang -->
	<h4>New books for<%=favLang %></h4>
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>	
	
	<h4>Latest news reports<%=favLang %></h4>
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>	
	
	<h4>Hot Jobs For<%=favLang %></h4>
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>
	
	<hr>
	<a href="cookies-personalize-form.html">Personalize this page</a>	
 
	
</body>

</html>