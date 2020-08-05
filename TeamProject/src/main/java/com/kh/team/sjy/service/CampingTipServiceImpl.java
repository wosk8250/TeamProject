package com.kh.team.sjy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.myReviewPagingDto;
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

	@Override
	public int campingTipListCount() throws Exception {
		return campingTipDao.campingTipListCount();
	}

	@Override
	public List<CampingTipVo> campingTipListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return campingTipDao.campingTipListPage(myReviewPagingDto);
	}

	@Override
	public List<CampingTipVo> campingTipSearch(String campingtip_title) throws Exception {
		return campingTipDao.campingTipSearch(campingtip_title);
	}



}
