package com.kh.team.sjy.persitence;

import java.util.List;

import com.kh.team.domain.CommentVo;

public interface ReviewCommentDao {

	//댓글 목록
	public List<CommentVo> reviewCommentList(int review_no)throws Exception;
	//댓글 입력
	public void reviewCommentInsert(CommentVo commentVo)throws Exception;

	//댓글 삭제
	public void reviewCommentDelete(int comment_no) throws Exception;
}
