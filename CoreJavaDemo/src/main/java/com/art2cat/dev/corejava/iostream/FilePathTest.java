package com.art2cat.dev.corejava.iostream;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Properties;

public class FilePathTest {

	public static void main(String[] args) throws URISyntaxException {
		FilePathTest filePathTest = new FilePathTest();
		System.out.println(FilePathTest.class.getClassLoader().getResource(""));
		System.out.println(filePathTest.getClass().getClassLoader().getResource(""));
		System.out.println(FilePathTest.class.getResource("").toURI().getPath());//class所在目录
		System.out.println(ClassLoader.getSystemResource(""));//class所在目录
		System.out.println(System.getProperty("user.dir"));
		File directory = new File("");//设定为当前文件夹
		System.out.println(Thread.currentThread()
				.getContextClassLoader().getResource(""));
		try {

			System.out.println(directory.getCanonicalPath());//获取标准的路径

			System.out.println(directory.getAbsolutePath());//获取绝对路径

		} catch (Exception e) {
			e.printStackTrace();
		}

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		System.out.println(classloader);

		File file = new File(classloader.getResource("application.properties").getFile());
		System.out.println(file.getAbsolutePath());
		if (classloader == null) {
			Properties impieties = new Properties();
			classloader = impieties.getClass().getClassLoader();
		}
		System.out.println(classloader);
	}
}
