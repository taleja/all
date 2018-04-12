function doLogin(){
	//alert("Alert");
	
	var login = document.getElementsByName("login")[0].value;
	var password = document.getElementsByName("password")[0].value;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var loginResult = JSON.parse(xhttp.responseText);
	    	if (!loginResult.dropboxConnected){
	    		document.location="/connect/user/" + loginResult.userId;
	    	} else {
	    		document.location="/dashboard.html?userId=" + loginResult.userId;
	    	}
	    }
	};
	
	xhttp.open("POST", "/login");
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.send(JSON.stringify({
		login:login, 
		password:password
	}));
	
}

