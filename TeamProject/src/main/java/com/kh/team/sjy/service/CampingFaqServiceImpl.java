package com.kh.team.sjy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampingFaqDao;

@Service
public class CampingFaqServiceImpl implements CampingFaqService {
	
	@Inject
	private CampingFaqDao campingFaqDao;

	@Override
	public int campingFaqListCount(myReviewPagingDto myReviewPagingDto) throws Exception {
		return campingFaqDao.campingFaqListCount(myReviewPagingDto);
	}

	@Override
	public List<FaqVo> faqListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return campingFaqDao.faqListPage(myReviewPagingDto);
	}

}
