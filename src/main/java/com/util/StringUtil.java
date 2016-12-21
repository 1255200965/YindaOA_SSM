package com.util;

public class StringUtil {
	public static String addLeftStr(String strSource, String chrAdd,int intLength) {
		if (intLength <= 0)
			return null;
		if (strSource.length() > intLength) {
			return strSource;
		}

		int i = 0;
		StringBuffer strbufTemp = new StringBuffer("");

		while (i < intLength - strSource.length()) {
			strbufTemp = strbufTemp.append(chrAdd);
			i++;
		}

		return strbufTemp.toString() + strSource;
	}

	public static String addRightStr(String strSource, char chrAdd, int intLength) {
		if (intLength <= 0)
			return null;
		if (strSource.length() > intLength) {
			return strSource;
		}

		int i = 0;
		StringBuffer strbufTemp = new StringBuffer(strSource);

		while (i < intLength - strSource.length()) {
			strbufTemp = strbufTemp.append(chrAdd);
			i++;
		}

		return strbufTemp.toString();
	}
	
	public static boolean NotBlank(String str){
		if(str!=null&&!"".equals(str)){
			return true;
		}else{
			return false;
		}
	}
}
