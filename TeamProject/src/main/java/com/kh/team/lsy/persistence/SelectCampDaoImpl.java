package com.kh.team.lsy.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampJoinVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingLocationVo;
import com.kh.team.domain.CampRecommendVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.domain.SearchDto;
import com.kh.team.domain.ReviewVo;

@Repository
public class SelectCampDaoImpl implements SelectCampDao {

	private static final String NAMESPACE = "mappers.main-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<AreaCampLocationVo> campSelect() throws Exception {
		List<AreaCampLocationVo> list =  sqlSession.selectList(NAMESPACE + "campSelect");
		return list; 
	}

	@Override
	public List<String> locationArea(String camp_location) throws Exception {
		return sqlSession.selectList(NAMESPACE + "locationArea", camp_location);
	}

	@Override
	public List<CampVo> campList(PagingDto pagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "campList", pagingDto);
	}

	@Override
	public CampVo campingContent(int camp_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingContent" , camp_no);
	}

	@Override
	public int pageCount(PagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "pageCount", pagingDto);
	
	}
	@Override
	public List<CampVo> searchList(String camp_area, String camp_location ,PagingDto pagingDto) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("pagingDto", pagingDto);
		paramMap.put("camp_area", camp_area);
		paramMap.put("camp_location", camp_location);
		return sqlSession.selectList(NAMESPACE + "searchList", paramMap);
	}

	@Override
	public void viewcnt(int camp_no) throws Exception {
		sqlSession.update(NAMESPACE + "viewcnt", camp_no);
	}

	@Override
	public void recommend(int camp_no) throws Exception {
		sqlSession.update(NAMESPACE + "recommend", camp_no);
	}

	@Override
	public void recommendInsert(CampRecommendVo campRecommendVo) throws Exception {
		sqlSession.insert(NAMESPACE + "recommendInsert", campRecommendVo);
	}

	@Override
	public CampRecommendVo recommendCheck(CampRecommendVo campRecommendVo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "recommendCheck", campRecommendVo);
	}

	@Override
	public List<String> areaLocationSelect(String camp_location) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "areaLocationSelect", camp_location);
	}

	@Override
	public List<ReviewVo> reviewTop5() throws Exception {
		return sqlSession.selectList(NAMESPACE + "reviewTop5");
	}

	@Override
	public List<CampNoticeVo> noticeTop5() throws Exception {
		return sqlSession.selectList(NAMESPACE + "noticeTop5");
	}

	@Override
	public List<CampingTipVo> tipTop5() throws Exception {
		return sqlSession.selectList(NAMESPACE + "tipTop5");
	}

	@Override
	public List<FaqVo> faqTop5() throws Exception {
		return sqlSession.selectList(NAMESPACE + "faqTop5");
	}

	@Override
	public List<CampVo> recommendTop10() throws Exception {
		return sqlSession.selectList(NAMESPACE + "recommendTop10");
	}

	@Override
	public List<AmenitiesVo> amenitiesList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "amenitiesList");
	}

	//메인페이지 -> 검색 페이지
	@Override
	public List<CampVo> mainSearchList(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "mainSearchList", myReviewPagingDto);
	}

	@Override
	public int SearchCount(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "SearchCount", myReviewPagingDto);
	}

	

	
}
