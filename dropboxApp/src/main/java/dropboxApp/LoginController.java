package dropboxApp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class LoginController {

	@Autowired
	private EntityManager em;
	@Autowired
	private UserTokenDAO userTokenDAO;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginResultDTO loginUser(@RequestBody UserLoginDTO userLoginDTO) {
		Query query = em.createQuery("from User us where us.login=:inputLogin");
		query.setParameter("inputLogin", userLoginDTO.getLogin());
		List<User> userList = (List<User>) query.getResultList();

		if (userList.isEmpty()) {
			User user = new User();
			user.setLogin(userLoginDTO.getLogin());
			user.setPassword(userLoginDTO.getPassword());
			em.persist(user);
			return new LoginResultDTO(LoginStatus.OK, user.getId(), false);
		} else {
			User user = userList.get(0);
			if (user.getPassword() != null && user.getPassword().equals(userLoginDTO.getPassword())) {
				boolean isDropboxConnected = userTokenDAO.findUserTokenByUserId(user.getId()).isPresent();
				return new LoginResultDTO(LoginStatus.OK, user.getId(), isDropboxConnected);
			} else {
				return new LoginResultDTO(LoginStatus.FAILED, user.getId(), null);
			}
		}
	}
}
