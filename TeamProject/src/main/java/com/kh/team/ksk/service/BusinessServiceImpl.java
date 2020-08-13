package com.kh.team.ksk.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.ksk.persistence.BusinessDao;

@Repository
public class BusinessServiceImpl implements BusinessService {
	
	@Inject
	private BusinessDao businessDao;

	@Override
	public void campDelete(int camp_no) throws Exception {
		businessDao.campDelete(camp_no);
	}

//	@Override
//	public List<CampVo> myCampList(String user_id) throws Exception {
//		return businessDao.myCampList(user_id);
//	}

	@Override
	public List<CampVo> mycampList(MyReviewPagingDto pagingDto) throws Exception {
		return businessDao.myCampList(pagingDto);
	}

	@Override
	public CampVo selectMyCamp(int camp_no) throws Exception {
		return businessDao.selectMyCamp(camp_no);
	}

	@Override
	public int getCount(MyReviewPagingDto pagingDto) throws Exception {
		return businessDao.getCount(pagingDto);
	}
	
	// 예약 갯수
	@Override
	public int getReservationCount(MyReviewPagingDto pagingDto) throws Exception {
		return businessDao.getReservationCount(pagingDto);
	}

	//나의 예약조회
	@Override
	public List<ReservationVo> campReservation(MyReviewPagingDto pagingDto) throws Exception {
		return businessDao.campReservation(pagingDto);
	}

}
