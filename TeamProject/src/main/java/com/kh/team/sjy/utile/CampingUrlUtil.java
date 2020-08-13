package com.kh.team.sjy.utile;

import com.kh.team.domain.MyReviewPagingDto;

public class CampingUrlUtil {
	public static String modifyPagingUrl(String url, MyReviewPagingDto pagingDto, int review_no){
		url += "/";
		url += "" + review_no;
		url += "?page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
//		url += "&searchCnd=" + pagingDto.getSearchCnd();
//		url += "&textReview=" + pagingDto.getTextReview();
		return url;
	}
	
	//글 삭제 
	public static String deletePagingUrl(String url, MyReviewPagingDto pagingDto) {
		url += "?";
		url += "&page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
		url += "&searchCnd=" + pagingDto.getSearchCnd();
		url += "&textReview=" + pagingDto.getTextReview();
		return url;
	}
}
