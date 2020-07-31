package com.kh.team.sjy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.kh.team.sjy.persitence.AreaCampingNameDao;

@Service
public class AreaCampingNameServiceImpl implements AreaCampingNameService {
	
	@Inject
	private AreaCampingNameDao areaCampingNameDao;
	

	//캠핌장 후기(글쓰기)  1단 select option  
	@Override
	public List<String> getAreaCampingList(String area_si) throws Exception {
		return areaCampingNameDao.getAreaCampingList(area_si);
	}
	//캠핌장 후기(글쓰기)  2단 select option  
	@Override
	public List<String> getCampingNameList(String area_si, String area_gu) throws Exception {
		return areaCampingNameDao.getCampingNameList(area_si, area_gu);
	}

	@Override
	public List<String> campingNamesList() throws Exception {
		return areaCampingNameDao.campingNamesList();
	}

	@Override
	public List<String> campingAreaSiNamesList(String area_si) throws Exception {
		return areaCampingNameDao.campingAreaSiNamesList(area_si);
	}

	
	//수정 캠핌장 후기(글쓰기)  1단 select option  
	@Override
	public List<String> updateGetAreaCampingList(String area_si) throws Exception {
		return areaCampingNameDao.updateGetAreaCampingList(area_si);
	}
	//수정 캠핌장 후기(글쓰기)  2단 select option  
	@Override
	public List<String> updateGetCampingNameList(String area_si, String area_gu) throws Exception {
		return areaCampingNameDao.updateGetCampingNameList(area_si, area_gu);
	}
	







}
