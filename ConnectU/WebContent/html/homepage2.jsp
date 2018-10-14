<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<meta name="description"
	content="Quick & intuitive progression checks for university online courses">
<meta name="keywords"
	content="university, progress check, degree check, online tool">
<meta name="author" content="Group 12 Shawn">
<style>
.buttons {
	background-color: white;
	color: black;
	border: 2px solid #008CBA;
	padding: 8px
}
</style>
<title>ConnectYou | Dashboard</title>
<link rel="stylesheet" href="CSS/homepageStyle.css">
<script type="text/javascript" src="JS/go.js"></script>
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700"
	rel='stylesheet' type='text/css'>
<script id="code">
	function init() {
		var $ = go.GraphObject.make; // for conciseness in defining templates

		myDiagram = $(go.Diagram, "myDiagramDiv", // must be the ID or reference to div
		{
			"toolManager.hoverDelay" : 100, // 100 milliseconds instead of the default 850
			allowCopy : false,
			layout : // create a TreeLayout for the family tree
			$(go.TreeLayout, {
				angle : 90,
				nodeSpacing : 10,
				layerSpacing : 40,
				layerStyle : go.TreeLayout.LayerUniform
			})
		});

		var greygrad = '#73C2FB';
		var bluegrad = '#C0C0C0';
		var whitegrad = '#FFFFFF';
		var sem1grad = '#BB0A21';
		var sem2grad = '#BB0A21';
		var sem3grad = '#BB0A21';
		var semSumgrad = '#FF540C';

		//  get tooltip text from the object's data
		function tooltipTextConverter(subject) {
			var str = "";
			str += "Name: " + subject.courseName;
			return str;
		}

		//  define tooltips for nodes
		var tooltiptemplate = $(go.Adornment, "Auto", $(go.Shape, "Rectangle",
				{
					fill : "whitesmoke",
					stroke : "black"
				}), $(go.TextBlock, {
			font : "bold 8pt Helvetica, bold Arial, sans-serif",
			wrap : go.TextBlock.WrapFit,
			margin : 5
		}, new go.Binding("text", "", tooltipTextConverter)));

		// define Converters to be used for Bindings
		function BrushConverter(completed) {
			if (completed)
				return bluegrad;
			else
				return greygrad;
		}
		function strokeSem(semester) {
			return "transparent";
		}

		function strokeSem1(semester) {
			if (semester[0]) {
				return sem1grad;
			}
			return "transparent"
		}

		function strokeSem2(semester) {
			if (semester[1]) {
				return sem2grad;
			}
			return "transparent"
		}

		function strokeSem3(semester) {
			if (semester[2]) {
				return sem3grad;
			}
			return "transparent"
		}

		// replace the default Node template in the nodeTemplateMap
		myDiagram.nodeTemplate = $(go.Node, "Auto", {
			deletable : false,
			toolTip : tooltiptemplate
		}, new go.Binding("text", "key"), $(go.Shape, "Rectangle", {
			fill : "lightgray",
			stroke : null,
			strokeWidth : 0,
			stretch : go.GraphObject.Fill,
			alignment : go.Spot.Center
		}, new go.Binding("fill", "completed", BrushConverter), new go.Binding(
				"stroke", "semester", strokeSem)), $(go.TextBlock, {
			font : "700 12px Droid Serif, sans-serif",
			textAlign : "center",
			margin : 10,
			maxSize : new go.Size(80, NaN)
		}, new go.Binding("text", "key")));

		// define the Link template
		myDiagram.linkTemplate = $(go.Link, // the whole link panel
		{
			routing : go.Link.Orthogonal,
			corner : 5,
			selectable : false
		}, $(go.Shape, {
			strokeWidth : 3,
			stroke : '#424242'
		})); // the gray link shape

		// here's the family data
		var nodeDataArray =
<%=request.getSession().getAttribute("flowchartObject")%>
	;

		// create the model for the family tree
		myDiagram.model = new go.TreeModel(nodeDataArray);
		document.getElementById('zoomToFit').addEventListener('click',
				function() {
					myDiagram.zoomToFit();
				});

		document
				.getElementById('centerRoot')
				.addEventListener(
						'click',
						function() {
							myDiagram.scale = 1;
							myDiagram
									.scrollToRect(myDiagram.findNodeForKey(0).actualBounds);
						});

		document.getElementById('sem1').addEventListener(
				'click',
				function() {
					myDiagram.nodeTemplate = $(go.Node, "Auto", {
						deletable : false,
						toolTip : tooltiptemplate
					}, new go.Binding("text", "key"), $(go.Shape, "Rectangle",
							{
								fill : "lightgray",
								stroke : null,
								strokeWidth : 3.5,
								stretch : go.GraphObject.Fill,
								alignment : go.Spot.Center
							}, new go.Binding("fill", "completed",
									BrushConverter), new go.Binding("stroke",
									"semester", strokeSem1)), $(go.TextBlock, {
						font : "700 12px Droid Serif, sans-serif",
						textAlign : "center",
						margin : 10,
						maxSize : new go.Size(80, NaN)
					}, new go.Binding("text", "key")));
				});

		document.getElementById('sem2').addEventListener(
				'click',
				function() {
					myDiagram.nodeTemplate = $(go.Node, "Auto", {
						deletable : false,
						toolTip : tooltiptemplate
					}, new go.Binding("text", "key"), $(go.Shape, "Rectangle",
							{
								fill : "lightgray",
								stroke : null,
								strokeWidth : 3.5,
								stretch : go.GraphObject.Fill,
								alignment : go.Spot.Center
							}, new go.Binding("fill", "completed",
									BrushConverter), new go.Binding("stroke",
									"semester", strokeSem2)), $(go.TextBlock, {
						font : "700 12px Droid Serif, sans-serif",
						textAlign : "center",
						margin : 10,
						maxSize : new go.Size(80, NaN)
					}, new go.Binding("text", "key")));
				});

		document.getElementById('sem3').addEventListener(
				'click',
				function() {
					myDiagram.nodeTemplate = $(go.Node, "Auto", {
						deletable : false,
						toolTip : tooltiptemplate
					}, new go.Binding("text", "key"), $(go.Shape, "Rectangle",
							{
								fill : "lightgray",
								stroke : null,
								strokeWidth : 3.5,
								stretch : go.GraphObject.Fill,
								alignment : go.Spot.Center
							}, new go.Binding("fill", "completed",
									BrushConverter), new go.Binding("stroke",
									"semester", strokeSem3)), $(go.TextBlock, {
						font : "700 12px Droid Serif, sans-serif",
						textAlign : "center",
						margin : 10,
						maxSize : new go.Size(80, NaN)
					}, new go.Binding("text", "key")));
				});

		document.getElementById('reset').addEventListener(
				'click',
				function() {
					myDiagram.nodeTemplate = $(go.Node, "Auto", {
						deletable : false,
						toolTip : tooltiptemplate
					}, new go.Binding("text", "key"), $(go.Shape, "Rectangle",
							{
								fill : "lightgray",
								stroke : null,
								strokeWidth : 0,
								stretch : go.GraphObject.Fill,
								alignment : go.Spot.Center
							}, new go.Binding("fill", "completed",
									BrushConverter), new go.Binding("stroke",
									"semester", strokeSem)), $(go.TextBlock, {
						font : "700 12px Droid Serif, sans-serif",
						textAlign : "center",
						margin : 10,
						maxSize : new go.Size(80, NaN)
					}, new go.Binding("text", "key")));
				});

	}
