package com.training.entity.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileManager {

	private File file;

	private static final String FILE_EXISTS = "File exists!";
	private static final String FILE_NOT_EXISTS = "Error, files does not exist!";
	private static final String CREATE_FILE_SUCCESSFULLY = "File created successfully!";
	private static final String DELETE_FILE_SUCCESSFULLY = "File deleted successfully!";
	private static final String PATH_IS_FOLDER = "Path is folder!";
	private static final String PATH_NOT_FOLDER = "Path is not folder!";
	private static final String FOLDER_EMPTY = "Folder is empty!";
	private static final String RENAME_FILE_SUCCESSFULLY = "File rename successfully!";
	private static final String COPY_FILE_SUCCESSFULLY = "File copy successfully!";
	private static final String CREATE_FOLDER_SUCCESSFULLY = "Folder created successfully!";

	// constructor
	public FileManager(String filePath) {
		file = new File(filePath);
	}

	public boolean isFileExists() {
		return (file.exists());
	}

	public void createNewFile() throws Exception {
		if (isFileExists()) {
			throw new Exception(FILE_EXISTS);
		} else {
			file.createNewFile();
			System.out.println(CREATE_FILE_SUCCESSFULLY);
		}
	}

	public void deleteFile() throws Exception {
		if (!isFileExists()) {
			throw new Exception(FILE_NOT_EXISTS);
		} else {
			file.delete();
			System.out.println(DELETE_FILE_SUCCESSFULLY);
		}
	}

	public void isFileFolder() throws Exception {
		if (isFileExists()) {
			if (file.isDirectory()) {
				System.out.println(PATH_IS_FOLDER);
			} else {
				System.out.println(PATH_NOT_FOLDER);
			}
		} else {
			throw new Exception(FILE_NOT_EXISTS);
		}
	}

	public void getAllFiles() throws Exception {
		if (isFileExists()) {
			if (!file.isDirectory()) {
				throw new Exception(PATH_NOT_FOLDER);
			} else {
				File[] listOfFiles = file.listFiles();
				if (listOfFiles.length == 0) {
					System.out.println(FOLDER_EMPTY);
				} else {
					for (File f : listOfFiles) {
						if (f.isDirectory()) {
							System.out.println("Folder: " + f.getName());
						}
						if (f.isFile()) {
							System.out.println("File: " + f.getName());
						}
					}
				}
			}
		} else {
			throw new Exception(FILE_NOT_EXISTS);
		}
	}

	public void copyFiles(String filePathDest) throws Exception {
		if (isFileExists()) {
			FileReader r = new FileReader(file);
			FileWriter w = new FileWriter(filePathDest);

			int ch;

			while ((ch = r.read()) != -1) {
				w.write(ch);
			}
			r.close();
			w.close();
			System.out.println(COPY_FILE_SUCCESSFULLY);
		} else {
			throw new Exception(FILE_NOT_EXISTS);
		}
	}

	public void renameFiles(String filePathDest) throws Exception {
		if (isFileExists()) {
			File fileDest = new File(filePathDest);
			if (fileDest.exists()) {
				throw new Exception(FILE_EXISTS);
			} else {
				file.renameTo(fileDest); // behave like moving files so we don't need to create move anymore
				System.out.println(RENAME_FILE_SUCCESSFULLY);
			}
		} else {
			throw new Exception(FILE_NOT_EXISTS);
		}
	}

	public void createFolder() throws Exception {
		if (isFileExists()) {
			throw new Exception(FILE_EXISTS);
		} else {
			file.mkdir();
			System.out.println(CREATE_FOLDER_SUCCESSFULLY);
		}
	}

	public void downloadFile(String filePathDest) throws IOException {
		
		try (BufferedInputStream in = new BufferedInputStream(new URL("https://app.box.com/s/lrhrvutyrkd60lzkz87x5eahrj834ps2").openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream(filePathDest)) {
				    byte dataBuffer[] = new byte[1024];
				    int bytesRead;
				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				        fileOutputStream.write(dataBuffer, 0, bytesRead);
				    }
				} catch (IOException e) {
				    // handle exception
				}		
	}
}