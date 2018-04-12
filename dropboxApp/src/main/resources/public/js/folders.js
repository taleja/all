function getFolders(){
	var userId = getParameterByName('userId');
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	   
		if (this.readyState == 4 && this.status == 200) {
	    	var loginResult = JSON.parse(xhttp.responseText); 
	    	
	    	var html = [];
	    	html.push('<ul>')
	    	loginResult.entries.forEach(function(element){
	    		html.push("<li>");
	    		html.push(element.name)
	    		
	    		html.push("</li>");
	    	});
	    	html.push('</ul>')
	    	document.getElementById("result").innerHTML = html.join("");
	    }
	};
	
	xhttp.open("GET", "/folders/user/" + userId);
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.send();
};