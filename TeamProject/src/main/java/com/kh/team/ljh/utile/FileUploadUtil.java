package com.kh.team.ljh.utile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class FileUploadUtil {

	public static String uploadFile(String uploadPath,String originalName,byte[] fileData) throws Exception {
		
		UUID uuid = UUID.randomUUID();
		String datePath = calcPath(uploadPath);
		boolean result = isImage(originalName);
		if(result == true) {
			
		String dirPath = datePath + File.separator + uuid + "_" + originalName;
		String filePath = uploadPath + File.separator + dirPath;
		File target = new File(filePath);
		FileCopyUtils.copy(fileData, target);
		makeThumbnail(filePath);
		
		return dirPath;
		}
		return "notImg";
	}
	
	public static boolean isImage(String fileName) {
		
		String extName = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
		if(extName.equals("JPG") || extName.equals("PNG") || extName.equals("GIF")) {
			return true;
		}
		
		return false;
	}
	
	public static void makeThumbnail(String filePath) throws Exception{
		int slashIndex = filePath.lastIndexOf("\\");
		String front = filePath.substring(0, slashIndex + 1);
		String rear = filePath.substring(slashIndex + 1);
		String thumbnailFile = front + "sm_" + rear;
		BufferedImage srcImg = ImageIO.read(new File(filePath));
		BufferedImage destImg = Scalr.resize(srcImg,    Scalr.Method.AUTOMATIC,Scalr.Mode.FIT_TO_HEIGHT,100);
		File thumbFile = new File(thumbnailFile);
		ImageIO.write(destImg, getFormatName(filePath), thumbFile);
				
	}
	
	private static String getFormatName(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		String extName = fileName.substring(dotIndex + 1);
		return extName.toUpperCase();
	}
	
	
	
	
	
	private static String calcPath(String uploadPath) throws Exception{
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		String dateString = year + File.separator 
				+ month + File.separator 
				+ date; 
		
		String datePath = uploadPath + File.separator + dateString;
				
		File f = new File(datePath); // 해당경로의 파일 "객체" 생성, 파일 생성x
		if (!f.exists()) { // 폴더 경로가 존재하지 않는다면
			f.mkdirs(); // 하위 경로 포함해서 생성
		}
		
		return dateString;
	}
	
}
