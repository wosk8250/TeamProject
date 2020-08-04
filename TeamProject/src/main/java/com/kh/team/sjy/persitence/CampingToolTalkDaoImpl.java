package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampingTalkVo;

@Repository
public class CampingToolTalkDaoImpl implements CampingToolTalkDao {
	
	private static final String NAMESPACE="mappers.campingToolTalk-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	
	//캠핑장비 게시판
	@Override
	public List<CampingTalkVo> campingToolTalk() throws Exception {
		return sqlSession.selectList(NAMESPACE +"campingToolTalk");
	}

	//캠핑장비 게시글 보기
	@Override
	public CampingTalkVo selectCampingToolTalk(int campingtalk_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE +"selectCampingToolTalk", campingtalk_no );
	}
	
	//조회수
		@Override
		public void campingToolTalkView(int campingtalk_no) throws Exception {
			sqlSession.update(NAMESPACE +"campingToolTalkView", campingtalk_no);
			
		}

}
