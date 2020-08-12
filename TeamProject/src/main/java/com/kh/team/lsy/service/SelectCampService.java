package com.kh.team.lsy.service;

import java.util.List;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingLocationVo;
import com.kh.team.domain.CampRecommendVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.ReviewVo;

public interface SelectCampService {
	
	public List<AreaCampLocationVo> campSelect() throws Exception;
	
	public List<String> locationArea(String camp_location) throws Exception;
	
	public List<CampVo> campList(PagingDto pagingDto) throws Exception;
	
	public CampVo campingContent(int camp_no) throws Exception;
	
	public int pageCount(PagingDto pagingDto) throws Exception;
	
	public List<CampVo> searchList(String camp_area, String camp_location, PagingDto pagingDto) throws Exception;
	
	public void recommend(int camp_no) throws Exception;
	
	public CampRecommendVo recommendCheck(CampRecommendVo campRecommendVo) throws Exception;
	
	public void recommendInsert(CampRecommendVo campRecommendVo) throws Exception; 
	
	public List<String> areaLocationSelect(String camp_location) throws Exception;
	
	public List<AmenitiesVo> amenitiesList() throws Exception;
	
	//리뷰5개
	public List<ReviewVo> reviewTop5() throws Exception;
	//공지사항5개
	public List<CampNoticeVo> noticeTop5() throws Exception;
	//캠핑수칙5개
	public List<CampingTipVo> tipTop5() throws Exception;
	//질문5개
	public List<FaqVo> faqTop5() throws Exception;
	
	//추천수 높은 순 캠핑장 보기
	public List<CampVo> recommendTop10() throws Exception;
	
	
}
