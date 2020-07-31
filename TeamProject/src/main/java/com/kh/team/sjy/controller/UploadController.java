package com.kh.team.sjy.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.team.ljh.utile.FileUploadUtil;
import com.kh.team.sjy.service.CampingReviewFileService;

@RestController
@RequestMapping(value="/upload")
public class UploadController {

	
	@Resource
	private String uploadPath;
	@Inject
	private CampingReviewFileService campingReviewFileService;

	@RequestMapping(value="/campingImage" ,method=RequestMethod.POST)
	public String campingImage(MultipartFile file) throws Exception {
		String originalName = file.getOriginalFilename();
		String dirPath = FileUploadUtil.uploadFile(uploadPath, originalName, file.getBytes()).replace("\\", "/");
		return dirPath;
	}
	
	@RequestMapping(value="/displayCampingImg",method = RequestMethod.GET)
	public byte[] displayCampingImg(@RequestParam("fileName") String fileName) throws Exception{
		String filePath = uploadPath + File.separator + fileName;
		String rFilePath = filePath.replace("/", "\\");
		FileInputStream fis = new FileInputStream(rFilePath);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
		
		return bytes;
		
	}
	
	@RequestMapping(value="/deleteCampingFile", method =RequestMethod.GET)
	public void deleteCampingFile(String filename) throws Exception{
		String serverPath = uploadPath + File.separator + filename;
		String front = filename.substring(0, filename.lastIndexOf("/") + 1);
		String rear = filename.substring(filename.lastIndexOf("/") + 1);
		String smServerPath = uploadPath + File.separator + front + "sm_" + rear;
		File f = new File(serverPath);
		f.delete();
		File f2 = new File(smServerPath);
		f2.delete();
	}
	@RequestMapping(value="/deleteCampingModifyFile" , method = RequestMethod.GET)
	public void deleteCampingModifyFile(String filename)throws Exception{
		campingReviewFileService.deleteFile(filename);
	}
}
