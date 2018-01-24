package org.anttix.example.shj.services;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author olena.viliuzhanina
 *
 */
@Named
@Singleton
@Path("/user")
public class UserService {
	
	@PersistenceContext
	EntityManager em;
	
	

	@Path("/test")
	@GET
	@Produces("application/json")
	public Response test() {
		return Response.ok("{}").build();
	}
}