</script>
<link rel="stylesheet" href="CSS/ChatBotCSS.css">
<link rel="stylesheet" href="CSS/ProgressBarCSS.css">
</head>

<body>
	<header>
		<div class="container">
			<div id="branding">
				<img src="img/cylogo2.png" class="cylogo">
			</div>
			<nav>
				<ul>
					<!--  <li class="current"><a href="../index.html">Home</a></li>-->
					<li><a style="margin-right: 30px" href="homepage2.jsp">Dashboard</a></li>
					<!--these links aren't correct?-->
					<li><a style="margin-right: 50px" href="../index.html"
						onclick="return confirm('Are you sure to log out?');">Log Out</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- END OF FIRST SECTION (the nav bar)-->

	<!-- Next section - CHOOSE MAJOR BUTTON-->
	<section id="newsletter"></section>
	<!--choose major BUTTON-->

	<style>
.dropbtn {
	display: inline-block;
	padding: 10px 45px;
	font-size: 14px;
	cursor: pointer;
	text-align: left;
	text-decoration: none;
	outline: none;
	color: #224268;
	background-color: white;
	border: 2px solid #ffd972;
	border-radius: 2px -webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19)
}

.dropbtn:hover {
	background-color: #ffd972
}

.dropbtn:active {
	background-color: #e5c259;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

.dropbtn:hover, .dropbtn:focus {
	background-color: #ffd972;
}

#myInput {
	border-box: box-sizing;
	background-image: url('searchicon.png'); /* OPTIONAL */
	background-position: 14px 12px;
	background-repeat: no-repeat;
	font-size: 16px;
	padding: 14px 20px 12px 45px;
	border: none;
	border-bottom: 1px solid #ddd;
}

