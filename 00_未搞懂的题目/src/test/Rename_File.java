package test;

import java.io.File;

public class Rename_File {
	public static void main(String[] args) {
		String videoPath = "H:\\DX\\黑马57期\\24 项目框架架构优化\\2020最新MySQL高级教程\\day04";
		File file = new File(videoPath);
		File[] list = file.listFiles();

		// 如果目录下文件存在
		if (file.exists() && file.isDirectory()) {
			for (int i = 0; i < list.length; i++) {
				// 取文件名子存入name中
				String name = list[i].getName();
				// 截取.之前的字符串出来
				int index = name.indexOf(".");
				// 截取.JPG出来
				int index2 = name.lastIndexOf(".");
				String name3 = name.substring(0, index2+1);
				String name4 = name3.replaceAll("MySQL 高级 - ", "");
				int index3 = name4.lastIndexOf("(Av");
				int index4 = name4.lastIndexOf(").");
				String name5 = name4.substring(0, index3);
				// 拼接字符串
				String newName = name5 + ".mp4";
				// 重命名
				File dest = new File(videoPath + "\\" + newName);
				list[i].renameTo(dest);
				System.out.println(dest.getName());
			}
		}
	}
}
