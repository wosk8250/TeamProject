package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;

@Repository
public class CampNoticeDaoImpl implements CampNoticeDao {
	
	private static final String NAMESPACE="mappers.campNotice-mapper."; 
	
	@Inject
	private SqlSession sqlSession;

	//공지사항 목록
	@Override
	public List<CampNoticeVo> campNoticeList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "campNoticeList");
	}

	//공지사항 내용
	@Override
	public CampNoticeVo singleContentsCampNotice(int notice_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "singleContentsCampNotice", notice_no);
	}

	//조회수 
	@Override
	public void updateNoticeView(int notice_no) throws Exception {
		sqlSession.update(NAMESPACE + "updateNoticeView", notice_no );
		
	}
	//자주묻는 질문 리스트
	@Override
	public List<FaqVo> faqList(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "faqList",pagingDto);
	}
	

	@Override
	public int getCount(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
	}

	//자주묻는 질문 보기
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
