package org.diy.util;

public class CommonUtil {
	public static boolean isEmpty(String s){
		return (s == null || "".equals(s.trim()));
	}
	public static boolean isEmpty(int n){
		return (n <=0);
	}
	
	public static void main(String[] ars){
		String uri = "/WebClass/jsp/aa/bb/login.do";
		
		String actionName = uri.substring(uri.lastIndexOf("/") + 1); 
		actionName = actionName.substring(0, actionName.indexOf("."));
		System.out.println(actionName);
	}
}
