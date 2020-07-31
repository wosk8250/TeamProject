package com.kh.team.sjy.persitence;

import java.util.List;


import com.kh.team.domain.CampingTipVo;

public interface CampingTipDao {

	//캠핑장 수칙 목록 
	public List<CampingTipVo> campingTipList()throws Exception;
	// 캠핑장 수칙 내용  보기
	public CampingTipVo singleContentsCampingTip(int campingtip_no)throws Exception;
	// 조회수
	public void updateCampingTipView(int campingtip_no ) throws Exception;
	
}
