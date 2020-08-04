package com.kh.team.sjy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.team.domain.CommentVo;
import com.kh.team.sjy.persitence.ReviewCommentDao;

@Service
public class CampingReviewCommentSerivceImpl implements CampingReviewCommentSerivce {
	
	@Inject
	private ReviewCommentDao reviewCommentDao; 

	//댓글 목록
	@Override
	public List<CommentVo> reviewCommentList(int review_no) throws Exception {
		return reviewCommentDao.reviewCommentList(review_no);
	}
	//댓글 입력
	@Override
	public void reviewCommentInsert(CommentVo commentVo) throws Exception {
		reviewCommentDao.reviewCommentInsert(commentVo);

	}
	//댓글 삭제
	@Override
	public void reviewCommentDelete( int comment_no) throws Exception {
		reviewCommentDao.reviewCommentDelete(comment_no);
		
	}

}
