package main.service;

import java.util.List;

import main.entities.Router;

/**
 * @author olena.viliuzhanina
 *
 */
public interface IRouterService {

	Router getRouterById(long id);

	List<Router> getRouters();

	boolean createRouter(Router router);

	void updateRouter(Router router);

	void deleteRouter(Router router);
}
