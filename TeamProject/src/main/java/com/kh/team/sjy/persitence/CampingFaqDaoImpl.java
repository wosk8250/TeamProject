package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;


@Repository
public class CampingFaqDaoImpl implements CampingFaqDao {
	
	private static final String NAMESPACE="mappers.campingFaq-mapper."; 
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<FaqVo> faqList(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "faqList",pagingDto);
	}

	@Override
	public int getCount(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
	}

	@Override
	public FaqVo selectByfaq(int faq_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectByfaq", faq_no);
	}

	
	//자주묻는 질문 뷰카운트
	@Override
	public void faqViewCount(int faq_no) throws Exception {
		sqlSession.update(NAMESPACE + "faqViewCount", faq_no);

	}

}
