package com.kh.team.lsy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
		selectCampDao.viewcnt(camp_no);
		return selectCampDao.campingContent(camp_no);
	}

	@Override
	public int pageCount(PagingDto pagingDto) throws Exception {
		return selectCampDao.pageCount(pagingDto);
	}

	@Override
	public List<CampVo> searchList(String camp_area, String camp_location) throws Exception {
		return selectCampDao.searchList(camp_area, camp_location);
	}

	@Override
	public void recommend(int camp_no) throws Exception {
		selectCampDao.recommend(camp_no);
	}

	@Override
	public void recommendInsert(CampRecommendVo campRecommendVo) throws Exception {
		selectCampDao.recommendInsert(campRecommendVo);
	}

	@Override
	public CampRecommendVo recommendCheck(String user_id) throws Exception {
		return selectCampDao.recommendCheck(user_id);
	}

	@Override
	public List<String> areaLocationSelect(String camp_location) throws Exception {
		return selectCampDao.areaLocationSelect(camp_location);
	}

	public List<ReviewVo> reviewTop5() throws Exception {
		return selectCampDao.reviewTop5();
	}

	@Override
	public List<CampNoticeVo> noticeTop5() throws Exception {
		return selectCampDao.noticeTop5();
	}

	@Override
	public List<CampingTipVo> tipTop5() throws Exception {
		return selectCampDao.tipTop5();
	}

	@Override
	public List<FaqVo> faqTop5() throws Exception {
		return selectCampDao.faqTop5();
	}

	@Override
	public List<CampVo> recommendTop10() throws Exception {
		return selectCampDao.recommendTop10();
	}

	@Override
	public List<AmenitiesVo> amenitiesList() throws Exception {
		return selectCampDao.amenitiesList();
	}
	

}
