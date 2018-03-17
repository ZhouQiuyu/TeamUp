/**
 * 
 */
package com.teamup.DB;
import java.sql.*;

import com.teamup.Constant.ClientConstant;
/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018年3月16日---下午7:18:01
 *@problem	
**/
public class DBUtil {
	//数据库连接资源
	private static String url=DBConfig.url;
	private static String usr=DBConfig.usr;
	private static String psd=DBConfig.psd;
	
	private static Connection connection;//数据库连接对象（代表与某数据库的一个连接）
	private static Statement statement;//语句对象（可接受和执行一条SQL语句）
	private static ResultSet resultsets;//结果集对象（保存查询返回的结果）

	//数据库返回信息
	public static String code=null;
	public static String message=null;
	
	/*
	//构造方法，连接初始化
	public DBUtil(){
		try {
			System.out.println("构造方法的执行");
			connection=DriverManager.getConnection(url, usr, psd);//执行数据库的连接
			statement=(Statement)connection.createStatement();//创建Statement对象
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	//注册方法——数据库操作
	public static String regiserClient(String account,String password,String name){

		String sql;
		try {
			/*
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url, usr, psd);
			statement=(Statement)connection.createStatement();*/
			getConnect();
			sql=DBSql.findUsr(account);
			resultsets=statement.executeQuery(sql);
			if(resultsets.next()){//如果能查找到该账号，说明注册过了
				return ClientConstant.ACCOUNT_EXITED;
			}else{
				sql=DBSql.registerUsr(account, password, name);
				if(statement.executeUpdate(sql)>0){
					return ClientConstant.ACCOUNT_REGISTER_SUCCESS;
				}else{
					return ClientConstant.ACCOUNT_REGISTER_FAIL;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		//return null;
	}
	
	//登录方法
	public static String loginClient(String account,String password){
		String sql;
		try{
			getConnect();
			sql=DBSql.selectUsr(account, password);
			resultsets=statement.executeQuery(sql);
			if(resultsets.next()){
				return ClientConstant.ACCOUNT_LOGIN_SUCCCESS;//登录成功
			}else{
				return ClientConstant.ACCOUNT_LOGIN_FAIL;//登录失败
			}
		}catch(SQLException e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public static void getConnect(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(url, usr, psd);
		statement=(Statement)connection.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
