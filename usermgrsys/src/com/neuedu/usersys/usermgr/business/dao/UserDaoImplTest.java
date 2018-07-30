package com.neuedu.usersys.usermgr.business.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neuedu.usersys.common.util.DBUtils;
import com.neuedu.usersys.common.util.DBUtilsTest;
import com.neuedu.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void test() {
		UserDaoImpl impl = new UserDaoImpl(DBUtils.getConnection());
		UserVO user = null;
		user = impl.login("aaa", "aaa");
		System.out.println(user.getMail());
	}

}
