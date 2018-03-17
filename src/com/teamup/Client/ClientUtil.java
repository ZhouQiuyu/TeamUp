/**
 * 
 */
package com.teamup.Client;

import javax.servlet.http.HttpServletRequest;

import com.teamup.DB.DBResultMessage;
import com.teamup.DB.DBUtil;

/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018��3��16��---����8:16:59
 *@problem	Ϊ�˼���Servlet�еĴ������Է����Ķ��Լ�ά�����û���ע��͵�¼��������ʵ��
**/

public class ClientUtil {
	
	//���췽���������û�ע��/��¼ʱ�Ķ����ʼ��
	public ClientUtil(){
		
	}
	
	//ע�᷽��
	public static String registerClient(HttpServletRequest request){
		String CODE=DBUtil.regiserClient(request.getParameter("account"), request.getParameter("password"), request.getParameter("name"));//���ؽ��
		return DBResultMessage.getMessage(CODE);//������Ϣ
	}
	
	//��¼����
	public static String loginClient(HttpServletRequest request){
		String CODE=DBUtil.loginClient(request.getParameter("account"),request.getParameter("password"));
		return DBResultMessage.getMessage(CODE);
	}
}
