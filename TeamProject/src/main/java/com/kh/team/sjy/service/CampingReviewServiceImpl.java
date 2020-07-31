package com.kh.team.sjy.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampingReviewDao;
@Transactional
@Service
public class CampingReviewServiceImpl implements CampingReviewService {
	
	@Inject
	private CampingReviewDao campingReivewDao;

	@Transactional
	@Override
	public void campingReviewInsertRun(ReviewVo reviewVo) throws Exception {
		String camp_name = reviewVo.getReview_campingname();
		int camp_no = campingReivewDao.campingReviewCampNo(camp_name);
		reviewVo.setReview_camp_no(camp_no);
		
		if(reviewVo.getFiles() != null) {
			String files[] = reviewVo.getFiles();
			String filename = files[0];
			int slashIndex = filename.lastIndexOf("/");
			String front = filename.substring(0, slashIndex + 1);
			String rear = filename.substring(slashIndex + 1);
			String thumbnailName = front + "sm_" + rear;
			reviewVo.setReview_img(thumbnailName);
			campingReivewDao.campingReviewInsertRun(reviewVo);
			 int camping_no=campingReivewDao.campingTitleSearch(reviewVo.getReview_title());
			for(int i =0; i < files.length; i++) {
				FilesVo filesVo = new FilesVo(camping_no,files[i],"review");
				campingReivewDao.campingReviewFileInsertRun(filesVo);
			}
			
		}else {
			reviewVo.setReview_img("사진없음");
		}
		

	}

//	@Override
//	public int campingTitleSearch(String review_title) throws Exception {
//				return campingReivewDao.campingTitleSearch(review_title);
//	}

	@Override
	public List<ReviewVo> campingReviewList() throws Exception {
		return campingReivewDao.campingReviewList();
	}

	@Override
	public List<FilesVo> filesList(String table_name) throws Exception {
		return campingReivewDao.filesList(table_name);
	}

	@Override
	public List<FilesVo> filesNoFilesList(int files_no) throws Exception {
		return campingReivewDao.filesNoFilesList(files_no);
	}

	//캠핑장 후기 삭제 처리
	@Override
	public void campingReviewDelete(int review_no) throws Exception {
		campingReivewDao.campingReviewDelete(review_no);
		
	}
	
	//캠핑장 후기 수정 폼
	@Override
	public ReviewVo campingReviewModifyForm(int review_no) throws Exception {
		return campingReivewDao.campingReviewModifyForm(review_no);
	}
	
	//캠핑장 후기 수정 처리
	@Transactional
	@Override
	public void campingReviewModifyRun(ReviewVo reviewVo) throws Exception {
		if(reviewVo.getFiles() != null) {
			String files[] = reviewVo.getFiles();
			String filename =files[0];
			int slashIndex = filename.lastIndexOf("/");
			String front = filename.substring(0, slashIndex + 1);
			String rear = filename.substring(slashIndex + 1);
			String thumbnailName = front + "sm_" + rear;
			reviewVo.setReview_img(thumbnailName);
			if(files != null) {
				for( int i =0; i < files.length; i++) {
					FilesVo filesVo = new FilesVo(reviewVo.getReview_no(), files[i], reviewVo.getTable_name());
					campingReivewDao.campingFileInsertRun(filesVo);
				}
			}
			
		}else {
			reviewVo.setReview_img("사진없음");
		}
		
		campingReivewDao.campingReviewModifyRun(reviewVo);
	}

	//캠핑장 후기 수정 이미지 조회
	@Override
	public List<FilesVo> modifyFileList(String table_name) throws Exception {
		
		return campingReivewDao.modifyFileList(table_name);
	}

	//캠핑장 후기 게시물 갯수 검색
	@Override
	public int campingReviewListCount() throws Exception {
		return campingReivewDao.campingReviewListCount();
	}

	@Override
	public List<ReviewVo> campingReviewListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return campingReivewDao.campingReviewListPage(myReviewPagingDto);
	}

	//캠핑장 후기 검색
	@Override
	public List<ReviewVo> campingReviewSearch(String review_title) throws Exception {
		return campingReivewDao.campingReviewSearch(review_title);
	}


	



}
