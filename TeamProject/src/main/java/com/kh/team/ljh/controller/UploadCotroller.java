package com.kh.team.ljh.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.team.ljh.service.FileService;
import com.kh.team.ljh.utile.FileUploadUtil;


@RestController
@RequestMapping(value="/upload")
public class UploadCotroller {
	
	@Resource
	private String uploadPath;
	@Inject
	private FileService fileService;
	
	@RequestMapping(value="/image" ,method=RequestMethod.POST)
	public String uploadImage(MultipartFile file) throws Exception {
		String originalName = file.getOriginalFilename();
		String dirPath = FileUploadUtil.uploadFile(uploadPath, originalName, file.getBytes()).replace("\\", "/");
		return dirPath;
	}
	
	@RequestMapping(value="/displayImg",method = RequestMethod.GET)
	public byte[] displayImg(@RequestParam("fileName") String fileName) throws Exception{
		String filePath = uploadPath + File.separator + fileName;
		String rFilePath = filePath.replace("/", "\\");
		FileInputStream fis = new FileInputStream(rFilePath);
		byte[] bytes = IOUtils.toByteArray(fis);
		fis.close();
		
		return bytes;
		
	}
	
	@RequestMapping(value="/deleteFile", method =RequestMethod.GET)
	public void deleteFile(String filename) throws Exception{
		String serverPath = uploadPath + File.separator + filename;
		String front = filename.substring(0, filename.lastIndexOf("/") + 1);
		String rear = filename.substring(filename.lastIndexOf("/") + 1);
		String smServerPath = uploadPath + File.separator + front + "sm_" + rear;
		File f = new File(serverPath);
		f.delete();
		File f2 = new File(smServerPath);
		f2.delete();
	}
	
	@RequestMapping(value="/deleteModifyFile", method =RequestMethod.GET)
	public void deleteModifyFile(String filename) throws Exception{
		fileService.deleteFile(filename);
	}
	
	
}
