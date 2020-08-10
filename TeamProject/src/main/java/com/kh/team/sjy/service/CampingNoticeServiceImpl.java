package com.kh.team.sjy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampNoticeDao;

@Service
public class CampingNoticeServiceImpl implements CampingNoticeService {

	@Inject
	private CampNoticeDao campNoticeDao;
	
	@Override
	public int campingNoticeListCount(myReviewPagingDto myReviewPagingDto) throws Exception {
		return campNoticeDao.campingNoticeListCount(myReviewPagingDto);
	}

	@Override
	public List<CampNoticeVo> noticeListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return campNoticeDao.noticeListPage(myReviewPagingDto);
	}

}
