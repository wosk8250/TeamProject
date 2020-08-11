package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.myReviewPagingDto;

@Repository
public class CampingTipDaoImpl implements CampingTipDao {
	
	private static final String NAMESPACE="mappers.campingTip-mapper."; 
	
	@Inject
	private SqlSession sqlSession;

	
	//캠핑장 수칙 목록 
	@Override
	public List<CampingTipVo> campingTipList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "campingTipList");
	}

	// 캠핑장 수칙 내용  보기
	@Override
	public CampingTipVo singleContentsCampingTip(int campingtip_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "singleContentsCampingTip", campingtip_no);
	}
	
	// 조회수
	@Override
	public void updateCampingTipView(int campingtip_no) throws Exception {
		sqlSession.update(NAMESPACE +"updateCampingTipView", campingtip_no);
		
	}
	//파일 조회
	@Override
	public List<FilesVo> filesList(String table_name) throws Exception {
		return sqlSession.selectList(NAMESPACE +"filesList" , table_name);
	}
	//(캠핑장 수칙 ) 이미지 보여주기  filesNoFilsList(파일번호 조회)
	@Override
	public List<FilesVo> filesNoFilesList(int files_no) throws Exception {
		return sqlSession.selectList(NAMESPACE +"filesNoFilesList" , files_no);
	}

	// 캠핑장 수칙 게시물 개수 
	@Override
	public int campingTipListCount(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingTipListCount", myReviewPagingDto);
	}

	@Override
	public List<CampingTipVo> campingTipListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE +"campingTipListPage" , myReviewPagingDto);
	}



}
