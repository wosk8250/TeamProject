package com.kh.team.ksk.persistence;


import java.util.List;

import com.kh.team.domain.CampVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.MyReviewPagingDto;

public interface BusinessDao {
	
	// 캠핑장 삭제
	public void campDelete(int camp_no) throws Exception;

	// 캠핑장 조회 페이징
	public List<CampVo> myCampList(MyReviewPagingDto pagingDto) throws Exception;
	
	// 캠핑장 선택
	public CampVo selectMyCamp(int camp_no) throws Exception;
	//캠핑장 카운트
	public int getCount(MyReviewPagingDto pagingDto) throws Exception;
	
	//예약 갯수
	public int getReservationCount(MyReviewPagingDto pagingDto) throws Exception;
	
	//나의 예약 조회
	public List<ReservationVo> campReservation(MyReviewPagingDto pagingDto)throws Exception;
	
}
