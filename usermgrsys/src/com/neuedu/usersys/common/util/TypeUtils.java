package com.neuedu.usersys.common.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.neuedu.usersys.common.exception.DateException;
import com.neuedu.usersys.common.exception.EmailException;



/**
 * 类型转化工具类
 * @author Administrator
 */
public class TypeUtils {
	/**
	 * 字符串转化为日期
	 * @param str 指定的字符串
	 * @return 转换后的日期
	 */
	public static Date strToDate(String str){
		Date date = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将字符串解析成指定格式的日期类型
			date = sdf.parse(str);
		} catch (ParseException e) {
			// 将异常封装成自定义异常
			throw new DateException("字符串转化为日期出错",e);
		}
		//返回转换后的值
		return date;
	}

	/**
	 * 日期转换为字符串
	 * @param date 指定日期
	 * @return 转换后的字符串
	 */
	public static String dateToStr(Date date) {
		String str = null;
		try {
			//设置要格式化的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//调用formate方法，将日期格式化为字符串
			str = sdf.format(date);
		} catch (Exception e) {
			throw new DateException("日期转换为字符串出错");
		}
		//返回转换后的值
		return str;
	}
	
	/**
	 * 检查邮箱地址格式
	 * @param email 指定的邮箱
	 */
	public static boolean checkEmail(String email) {
		try {
			String mail = email.replaceAll("^\\s*\\w+(?.\\.{0,1}[\\w-]+)*@[A-Za-z0-9]+(?:[-.]"+
					"[a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$","");
		
		if (mail.length() == 0) {
			return true;
		}else {
			System.out.println("邮箱格式错误");
			return false;
		}
		
		} catch (Exception e) {
			throw new EmailException("邮箱格式错误",e);
		}
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str 指定的字符串
	 */
	public static boolean isEmpty(String str) {
		try{
			
		if (str == null ||str.length()==0) {
			return true;
		}else {
			System.out.println("字符串为空");
			return false;
		}
		
		} catch (Exception e) {
			throw new EmailException("邮箱格式错误",e);
		}
	}
	
	
	
	
}
