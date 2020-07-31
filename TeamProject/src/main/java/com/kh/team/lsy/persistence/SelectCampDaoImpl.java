package com.kh.team.lsy.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.PagingDto;

@Repository
public class SelectCampDaoImpl implements SelectCampDao {

	private final String NAMESPACE = "mappers.main-mapper.";
	
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

}
