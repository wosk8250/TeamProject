package com.kh.team.ksk.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.myReviewPagingDto;

@Repository
public class UserDaoImpl implements UserDao {
	private static final String NAMESPACE = "mappers.user-mapper.";
	
	@Inject
	private SqlSession sqlSession;
	
	//회원가입
	@Override
	public void insertUser(UserVo userVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertUser", userVo);
	}
	
	//로그인, 비밀번호 체크
	@Override
	public UserVo checkByIdAndPw(String user_id, String user_pw) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("user_pw", user_pw);
		return sqlSession.selectOne(NAMESPACE + "checkByIdAndPw", paramMap);
	}

	//admin 체크
	@Override
	public UserVo checkAdmin(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "checkAdmin", user_id);
	}
	
	//회원 정보보기
	@Override
	public UserVo profile(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "profile", user_id);
	}
	
	//회원정보 수정
	@Override
	public void updateInfo(UserVo userVo) throws Exception {
		sqlSession.update(NAMESPACE + "updateInfo", userVo);
	}

	//아이디 중복 체크
	@Override
	public UserVo checkId(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "checkId", user_id);
	}

	//비밀번호 수정
	@Override
	public void updatePw(String user_id, String new_pw) throws Exception {
		System.out.println("user_id : " + user_id);
		System.out.println("new_pw : " + new_pw);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("new_pw", new_pw);
		sqlSession.update(NAMESPACE + "updatePw", paramMap);
	}

	//회원탈퇴
	@Override
	public void secessionUser(String user_id) throws Exception {
		sqlSession.delete(NAMESPACE + "secessionUser", user_id);
	}

	//내가 쓴 리뷰
	@Override
	public List<ReviewVo> myReviewList(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "myReviewList", pagingDto);
	}
	
	//리뷰 갯수
	@Override
	public int getCount(myReviewPagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
	}
	//회원 정지날짜
	@Override
	public String getStopDate(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getStopDate", user_id);
	}
	//회원 정지해제
	@Override
	public void stopUserBlock(String user_id) throws Exception {
		sqlSession.update(NAMESPACE + "stopUserBlock",user_id);
	}

	//유저 벌점 조회
	@Override
	public List<DemeritVo> userDemerit(String user_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + "userDemerit", user_id);
	}

	//비번찾기
	@Override
	public UserVo findPw(String user_id, String user_email) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("user_email", user_email);
		return sqlSession.selectOne(NAMESPACE + "findPw",paramMap);
	}
	
	
	
	
	


}

