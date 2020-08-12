package com.kh.team.ksk.persistence;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.MyReviewPagingDto;

@Repository
public class BusinessDaoImpl implements BusinessDao {
	private static final String NAMESPACE = "mappers.business-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void campDelete(int camp_no) throws Exception {
		sqlSession.delete(NAMESPACE + "campDelete", camp_no);
	}

	@Override
	public List<CampVo> myCampList(MyReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "myCampList", pagingDto);
	}

	@Override
	public CampVo selectMyCamp(int camp_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "myCampList", camp_no);
	}

	@Override
	public int getCount(MyReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
	}
	
	//예약 갯수
	@Override
	public int getReservationCount(MyReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getReservationCount", pagingDto);
	}

	//나의 예약조회
	@Override
	public List<ReservationVo> campReservation(MyReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "campReservation",pagingDto);
	}


}
