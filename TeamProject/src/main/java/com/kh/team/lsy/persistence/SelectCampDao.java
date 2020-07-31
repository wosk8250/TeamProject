package com.kh.team.lsy.persistence;

import java.util.List;

import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.PagingDto;

public interface SelectCampDao {

	public List<AreaCampLocationVo> campSelect() throws Exception;
	
	public List<String> locationArea(String camp_location) throws Exception;
	
	public List<CampVo> campList(PagingDto pagingDto) throws Exception;
	
	public CampVo campingContent(int camp_no) throws Exception;
	
	public int pageCount(PagingDto pagingDto) throws Exception;
	
} 
