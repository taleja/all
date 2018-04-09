package dropboxApp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTokenDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public Optional<UserToken> findUserTokenByUserId(Long userId) {
		Query query = entityManager.createQuery("from UserToken ut where ut.userId=:userId");
		query.setParameter("userId", userId);
		List<UserToken> userTokenList = query.getResultList();		
		return userTokenList.isEmpty() ? Optional.empty() : Optional.of(userTokenList.get(0));
	}

}
