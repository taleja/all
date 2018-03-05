package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entities.Router;
import main.persistent.RouterDao;

@Service
public class RouterService implements IRouterService{

	@Autowired
	private RouterDao routerDao;

	public Router getRouterById(long id) {		
		return routerDao.getRouterById(id);
	}

	@Override
	public List<Router> getRouters() {
		return routerDao.getRouters();
	}

	@Override
	public boolean createRouter(Router router) {
		if(!routerDao.isExist(router)) {
			routerDao.addRouter(router); 
			return true;
		}
		return false;
	}

	@Override
	public void updateRouter(Router router) {
		routerDao.updateRouter(router); 		
	}

	@Override
	public void deleteRouter(Router router) {
		routerDao.deleteRouter(router);  
	}

}
