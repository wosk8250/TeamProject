package com.kh.team.sjy.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.CommentVo;

@Repository
public class ReviewCommentDaoImpl implements ReviewCommentDao {
	
	private final String NAMESPACE = "mappers.reviewComment-mapper.";
	
	@Inject
	private SqlSession sqlSession;

	//댓글 목록
	@Override
	public List<CommentVo> reviewCommentList(int review_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + "reviewCommentList" , review_no);
	}

	//댓글 입력
	@Override
	public void reviewCommentInsert(CommentVo commentVo) throws Exception {
				sqlSession.insert(NAMESPACE + "reviewCommentInsert" , commentVo);

	}
	//댓글삭제
	@Override
	public void reviewCommentDelete(int comment_no) throws Exception {
		sqlSession.delete(NAMESPACE +"reviewCommentDelete",comment_no);
		
	}

}
