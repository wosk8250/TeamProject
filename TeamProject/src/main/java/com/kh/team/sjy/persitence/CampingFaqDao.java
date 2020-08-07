package com.kh.team.sjy.persitence;

import java.util.List;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;

public interface CampingFaqDao {
	//자주묻는 질문
	public List<FaqVo> faqList(myReviewPagingDto pagingDto) throws Exception;
	
	//자주묻는 질문 갯수
	public int getCount(myReviewPagingDto pagingDto) throws Exception;
	
	public FaqVo selectByfaq(int faq_no) throws Exception;
	
	//자주묻는 질문 뷰카운트
	public void faqViewCount(int faq_no) throws Exception;
}
