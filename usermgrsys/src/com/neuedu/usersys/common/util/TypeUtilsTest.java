package com.neuedu.usersys.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TypeUtilsTest {

	@Test
	
//	public void dateToStr() {
//		Date date=new Date();
//		String str = TypeUtils.dateToStr(date);
//		System.out.println(str);
//	}

	public void StrTodate() {
	
		Date date = TypeUtils.strToDate("2001-01-01");
		System.out.println(date);
	}
	
//	public void checkEmail(){
//		boolean flag = TypeUtils.checkEmail("aa@qq.com");
//		
//	}
//	public void isEmpty(){
//		boolean flag = TypeUtils.isEmpty("");
//		System.out.println(flag);
//		
//	}
	
	
}
