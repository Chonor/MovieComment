package com.group.bean;
import java.io.*;
import org.apache.commons.io.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;


public class Upload {
	
	//��������ϴ��ļ����ļ���
	public void Mkdir(String path) {
		File FileDir = new File(path);
		if (!FileDir.exists()){
			FileDir.mkdir();
		}
	}
	
	//�ϴ��û�ͼƬ������URL
	public String uploadUserImage(FileItem fi, String user_id, String RealPath) throws Exception {
		//RealPath=application.getRealPath("/Upload/Photos")
		DiskFileItem dfi = (DiskFileItem) fi;
		String fileURL = "image/defaultPhoto��jpg";
		if (!dfi.getName().trim().equals("")) {
			String fileName = user_id + "_" + FilenameUtils.getName(dfi.getName());
			String filepath=RealPath
					 + System.getProperty("file.separator") //��ȡϵͳ�ļ��ָ���
					 + fileName;
			fileURL = "Upload/Photos/" + fileName;
			dfi.write(new File(filepath));
		}
		return fileURL;
	}
}
