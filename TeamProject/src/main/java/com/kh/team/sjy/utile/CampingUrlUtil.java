package com.kh.team.sjy.utile;

import com.kh.team.domain.myReviewPagingDto;

public class CampingUrlUtil {
	public static String modifyPagingUrl(String url, myReviewPagingDto pagingDto, int review_no){
		url += "/";
		url += "" + review_no;
		url += "?page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
//		url += "&searchCnd=" + pagingDto.getSearchCnd();
//		url += "&textReview=" + pagingDto.getTextReview();
		return url;
	}
	
	//글 삭제 
	public static String deletePagingUrl(String url, myReviewPagingDto pagingDto) {
		url += "?";
		url += "&page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
		url += "&searchCnd=" + pagingDto.getSearchCnd();
		url += "&textReview=" + pagingDto.getTextReview();
		return url;
	}
}
