package dropboxApp;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	@Autowired
	private EntityManager entityManager;
	
	public User getUserById(Long userId) {
		return entityManager.find(User.class, userId);
	}
}
