package com.kh.team.ksk.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampVo;
import com.kh.team.domain.myReviewPagingDto;
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
	public List<CampVo> mycampList(myReviewPagingDto pagingDto) throws Exception {
		return businessDao.myCampList(pagingDto);
	}

	@Override
	public CampVo selectMyCamp(int camp_no) throws Exception {
		return businessDao.selectMyCamp(camp_no);
	}

	@Override
	public int getCount(myReviewPagingDto pagingDto) throws Exception {
		return businessDao.getCount(pagingDto);
	}

	

}
