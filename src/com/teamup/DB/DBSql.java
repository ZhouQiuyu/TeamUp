/**
 * 
 */
package com.teamup.DB;
/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018年3月16日---下午8:47:53
 *@problem	为方便项目维护，在此存放所有的数据库语句
**/
public class DBSql {
	
	//查找用户(登录)
	public static String selectUsr(String account,String password){
		String sql="SELECT account FROM "+DBConfig.TABLE_USR+" WHERE account='"+account+"' AND password='"+password+"'";
		return sql;
	}
	
	//查找用户(注册)
	public static String findUsr(String account){
		String sql="SELECT account FROM "+DBConfig.TABLE_USR+" WHERE account='"+account+"'";
		return sql;
	}
	
	//新增用户(注册)
	public static String registerUsr(String account,String password,String name){
		String sql="INSERT INTO "+DBConfig.TABLE_USR+"(account,password,name) VALUES('"+account+"','"+password+"','"+name+"')";
		return sql;
	}
	
	//设置名字
	public static String SQL_updateUserName(String account,String name){
		String sql="UPDATE "+DBConfig.TABLE_USR+" SET name="+"'"+name+"'"+" WHERE account="+"'"+account+"'";
		return sql;
	}
}
