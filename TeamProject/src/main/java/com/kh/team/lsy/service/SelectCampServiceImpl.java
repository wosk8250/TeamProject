package com.kh.team.lsy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.lsy.persistence.SelectCampDao;

@Repository
public class SelectCampServiceImpl implements SelectCampService {

	@Inject
	private SelectCampDao selectCampDao;

	@Override
	public List<AreaCampLocationVo> campSelect() throws Exception {
		return selectCampDao.campSelect();
	}

	@Override
	public List<String> locationArea(String camp_location) throws Exception {
		return selectCampDao.locationArea(camp_location);
	}

	@Override
	public List<CampVo> campList(PagingDto pagingDto) throws Exception {
		return selectCampDao.campList(pagingDto);
	}

	@Override
	public CampVo campingContent(int camp_no) throws Exception {
		return selectCampDao.campingContent(camp_no);
	}

	@Override
	public int pageCount(PagingDto pagingDto) throws Exception {
		return selectCampDao.pageCount(pagingDto);
	}

}
