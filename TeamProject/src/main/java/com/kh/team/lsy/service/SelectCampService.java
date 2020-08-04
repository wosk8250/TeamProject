package com.kh.team.lsy.service;

import java.util.List;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingLocationVo;
import com.kh.team.domain.CampRecommendVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.UserVo;

public interface SelectCampService {
	
	public List<AreaCampLocationVo> campSelect() throws Exception;
	
	public List<String> locationArea(String camp_location) throws Exception;
	
	public List<CampVo> campList(PagingDto pagingDto) throws Exception;
	
	public CampVo campingContent(int camp_no) throws Exception;
	
	public int pageCount(PagingDto pagingDto) throws Exception;
	
	public List<CampVo> searchList(String camp_area, String camp_location) throws Exception;
	
	public void recommend(int camp_no) throws Exception;
	
	public CampRecommendVo recommendCheck(String user_id) throws Exception;
	
	public void recommendInsert(CampRecommendVo campRecommendVo) throws Exception; 
	
	public List<String> areaLocationSelect(String camp_location) throws Exception;
	
}
