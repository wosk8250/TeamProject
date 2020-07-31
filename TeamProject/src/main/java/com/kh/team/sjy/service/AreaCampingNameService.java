package com.kh.team.sjy.service;

import java.util.List;





public interface AreaCampingNameService {
	
	//캠핌장 후기(글쓰기)  1단 select option  
	public List<String> getAreaCampingList(String area_si)throws Exception;
	//캠핌장 후기(글쓰기)  2단 select option  
	public List<String> getCampingNameList(String area_si, String area_gu)throws Exception;
	
	public List<String> campingNamesList()throws Exception;
	
	public List<String> campingAreaSiNamesList(String area_si)throws Exception;
	
	//수정 캠핌장 후기(글쓰기)  1단 select option  
	public List<String> updateGetAreaCampingList(String area_si)throws Exception;
	//수정 캠핌장 후기(글쓰기)  2단 select option  
	public List<String> updateGetCampingNameList(String area_si, String area_gu)throws Exception;
	

	
	
}
