<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<script>
		var jsvarlist =
	<%= request.getSession().getAttribute("name") %>
		;
		document.write(JSON.stringify(jsvarlist));

		//document.getElementById("insert").innerHTML = jsvarlist;
	</script>
	<p id="insert"></p>
	<h1>Details</h1>
	<h1>
		"the value for number is: " <span id="myText"></span>
	</h1>
	"the value for number is: "
	<%= request.getSession().getAttribute("name")%></span>

</body>
</html>