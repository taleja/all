package rest;

import java.io.*;
import java.util.*;


public class UserDao {

	public List<User> getAllUsers(){
		List<User> userList = null;
		try {
			File file = new File("User.dat");
			if (!file.exists()) {
				User user = new User(1, "Olena", "Developer");
				userList = new ArrayList<>();
				userList.add(user);
				saveUserList(userList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				userList = (List<User>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
		}
		return userList;
	}

	private void saveUserList(List<User> userList) {
		File file = new File("User.dat");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {

		}  catch (IOException e) {}
	}

	public int addUser(User user) {
		List<User> userList = getAllUsers();
		boolean userExists = false;
		for(User usr: getAllUsers()) {
			if(user.getId() == usr.getId()) {
				userExists = true;
				break;
			}
		}
		
		if(!userExists) {
			userList.add(user);
			saveUserList(userList);
			return 1;
		}
		return 0;
	}
	
	public User getUser(int id) {
		for(User usr: getAllUsers()) {
			if(usr.getId() == id) {
				return usr;
			}
		}
		return null;
	}
	
	public int updateUser(User user) {
		List<User> userList = getAllUsers();
		for(User usr: userList) {
			if(usr.getId() == user.getId()) {
				int index = userList.indexOf(usr);
				userList.set(index, user);
				saveUserList(userList);
				return 1;
			}
		}
		return 0;
	}
	
	public int deleteUser(int id) {
		List<User> userList = getAllUsers();
		for(User usr: userList) {
			if(usr.getId() == id) {
				int index = userList.indexOf(usr);
				userList.remove(index);
				saveUserList(userList);
				return 1;
			}
		}
		return 0;
	}
}
