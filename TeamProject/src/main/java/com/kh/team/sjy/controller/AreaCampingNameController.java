package com.kh.team.sjy.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.kh.team.sjy.service.AreaCampingNameService;



@RestController
@RequestMapping("/areaCampingName")
public class AreaCampingNameController {	
	
	@Inject
     private  AreaCampingNameService areaCampingNameService; 
	

	// select option 첫번째 (전체/특별시or광역시/ 남도or북도)
	@RequestMapping(value="/getAreaCampingList/{area_si}", method= RequestMethod.GET)
	@ResponseBody
	public List<String> getAreaCampingList(@PathVariable("area_si") String area_si)throws Exception{
		System.out.println("area_si:"+ area_si);
		List<String> list = areaCampingNameService.getAreaCampingList(area_si);
		System.out.println("list:" + list);
		return list;
	}

	
	// select option 두번째 (특별시,광역시/ 남도,북도 +  @@시 /@@군)
	@RequestMapping(value="/getCampingNameList", method= RequestMethod.GET)
	@ResponseBody
	public List<String> getCampingNameList(String area_si, String area_gu)throws Exception{
		System.out.println(area_si);
		System.out.println(area_gu);
		List<String> list =areaCampingNameService.getCampingNameList(area_si, area_gu);
		System.out.println("list:"+ list);
		return list;
	}
	
	// 전체 캠핑장 검색 
	@RequestMapping(value="/campingNamesList" , method = RequestMethod.GET)
	@ResponseBody
	public List<String> campingNamesList()throws Exception{
		List<String> campinglist = areaCampingNameService.campingNamesList();
		System.out.println("campinglist:"+campinglist);
		return campinglist;
	}
	// (시 / @@남도, @@북도 )-전체 캠핑장 검색
	@RequestMapping(value="/campingAreaSiNamesList/{area_si}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> campingAreaSiNamesList(@PathVariable("area_si") String area_si)throws Exception{
		System.out.println("campingAreaSiNamesList/area_si:" + area_si);
		List<String> campingAreaSiNamesList = areaCampingNameService.campingAreaSiNamesList(area_si);
		System.out.println("campingAreaSiNamesList:" + campingAreaSiNamesList);
		
		return campingAreaSiNamesList;
	}
	
	//update select option 첫번째 (특별시or광역시/ 남도or북도)
	@RequestMapping(value = "/updateGetAreaCampingList/{area_si}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> updateGetAreaCampingList(@PathVariable("area_si") String area_si)throws Exception{
		System.out.println("update_area_si:" + area_si);
		List<String> updateFirstList = areaCampingNameService.updateGetAreaCampingList(area_si);
		System.out.println("updateList:"+ updateFirstList);
		return updateFirstList;
	}
	
	//update select option 두번째 (특별시or광역시/ 남도or북도 +  @@시 /@@군)
	
	
	@RequestMapping(value = "/updateGetCampingNameList", method = RequestMethod.GET)
	@ResponseBody
	public List<String> updateGetCampingNameList( String area_si, String area_gu) throws Exception{
		System.out.println("updateArea_si:"+area_si);
		System.out.println("updateArea_gu:"+area_gu);
		List<String> updateSecendList = areaCampingNameService.updateGetCampingNameList(area_si, area_gu);
		System.out.println("updateSecendList:"+ updateSecendList);
		return updateSecendList;
	}


}