#myInput:focus {
	outline: 3px solid #ddd;
}

.dropdown {
	position: relative;
	margin-left: 10%; /* TO MOVE IT TO THE LEEEEEEFT */
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f6f6f6;
	min-width: 230px;
	overflow: auto;
	border: 1px solid #ddd;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}
</style>
</body>

<body>

	<div class="dropdown">
		<button onclick="myFunction()" class="dropbtn">Your Major:</button>
		<div id="myDropdown" class="dropdown-content">
			<input type="text" placeholder="Search.." id="myInput"
				onkeyup="filterFunction()"> <a href="#Accounting">Accounting</a>
		</div>
	</div>

	<script>
		/* When the user clicks on the button,
		 toggle between hiding and showing the dropdown content */
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}

		function filterFunction() {
			var input, filter, ul, li, a, i;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			div = document.getElementById("myDropdown");
			a = div.getElementsByTagName("a");
			for (i = 0; i < a.length; i++) {
				if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
					a[i].style.display = "";
				} else {
					a[i].style.display = "none";
				}
			}
		}
	</script>

</body>



</section>


<section id="GEheading">
	<!--Free elective-->
	<body onload="init()">
		<div class="container" style="float: left; width: 25%; margin: 25px">
			<div id="GEheading">
				<h2>Free Elective/General Education</h2>

				<button class="button button1">COMP1000</button>
				<button class="button button2">COMP1501</button>
				<br> <br>

				<p style="margin-top: 90px">
					<button id="zoomToFit" class="button button4">Zoom to Fit</button>
					<button id="centerRoot" class="button button4">Center</button>
				</p>
				<p>
					<button id="sem1" class="button button4">Semester 1</button>
					<button id="sem2" class="button button4">Semester 2</button>
					<button id="sem3" class="button button4">Semester 3</button>
				</p>
				<p>
					<button id="reset" class="button button4">Reset</button>
				</p>
			</div>

			<div style="float: left; width: 350px; margin: 25px">
				<table border=0>
					<tr>
						<td>Legend for Flowchart</td>
					</tr>
					<tr>
						<td>Completed</td>
						<td><div class="squareC"></div></td>
					</tr>
					<tr>
						<td>Incompleted</td>
						<td><div class="squareI"></div></td>
					</tr>
				</table>
			</div>


		</div>
		<!-- NEXT SECTION - SPACE FOR FLOWCHART -->
		<div id="sample"
			style="width: 60%; float: right; margin: 30px; margin-right: 90px">
			<div id="myDiagramDiv"
				style="background-color: white; border: solid 1px black; width: 100%; height: 550px"></div>
		</div>
		<button class="open-button" onclick="openForm()"></button>

		<div class="chat-popup" id="myForm">
			<div class="form-container">
				<h1>Chat</h1>
				<textarea id="bot"></textarea>
				<label for="msg"><b>Message</b></label> <input
					placeholder="Type message.." class="messageBox"
					onKeypress="enterButton(event, document.getElementsByTagName('input')[0].value)"
					name="msg" required />

				<button
					onClick="answer(document.getElementsByTagName('input')[0].value)"
					class="btn">Send</button>
				<script src="JS/ChatbotJS.js" type="text/javascript">
					
				</script>
				<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			</div>
		</div>
		<section>
			<div>
				<img src="img/barbarbar.png" class="barbar">
			</div>
		</section>
		<script>
			function openForm() {
				document.getElementById("myForm").style.display = "block";
			}

			function closeForm() {
				document.getElementById("myForm").style.display = "none";
			}
		</script>
	</body>
</section>
</html>