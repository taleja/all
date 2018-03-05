package main.persistent;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import main.entities.Router;

@Repository
public class RouterDao implements IRouterDao{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Router getRouterById(long id) {
		return entityManager.find(Router.class, id, LockModeType.PESSIMISTIC_WRITE); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Router> getRouters() {
		String hql = "From Router as router Order By router.router_id";
		return (List<Router>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addRouter(Router router) {
		entityManager.persist(router); 
	}

	@Override
	public void updateRouter(Router router) {
		Router routerFromDB = getRouterById(router.getRouter_id());
		routerFromDB.setName(router.getName());
		routerFromDB.setSources(router.getSources());
		entityManager.merge(routerFromDB);
	}

	@Override
	public void deleteRouter(Router router) {
		entityManager.remove(router); 
	}

	@Override
	public boolean isExist(Router router) {
		String hql = "From Router as router WHERE router.router_id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, router.getRouter_id()).getResultList().size();
		return count > 0 ? true : false;
	}

}
