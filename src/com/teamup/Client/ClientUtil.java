/**
 * 
 */
package com.teamup.Client;

import javax.servlet.http.HttpServletRequest;

import com.teamup.DB.DBResultMessage;
import com.teamup.DB.DBUtil;

/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018年3月16日---下午8:16:59
 *@problem	为了减少Servlet中的代码量以方便阅读以及维护，用户的注册和登录都在这里实现
**/

public class ClientUtil {
	
	//构造方法，用于用户注册/登录时的对象初始化
	public ClientUtil(){
		
	}
	
	//注册方法
	public static String registerClient(HttpServletRequest request){
		String CODE=DBUtil.regiserClient(request.getParameter("account"), request.getParameter("password"), request.getParameter("name"));//返回结果
		return DBResultMessage.getMessage(CODE);//返回信息
	}
	
	//登录方法
	public static String loginClient(HttpServletRequest request){
		
		return null;
	}
}
