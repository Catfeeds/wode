package com.util;

import java.io.UnsupportedEncodingException;

public class CodeToString {
	// 处理中文字符串的函数
	public String codeString(String str) {
		String s = str;
		try {
			byte[] temp = s.getBytes("utf-8");
			s = new String(temp);
			return s;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}

	// 通过截取字符串获得文件名
	public String getPhoName(String str) {
		String s = str;
		String ss = null;
		String[] s1 = s.split("\"");
		int i = s1.length - 1;
		System.out.println("split后的长度为：" + s1[i]);
		return codeString(s1[i]);
	}

}
