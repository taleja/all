package main.persistent;

import java.util.List;

import main.entities.Router;

/**
 * @author olena.viliuzhanina
 *
 */
public interface IRouterDao {

	Router getRouterById(long id);

	List<Router> getRouters();

	void addRouter(Router router);

	void updateRouter(Router router);

	void deleteRouter(Router router);

	boolean isExist(Router router);
}
