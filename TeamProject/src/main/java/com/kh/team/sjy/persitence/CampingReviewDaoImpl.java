package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.MyReviewPagingDto;

@Repository
public class CampingReviewDaoImpl implements CampingReviewDao {
	
	private final String NAMESPACE = "mappers.campingReview-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void campingReviewInsertRun(ReviewVo reviewVo) throws Exception {
		sqlSession.insert(NAMESPACE + "campingReviewInsertRun" ,reviewVo);
		
	}
	@Override
	public int campingTitleSearch(String review_title) throws Exception {
		return sqlSession.selectOne(NAMESPACE +"campingTitleSearch", review_title);
	}
	@Override
	public void campingReviewFileInsertRun(FilesVo filesVo) throws Exception {
		System.out.println("filesVo:"+ filesVo);
		sqlSession.insert(NAMESPACE + "campingReviewFileInsertRun" ,filesVo);
		
	}
	@Override
	public List<ReviewVo> campingReviewList() throws Exception {
		return sqlSession.selectList(NAMESPACE +"campingReviewList");
		
	}
	//파일 조회
	@Override
	public List<FilesVo> filesList(String table_name) throws Exception {
		return sqlSession.selectList(NAMESPACE + "filesList", table_name);
	}
	// (캠핑장 후기 내용)이미지 보여주기  filesNoFilsList(파일번호 조회)
	@Override
	public List<FilesVo> filesNoFilesList(int files_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + "filesNoFilesList", files_no);
	}
	// 캠핑장 후기 내용  보기
	@Override
	public ReviewVo selectReview(int review_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectReview" , review_no);
	}
	@Override
	public FilesVo selectReviewFileImg(int files_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectReviewFileImg" , files_no);
	}
	//캠핑장 후기 삭제
	@Override
	public void campingReviewDelete(int review_no) throws Exception {
		sqlSession.update(NAMESPACE +"campingReviewDelete" , review_no);
		
	}
	//캠핑장 후기 수정폼
	@Override
	public ReviewVo campingReviewModifyForm(int review_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingReviewModifyForm" , review_no);
	}
	//캠핑장 후기 수정 처리
	@Override
	public void campingReviewModifyRun(ReviewVo reviewVo) throws Exception {
		System.out.println(reviewVo);
		sqlSession.update(NAMESPACE + "campingReviewModifyRun", reviewVo);
		
	}
	//캠핑장 후기 수정 이미지 조회
	@Override
	public List<FilesVo> modifyFileList(String table_name) throws Exception {
		return sqlSession.selectList(NAMESPACE + "modifyFileList", table_name);
	}
	//캠핑장 후기 수정 이미지 등록
	@Override
	public void campingFileInsertRun(FilesVo filesVo) throws Exception {
		sqlSession.insert(NAMESPACE + "campingFileInsertRun" ,filesVo);
		
	}
	//캠핑장 후기 조회수
	@Override
	public void campingReviewView(int review_no) throws Exception {
		sqlSession.update(NAMESPACE + "campingReviewView" , review_no);
		
	}
	//캠핑장 후기 게시물 개수 
	@Override
	public int campingReviewListCount(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE +"campingReviewListCount" ,myReviewPagingDto);
	}
	//캠핑장 후기 페이징
	@Override
	public List<ReviewVo> campingReviewListPage(MyReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE +"campingReviewListPage",myReviewPagingDto );
	}
	
	//campingReviewCampNo
	@Override
	public int campingReviewCampNo(String camp_name) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingReviewCampNo" ,  camp_name);
	}
	





}
