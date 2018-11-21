package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * �û���ȡ.properties����������ļ�
 * 
 * @author new
 * 
 */
public class ReadPro extends Properties {

	private static ReadPro read;

	private ReadPro() {
		// ��ȡsrc��db.properties�ļ�
		InputStream in = ReadPro.class.getResourceAsStream("/jdbc.properties");
		try {
			// ����������
			load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ReadPro getNewInstance() {
		if (read == null) {
			read = new ReadPro();
		}
		return read;
	}

}
