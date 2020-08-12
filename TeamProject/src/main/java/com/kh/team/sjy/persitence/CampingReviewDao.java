package com.kh.team.sjy.persitence;

import java.util.List;


import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.MyReviewPagingDto;

public interface CampingReviewDao {
	
	//캠핑후기  목록 
	public List<ReviewVo> campingReviewList() throws Exception;
	
	//파일 조회
	public List<FilesVo> filesList(String table_name) throws Exception;
	// (캠핑장 후기 내용)이미지 보여주기  filesNo(파일번호)
	public List<FilesVo> filesNoFilesList(int files_no) throws Exception;
	
	
	//캠핑장 후기 글쓰기
	public void campingReviewInsertRun(ReviewVo reviewVo)throws Exception;
	
	// 캠핑장후기 (file_no , review_no)비교
	public int campingTitleSearch(String review_title) throws Exception;
	
	//캠핑장 후기 이미지 입력
	public void campingReviewFileInsertRun(FilesVo filesVo)throws Exception;
	
	// 캠핑장 후기 내용  보기
	public ReviewVo selectReview(int review_no)throws Exception;
	
	//(캠핑장 후기 내용)이미지 보여주기
	public FilesVo selectReviewFileImg(int files_no)throws Exception;
	
	//캠핑장 후기 수정 글 내용
	public ReviewVo campingReviewModifyForm(int review_no)throws Exception;
	//캠핑장 후기 수정 글 처리
	public void campingReviewModifyRun(ReviewVo reviewVo)throws Exception;
	// 캠핑장 후기 수정 파일 조회
	public List<FilesVo> modifyFileList(String table_name) throws Exception;
	// 캠핑장 후기 수정 이미지 입력
	public void campingFileInsertRun(FilesVo filesVo) throws Exception;
	
	//캠핑장 후기 삭제
	public void campingReviewDelete(int review_no)throws Exception;
	
	//캠핑장 후기 조회수
	public void campingReviewView(int review_no)throws Exception;
	
	//캠핑장 후기 게시물 개수 
	public int campingReviewListCount(MyReviewPagingDto myReviewPagingDto)throws Exception;
	
	//캠핑장 후기 페이징
	public List<ReviewVo> campingReviewListPage(MyReviewPagingDto myReviewPagingDto)throws Exception;
	
	//campingReviewCampNo
	public int campingReviewCampNo(String camp_name)throws Exception;
	

	
	
}	
