package edu.csupomona.cs480.data.provider;

import java.util.List;

import edu.csupomona.cs480.data.entity.User;

public interface UserManager {

	/**
	 * Get the user information object based on
	 * the given userId.
	 * <p>
	 * If the user does not exist, simply create
	 * one.
	 *
	 * @param userId
	 * @return the User object
	 */
    User getUser(String userId);

	/**
	 * Update the given user object and persist it.
	 * <p>
	 * If the user does not exist before, this
	 * method will create a new record; otherwise,
	 * it will overwrite whatever is currently
	 * being stored.
	 *
	 * @param user object
	 */
    void updateUser(User user);

	/**
	 * Delete the given user from the storage.
	 *
	 * @param userId
	 */
    void deleteUser(String userId);

	/**
	 * List all the current users in the storage.
	 *
	 * @return
	 */
    List<User> listAllUsers();

}
