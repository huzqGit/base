package com.common.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {
	private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

	private FileUtils(){}

	public static void deleteFileOnExit(File file, boolean deleteParentFile) {
		boolean isDelete = file.delete();
		log.debug("delete file {} ... Result: {}.", file.getAbsolutePath(),
		    isDelete);
		if (!isDelete) {
			log.warn("file {} delete fail! RETRY delete it on exit!", file
			    .getAbsolutePath());
			file.deleteOnExit();
		}
		if (deleteParentFile) {
			File parentFolder = file.getParentFile();
			isDelete = parentFolder.delete();
			log.debug("remove the parant folder {} ... Result: {}. ", parentFolder,
			    isDelete);
		}
	}

	public static void makeFolderExists(String folder) {
		File file = new File(folder);
		makeFolderExists(file);
	}

	public static void makeFolderExists(File folder) {
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public static File createTempFile(InputStream is, String prefix,
	    String suffix, String fileFolder) throws IOException {
		File targetFile = createTempFile(prefix, suffix, fileFolder);
		inputStreamToFile(is, targetFile);
		return targetFile;
	}
	
	public static File createTempFile(String prefix,
	    String suffix, String fileFolder) throws IOException {
		makeFolderExists(fileFolder);
		return File.createTempFile(prefix, suffix, new File(fileFolder));
	}

	public static File createFile(InputStream is, String fileFolder,
	    String fileName) throws IOException {
		makeFolderExists(fileFolder);
		File targetFile = new File(fileFolder + fileName);
		inputStreamToFile(is, targetFile);
		return targetFile;
	}

	private static File inputStreamToFile(InputStream is, File file)
	    throws IOException {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			IOUtils.copy(is, os);
		} finally {
			if (os != null) {
				os.flush();
				os.close();
			}
		}
		return file;
	}
}
