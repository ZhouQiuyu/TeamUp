/**
 * 
 */
package com.teamup.DB;
/**
 *@author	created by Zozo E-mail:zozo@zhouqiuyu.cn
 *@date		2018��3��16��---����9:25:45
 *@problem	���ݿ�ִ�ж��������Ϣ
**/
public class DBResultMessage {
	public static String getMessage(String CODE){
		switch(CODE){
		case "100":
			return "ע��ɹ�";
		case "101":
			return "�˺��Ѵ���";
		case "102":
			return "ע��ʧ��";
		case "200":
			return "��½�ɹ�";
		case "201":
			return "��¼ʧ��,���벻ƥ����˺Ų�����";
		case "300":
			return "���³ɹ�";
		default:
			return CODE;
		}
	}
}
