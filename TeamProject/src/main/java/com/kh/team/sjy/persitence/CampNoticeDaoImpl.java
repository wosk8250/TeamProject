package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.myReviewPagingDto;


@Repository
public class CampNoticeDaoImpl implements CampNoticeDao {
	
	private static final String NAMESPACE="mappers.campingNotice-mapper."; 
	
	@Inject
	private SqlSession sqlSession;

	//공지사항 목록
	@Override
	public List<CampNoticeVo> campNoticeList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "campNoticeList");
	}

	//공지사항 내용
	@Override
	public CampNoticeVo singleContentsCampNotice(int notice_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "singleContentsCampNotice", notice_no);
	}

	//조회수 
	@Override
	public void updateNoticeView(int notice_no) throws Exception {
		sqlSession.update(NAMESPACE + "updateNoticeView", notice_no );
		
	}
	//개수
	@Override
	public int campingNoticeListCount(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingNoticeListCount" , myReviewPagingDto);
	}
	//페이징
	@Override
	public List<CampNoticeVo> noticeListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "noticeListPage" , myReviewPagingDto );
	}


}
