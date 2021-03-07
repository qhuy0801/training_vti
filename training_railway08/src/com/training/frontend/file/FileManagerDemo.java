package com.training.frontend.file;

import com.training.entity.utils.FileManager;

public class FileManagerDemo {
	public static void main(String[] args) throws Exception {
		FileManager program = new FileManager("https://www.w3.org/TR/PNG/iso_8859-1.txt");
		
		program.downloadFile("D:\\Testing folder java\\testcopy\\text2-try2.txt");
	}
}
