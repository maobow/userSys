package com.neuedu.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.neuedu.usersys.common.dao.BaseDao;
import com.neuedu.usersys.common.exception.DaoException;
import com.neuedu.usersys.common.util.DBUtils;
import com.neuedu.usersys.usermgr.domain.UserVO;

/**
 * 用户dao接口的实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {
	/**
	 * 数据库连接
	 */
	private Connection conn;
	
	/**
	 * 构造方法
	 * 
	 * @param conn 数据库连接
	 */
	public UserDaoImpl(Connection conn){
		//给属性赋初始化值
		this.conn = conn;
	}
	/**
	 * 用户登录
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public UserVO login(String name,String password){
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象
			pstam = conn.prepareStatement("select * from t_user where name = ? and pass = ? and status = '0'");
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量			
			pstam.setString(1, name);
			pstam.setString(2, password);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，取出结果集中的各个字段，封装在用户对象的各个属性中
			if (rs.next()) {
				//创建一个新用户对象，赋值给用户对象变量
				user = new UserVO();
				/*
				 * 调用结果集对象的getXxx方法，取出各个字段的值，
				 * 然后再调用用户对象的setXxx方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果中的所有字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUserId(rs.getString("userId"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setMail(rs.getString("mail"));
				user.setPower(rs.getString("power"));
				user.setDate(rs.getDate("birth"));
			}
			//如果出现异常，输出异常信息
		} catch (SQLException e) {
			System.out.println("在插入用户的时候出错了，错误信息是："+e.getMessage());
			//将异常封装成自定义异常
			throw new DaoException("登录时查询数据出错",e);
		}finally{
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
		/*
		 * 最后，返回用户对象，如果查询结果不为空，该对象中封装了查询结果中的数据
		 * 如果查询结果为空，该对象为空值null
		 */
		return user;	
	}
	
	
}
