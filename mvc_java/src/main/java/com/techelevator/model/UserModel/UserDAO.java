package com.techelevator.model.UserModel;

public interface UserDAO {

	void saveUser(String userName, String password, String email, String role);

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

	public Object getUserByUserName(String userName);

	public void deleteUserbyUserName(String userName);

}
