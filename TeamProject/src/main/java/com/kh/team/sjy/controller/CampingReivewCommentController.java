package com.kh.team.sjy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.team.domain.CommentVo;
import com.kh.team.sjy.service.CampingReviewCommentSerivce;

@RestController
@RequestMapping("/comment")
public class CampingReivewCommentController {
	
	@Inject
	private CampingReviewCommentSerivce capmingReviewCommentSerivce;
	
	//댓글 목록
	@RequestMapping(value="/reviewCommentList/{review_no}" , method = RequestMethod.GET)
	public List<CommentVo> reviewCommentList(@PathVariable("review_no") int review_no )throws Exception{
		return capmingReviewCommentSerivce.reviewCommentList(review_no);
	
	}
	//댓글 입력
	@RequestMapping(value="/reviewCommentInsert", method = RequestMethod.POST)
	public String reviewCommentInsert(@RequestBody CommentVo commentVo, HttpServletRequest request)throws Exception{
		HttpSession httpSession =  request.getSession();
		String user_id = (String)httpSession.getAttribute("user_id");
		commentVo.setComment_id(user_id);
		System.out.println("reviewController, CommentInsert, commentVo:" + commentVo);
		capmingReviewCommentSerivce.reviewCommentInsert(commentVo);
		return "success";
	}
	
	//댓글 삭제
	@RequestMapping(value= "/reviewCommentDelete/{review_no}/{comment_no}" , method = RequestMethod.DELETE)
	public String reviewCommentDelete(@PathVariable("review_no") int review_no, @PathVariable("comment_no") int comment_no)throws Exception{
		System.out.println("/reviewCommentDelete, review_no:" + review_no);
		System.out.println("/reviewCommentDelete, comment_no:" + comment_no);
		capmingReviewCommentSerivce.reviewCommentDelete(comment_no);
		return "success";
	}

}
