/**
 * 
 */
package com.teamup.DB;
/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018年3月16日---下午9:25:45
 *@problem	数据库执行动作结果消息
**/
public class DBResultMessage {
	public static String getMessage(String CODE){
		switch(CODE){
		case "100":
			return "注册成功";
		case "101":
			return "账号已存在";
		case "102":
			return "注册失败";
		case "200":
			return "登陆成功";
		case "201":
			return "登录失败,密码不匹配或账号不存在";
		default:
			return CODE;
		}
	}
}
