package com.kh.team.sjy.persitence;

import java.util.List;

import com.kh.team.domain.AreaCampingNameVo;


public interface AreaCampingNameDao {
	
	//3단 select option (캠핑장 )
	public List<AreaCampingNameVo> areaCampingName() throws Exception;  
	
	//1단 select option  ( 시 , 도(@@북도 ,@@남도 ) )
	public List<AreaCampingNameVo> areaCampingSi() throws Exception;
	
	

	//캠핌장 후기(글쓰기)  1단 select option  
	public List<String> getAreaCampingList(String area_si) throws Exception;
	//캠핌장 후기(글쓰기)  2단 select option  
	public List<String> getCampingNameList(String area_si, String area_gu) throws Exception;
	
	public List<String> campingNamesList () throws Exception;
	
	public List<String> campingAreaSiNamesList (String area_si) throws Exception;
	
	public List<AreaCampingNameVo> updateCampingAreaSi()throws Exception;
	
	
	//캠핑장 후기(수정) 1단 select option
	public List<String> updateGetAreaCampingList(String area_si) throws Exception; 
	
	//캠핑장 후기(수정) 2단 select option
	public List<String> updateGetCampingNameList(String area_si, String area_gu)throws Exception;
	

	
	
	

	
}
