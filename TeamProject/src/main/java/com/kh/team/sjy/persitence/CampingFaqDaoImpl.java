package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.MyReviewPagingDto;


@Repository
public class CampingFaqDaoImpl implements CampingFaqDao {
	
	private static final String NAMESPACE="mappers.campingFaq-mapper."; 
	
	@Inject
	private SqlSession sqlSession;


	@Override
	public FaqVo selectByFaq(int faq_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectByFaq", faq_no);
	}

	
	//자주묻는 질문 뷰카운트
	@Override
	public void faqViewCount(int faq_no) throws Exception {
		sqlSession.update(NAMESPACE + "faqViewCount", faq_no);

	}
	//자주묻는 질문 게시물 갯수
	@Override
	public int campingFaqListCount(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingFaqListCount" , myReviewPagingDto );
	}

	//페이징
	@Override
	public List<FaqVo> faqListPage(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "faqListPage" , myReviewPagingDto);
	}

}
