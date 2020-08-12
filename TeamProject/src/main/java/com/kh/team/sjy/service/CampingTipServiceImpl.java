package com.kh.team.sjy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.sjy.persitence.CampingTipDao;

@Service
public class CampingTipServiceImpl implements CampingTipService {

	@Inject
	private CampingTipDao campingTipDao;
	
	@Override
	public List<CampingTipVo> campingTipList() throws Exception {
		return campingTipDao.campingTipList();
	}
	
	@Override
	public List<FilesVo> filesList(String table_name) throws Exception {
		return campingTipDao.filesList(table_name);
	}

	@Override
	public List<FilesVo> filesNoFilesList(int files_no) throws Exception {
		return campingTipDao.filesNoFilesList(files_no);
	}

	//캠핑장 수칙 게시물 개수 
	@Override
	public int campingTipListCount(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return campingTipDao.campingTipListCount(myReviewPagingDto);
	}

	@Override
	public List<CampingTipVo> campingTipListPage(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return campingTipDao.campingTipListPage(myReviewPagingDto);
	}

	



}
