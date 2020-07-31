package com.kh.team.sjy.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kh.team.sjy.persitence.CampingReviewFileDao;

@Repository
public class CampingReviewFileServiceImpl implements CampingReviewFileService {

	@Inject
	private  CampingReviewFileDao campingReviewFileDao;
	@Override
	public void deleteFile(String files) throws Exception {
		campingReviewFileDao.deleteFile(files);

	}

}
