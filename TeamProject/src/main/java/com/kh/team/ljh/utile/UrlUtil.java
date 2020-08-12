package com.kh.team.ljh.utile;

import com.kh.team.domain.PagingDto;

public class UrlUtil {
	
	public static String makePagingUrl(String url, PagingDto pagingDto) {
		url += "?";
		url += "page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
		return url;
	}
	public static String makePagingUrl(String notice_no,String url, PagingDto pagingDto) {
		url += "/" + notice_no;
		url += "?page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
		return url;
	}
}
