package com.kh.team.sjy.persitence;

import java.util.List;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;

public interface CampingFaqDao {

	
	public FaqVo selectByfaq(int faq_no) throws Exception;
	
	//자주묻는 질문 뷰카운트
	public void faqViewCount(int faq_no) throws Exception;
	
	//자주묻는 질문 게시물 갯수
	public int campingFaqListCount(myReviewPagingDto myReviewPagingDto) throws Exception;
	// 자주묻는 질문 페이징
	public List<FaqVo> faqListPage(myReviewPagingDto myReviewPagingDto) throws Exception;
	
}
