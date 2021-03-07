<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
/*function alieni()
{$("#bottone1").click(function()
		{
			jQuery.getJSON("webapi/aliens", function(alien)
					{
						console.log(alien[0].name);
						console.log(alien[0].points);
					})
		});
		
	}*/
	function alieni()
	{	console.log("ciao");
		jQuery.getJSON("aliens", function(alien)
						{	console.log(alien[0].name);
							console.log(alien[0].points);
							$("#field1").val(alien[0].name);
							$("#field2").val(alien[0].points);
						})
		
	}
			

</script>
</head>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="myresource">Jersey resource</a></p>
    
     <p>Clicca per ottenere gli  <a href="aliens">alieni</a>.</p>
     <button id="bottone1" value="clicca per gli alieni" onclick="alieni()"></button> <!-- onclick="alieni()"-->
     
     Nome: <input id="field1" type="text"/>
     Punti: <input id="field2" type="text"/>
</body>
</html>
