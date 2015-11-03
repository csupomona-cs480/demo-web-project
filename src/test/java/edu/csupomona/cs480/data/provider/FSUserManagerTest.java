package edu.csupomona.cs480.data.provider;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.csupomona.cs480.data.User;

public class FSUserManagerTest {

	private FSUserManager fsUserManager;

	@Test
	public void testUpdateUser() {
		FSUserManager fsUserManager = new FSUserManager();

		// test add
		User user1 = new User();
		user1.setId("new00001");
		user1.setMajor("CS");
		user1.setName("Yu");

		fsUserManager.updateUser(user1);

		User returnedUser = fsUserManager.getUser("new00001");
		Assert.assertNotNull(returnedUser);
		Assert.assertEquals("Yu", returnedUser.getName());
		Assert.assertEquals("CS", returnedUser.getMajor());
		Assert.assertEquals("new00001", returnedUser.getId());

		// test update

		user1.setId("new00001");
		user1.setMajor("EE");
		user1.setName("Sun");
		int sizeBefore = fsUserManager.listAllUsers().size();

		fsUserManager.updateUser(user1);

		int sizeAfter = fsUserManager.listAllUsers().size();
		returnedUser = fsUserManager.getUser("new00001");
		Assert.assertNotNull(returnedUser);
		Assert.assertEquals("Sun", returnedUser.getName());
		Assert.assertEquals("EE", returnedUser.getMajor());
		Assert.assertEquals("new00001", returnedUser.getId());

		Assert.assertEquals(sizeBefore, sizeAfter);
	}

	@Before
	public void setup() {
		fsUserManager = new FSUserManager();
		User userToTest = fsUserManager.getUser("new00001999");
		if (userToTest != null) {
			fsUserManager.deleteUser("new00001999");
		}
	}

	@After
	public void clean() {
		fsUserManager.deleteUser("new00001999");
	}

	@Test
	public void testListAllUsers() {
		List<User> users = fsUserManager.listAllUsers();

		User user1 = new User();
		user1.setId("new00001999");
		user1.setMajor("EE");
		user1.setName("Sun");
		fsUserManager.updateUser(user1);

		List<User> users2 = fsUserManager.listAllUsers();

		Assert.assertEquals(users.size() + 1, users2.size());
	}
}
