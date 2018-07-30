package com.neuedu.usersys.usermgr.domain;

import java.util.Date;

/**
 * 用户信息类
 * @author Administrator
 *
 */
public class UserVO {
	private int id;           //主键
	private String name;      //用户名
	private String pass;      //密码
	private String mail;      //邮箱
	private String power;     //权限
	private Date birthday;    //出生日期
	private String userId;    //用户编号
	private String status;    
	
	
	/**
	 * 取得用户编号
	 * @return 编号
	 */
	public String getUserID(){
		return userId;
	}
	
	/**
	 * 设置用户编号为指定参数的值
	 * @param userId 用户编号
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getPass(){
		return pass;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public String getPower(){
		return power;
	}
	public void setPower(String power){
		this.power = power;
	}
	
	public Date getDate(){
		return birthday;
	}
	public void setDate(Date birthday){
		this.birthday = birthday;
	}
	
	public String getStatu(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}
}
