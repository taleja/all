package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import main.entities.Router;
import main.service.RouterService;

@Controller
@RequestMapping("router-rest")
public class RouterController {

	@Autowired
	private RouterService routerService;

	@GetMapping("routerById/{id}")
	public ResponseEntity<Router> getRouterById(@PathVariable(name = "id") long id) {
		Router router = routerService.getRouterById(id);
		return new ResponseEntity<Router>(router, HttpStatus.OK);
	}

	@GetMapping("roters")
	public ResponseEntity<List<Router>> getRouters() {
		List<Router> routers = routerService.getRouters();
		return new ResponseEntity<List<Router>>(routers, HttpStatus.OK);
	}

	@PostMapping("router")
	public ResponseEntity<Void> createRouter(@RequestBody Router router, UriComponentsBuilder builder) {
		boolean isExist = routerService.createRouter(router);
		if (!isExist) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("routerById/{id}").buildAndExpand(router.getRouter_id()).toUri()); 
		return new ResponseEntity<Void>(HttpStatus.CREATED); 
	}
	
	@PutMapping("router")
	public ResponseEntity<Router> updateRouter(@RequestBody Router router){
		routerService.updateRouter(router); 
		return new ResponseEntity<Router>(router, HttpStatus.OK); 		
	}
	
	@DeleteMapping("rotuter/{id}")
	public ResponseEntity<Void> deleteRouter(@PathVariable(name = "id") long id){
		Router router = routerService.getRouterById(id);
		routerService.deleteRouter(router);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
}
