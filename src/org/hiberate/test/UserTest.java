package org.hiberate.test;


import org.hiberate.dao.UserDao;
import org.hiberate.entity.User;
import org.junit.Test;
import org.hiberate.entity.*;
import junit.framework.TestCase;

public class UserTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	@Test
	public void testSave() {
		try {
			User user = new User();
			user.setName("ZhangSan");
			user.setPassword("123");
			user.setType("admin");
			UserDao.Save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
