package com.kh.team.ljh.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kh.team.ljh.persistence.FileDao;

@Repository
public class FileServiceImpl implements FileService {

	@Inject
	private FileDao fileDao;
	
	@Override
	public void deleteFile(String files) throws Exception {
		fileDao.deleteFile(files);
	}

}
