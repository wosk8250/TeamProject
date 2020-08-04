package com.kh.team.ksk.service;


import java.util.List;

import com.kh.team.domain.CampVo;
import com.kh.team.domain.myReviewPagingDto;

public interface BusinessService {

	// 캠핑장 삭제
	public void campDelete(int camp_no) throws Exception;

//	// 캠핑장 조회
//	public List<CampVo> myCampList(String user_id) throws Exception;

	// 캠핑장 조회 페이징
	public List<CampVo> mycampList(myReviewPagingDto pagingDto) throws Exception;
	
	// 캠핑장 선택
	public CampVo selectMyCamp(int camp_no) throws Exception;


	public int getCount(myReviewPagingDto pagingDto) throws Exception;
}
