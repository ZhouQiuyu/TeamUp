/**
 * 
 */
package com.teamup.DB;
/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018��3��16��---����8:47:53
 *@problem	Ϊ������Ŀά�����ڴ˴�����е����ݿ����
**/
public class DBSql {
	
	//�����û�(��¼)
	public static String selectUsr(String account,String password){
		String sql="SELECT account FROM "+DBConfig.TABLE_USR+" WHERE account='"+account+"' AND password='"+password+"'";
		return sql;
	}
	
	//�����û�(ע��)
	public static String findUsr(String account){
		String sql="SELECT account FROM "+DBConfig.TABLE_USR+" WHERE account='"+account+"'";
		return sql;
	}
	
	//�����û�(ע��)
	public static String registerUsr(String account,String password,String name){
		String sql="INSERT INTO "+DBConfig.TABLE_USR+"(account,password,name) VALUES('"+account+"','"+password+"','"+name+"')";
		return sql;
	}
	
	//��������
	public static String SQL_updateUserName(String account,String name){
		String sql="UPDATE "+DBConfig.TABLE_USR+" SET name="+"'"+name+"'"+" WHERE account="+"'"+account+"'";
		return sql;
	}
}
