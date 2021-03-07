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
	function alieni() {
		console.log("ciao");
		/*jQuery.getJSON("../aliens1?callback=?", function(alien)
						{	
							console.log("funzione di callback invocata");
							console.log(alien);
							console.log(alien[0].name);
							console.log(alien[0].points);
							$("#field1").val(alien[0].name);
							$("#field2").val(alien[0].points);
						})
		console.log(jQuery.getJSON("../aliens1"));*/
		jQuery.ajax({
			type : "GET", //The HTTP request method.
			url : "http://localhost:8080/demorestWithSpring/aliens1", //The URL of the data to fetch.
			data : null, //Don't add any data to the URL.
			dataType : "json", //Execute the response as a script once we get it.
			contentType : "application/json",
			success : function(aliens) {
				console.log("funzione di callback invocata");
				console.log(typeof aliens);
				console.log((aliens.aliens[0]).name);
				console.log(aliens.aliens[1]);
				
			/*	var array = $.map(aliens.aliens, function(value, index){
			        return [value];
			    });
			    
			    console.log(array.length);*/
			    console.log(aliens.aliens.length);
				//console.log(aliens[0].points);   Nonva bene! devi mettere aliens.aliens[0].points
				$("#field1").val(aliens.aliens[1].name);
				$("#field2").val(aliens.aliens[1].points);
			}
		});

	}

	function listaAlieni() {
		console.log("lista dinamica degli alieni");
		/*jQuery.getJSON("../aliens1?callback=?", function(alien)
						{	
							console.log("funzione di callback invocata");
							console.log(alien);
							console.log(alien[0].name);
							console.log(alien[0].points);
							$("#field1").val(alien[0].name);
							$("#field2").val(alien[0].points);
						})
		console.log(jQuery.getJSON("../aliens1"));*/
		jQuery.ajax({
			type : "GET", //The HTTP request method.
			url : "http://localhost:8080/demorestWithSpring/aliens1", //The URL of the data to fetch.
			data : null, //Don't add any data to the URL.
			dataType : "json", //Execute the response as a script once we get it.
			contentType : "application/json",
			success : function(aliens) {
				console.log("funzione di callback invocata");
				console.log(typeof aliens);
				console.log((aliens.aliens[0]).name);
				console.log(aliens.aliens[1]);
				//console.log(aliens[0].points);   Nonva bene! devi mettere aliens.aliens[0].points
				/*$("#field1").val(aliens.aliens[1].name);
				$("#field2").val(aliens.aliens[1].points);*/

				//NB: ogni volta che clicco su "clicca per la lista di alieni" ottengo un prolungamento della lista 
				//e quindi devo prima eliminare 
				$('#users .list li').remove();
				//$('#users .list').empty();
				
				for(var i = 0; i<aliens.aliens.length; i++)
					$('#users .list').append('<li><h3 class="name">'+aliens.aliens[i].name+'</h3></li>')
			}
		});

	}
</script>
</head>
<body>
	<h2>Jersey RESTful Web Application!</h2>
	<p>
		<a href="myresource">Jersey resource</a>
	</p>

	<p>
		Clicca per ottenere gli <a href="aliens">alieni</a>.
	</p>
	<button id="bottone1" onclick="alieni()">clicca per gli alieni</button>
	<!-- onclick="alieni()"-->

	Nome:
	<input id="field1" type="text" /> Punti:
	<input id="field2" type="text" />

	<p>
		Clicca per ottenere la lista di <a href="aliens">alieni</a>.
	</p>
	<button id="bottone1" onclick="listaAlieni()">clicca per la lista di
		alieni</button>
	<!-- onclick="alieni()"-->

	<div id="users">
		<ul class="list">
			<li>
				<h3 class="name">name1</h3>
			</li>
			<li>
				<h3 class="name">name2</h3>
			</li>
		</ul>
	</div>
	
	
	<div id="users1">
	<table class="list">
		<tr></tr>
	</table>
		<ul class="list">
			<li>
				<h3 class="name">name1</h3>
			</li>
			<li>
				<h3 class="name">name2</h3>
			</li>
		</ul>
	</div>
	
	
</body>
</html>