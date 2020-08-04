package com.kh.team.sjy.persitence;

import java.util.List;

import com.kh.team.domain.CampingTalkVo;

public interface CampingToolTalkDao {

	//캠핑장비 게시판
	public List<CampingTalkVo> campingToolTalk() throws Exception;
	
	//캠핑장비 게시글 보기
	public CampingTalkVo selectCampingToolTalk(int campingtalk_no)throws Exception;
	
	//조회수
	public void campingToolTalkView(int campingtalk_no)throws Exception;
	
}
