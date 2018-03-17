/**
 * 
 */
package com.teamup.DB;
import java.sql.*;

import com.teamup.Constant.ClientConstant;
/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018��3��16��---����7:18:01
 *@problem	
**/
public class DBUtil {
	//���ݿ�������Դ
	private static String url=DBConfig.url;
	private static String usr=DBConfig.usr;
	private static String psd=DBConfig.psd;
	
	private static Connection connection;//���ݿ����Ӷ��󣨴�����ĳ���ݿ��һ�����ӣ�
	private static Statement statement;//�����󣨿ɽ��ܺ�ִ��һ��SQL��䣩
	private static ResultSet resultsets;//��������󣨱����ѯ���صĽ����

	//���ݿⷵ����Ϣ
	public static String code=null;
	public static String message=null;
	
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

	//ע�᷽���������ݿ����
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
			if(resultsets.next()){//����ܲ��ҵ����˺ţ�˵��ע�����
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
	
	//��¼����
	public static String loginClient(String account,String password){
		String sql;
		try{
			getConnect();
			sql=DBSql.selectUsr(account, password);
			resultsets=statement.executeQuery(sql);
			if(resultsets.next()){
				return ClientConstant.ACCOUNT_LOGIN_SUCCCESS;//��¼�ɹ�
			}else{
				return ClientConstant.ACCOUNT_LOGIN_FAIL;//��¼ʧ��
			}
		}catch(SQLException e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	//�����û�name
	public static String setUserName(String account,String name){
		String sql;
		try{
			getConnect();
			sql=DBSql.SQL_updateUserName(account, name);
			if(statement.executeUpdate(sql)>0){
				return ClientConstant.UPDATE_SUCCESS;//name���³ɹ�
			}else{
				return ClientConstant.UPDATE_FAIL;//name����ʧ��
			}
		}catch(SQLException e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	public static void setUserEmail(){
		
	}
	public static void setUserGender(){
		
	}
	public static void setUserCollege(){
		
	}
	public static void setUserSchool(){//ѧԺ
		
	}
	public static void setUserGrade(){
		
	}
	public static void setUserMajor(){
		
	}
	public static void setUserLab(){
		
	}
	public static void addUserProject(){
		
	}
}
