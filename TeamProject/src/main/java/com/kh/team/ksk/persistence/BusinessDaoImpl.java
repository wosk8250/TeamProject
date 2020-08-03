package com.kh.team.ksk.persistence;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampVo;
import com.kh.team.domain.myReviewPagingDto;

@Repository
public class BusinessDaoImpl implements BusinessDao {
	private static final String NAMESPACE = "mappers.business-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void campDelete(int camp_no) throws Exception {
		sqlSession.delete(NAMESPACE + "campDelete", camp_no);
	}

//	@Override
//	public List<CampVo> myCampList(String user_id) throws Exception {
//		return sqlSession.selectList(NAMESPACE + "myCampList", user_id);
//	}

	@Override
	public List<CampVo> myCampList(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "myCampList", pagingDto);
	}

	@Override
	public CampVo selectMyCamp(int camp_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "myCampList", camp_no);
	}

	@Override
	public int getCount(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
	}




}
