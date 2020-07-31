package com.kh.team.sjy.persitence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.AreaCampingNameVo;



@Repository
public class AreaCampingNameDaoImpl implements AreaCampingNameDao {
	
	private static final String NAMESPACE="mappers.AreaCampingName-mapper."; 

	@Inject
	private SqlSession sqlSession;
	

	
	@Override
	public List<AreaCampingNameVo> areaCampingName() throws Exception {
		return sqlSession.selectList(NAMESPACE + "areaCampingName");
	}

	@Override
	public List<AreaCampingNameVo> areaCampingSi() throws Exception {
		return sqlSession.selectList(NAMESPACE + "areaCampingSi");
	}


	//캠핌장 후기(글쓰기)  1단 select option  
	@Override
	public List<String> getAreaCampingList(String area_si) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getAreaCampingList" ,  area_si);
	}
	//캠핌장 후기(글쓰기)  2단 select option  
	@Override
	public List<String> getCampingNameList(String area_si, String area_gu) throws Exception {
			Map<String, String> praramMap = new HashMap<>();
			praramMap.put("area_si", area_si);
			praramMap.put("area_gu", area_gu);
			return sqlSession.selectList(NAMESPACE + "getCampingNameList" , praramMap);
	}

	@Override
	public List<String> campingNamesList() throws Exception {
				return sqlSession.selectList(NAMESPACE +"campingNamesList");
	}

	@Override
	public List<String> campingAreaSiNamesList(String area_si) throws Exception {
		return sqlSession.selectList(NAMESPACE +"campingAreaSiNamesList" , area_si);
	}

	@Override
	public List<AreaCampingNameVo> updateCampingAreaSi() throws Exception {
		return sqlSession.selectList(NAMESPACE +"updateCampingAreaSi");
	}

	
	
	//캠핑장 후기(수정) 1단 select option
	@Override
	public List<String> updateGetAreaCampingList(String area_si) throws Exception {
		return sqlSession.selectList(NAMESPACE + "updateGetAreaCampingList" , area_si);
	}
	//캠핑장 후기(수정) 2단 select option
	@Override
	public List<String> updateGetCampingNameList(String area_si, String area_gu) throws Exception {
		Map<String, String> praramMap = new HashMap<>();
		praramMap.put("area_si", area_si);
		praramMap.put("area_gu", area_gu);
		return sqlSession.selectList(NAMESPACE + "updateGetCampingNameList" , praramMap);
	}



	





















}
