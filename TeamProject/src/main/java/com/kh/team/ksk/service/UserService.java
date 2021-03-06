package com.kh.team.ksk.service;

import java.util.List;

import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.MyReviewPagingDto;

public interface UserService {

	// 회원가입
	public void insertUser(UserVo userVo) throws Exception;

	// 로그인, 비밀번호 체크
	public boolean checkByIdAndPw(String user_id, String user_pw) throws Exception;

	// admin 체크
	public String checkAdmin(String user_id) throws Exception;

	// 회원 정보보기
	public UserVo profile(String user_id) throws Exception;

	// 회원정보 수정
	public void updateInfo(UserVo userVo) throws Exception;

	// 아이디 중복체크
	public UserVo checkId(String user_id) throws Exception;

	// 비밀번호 수정
	public void updatePw(String user_id, String new_pw) throws Exception;

	// 회원탈퇴
	public void secessionUser(String user_id) throws Exception;

	// 내가 쓴 리뷰
	public List<ReviewVo> myReviewList(MyReviewPagingDto pagingDto) throws Exception;

	// 리뷰 갯수
	public int getCount(MyReviewPagingDto pagingDto) throws Exception;
	
	// 예약 갯수
	public int getReservationCount(MyReviewPagingDto pagingDto) throws Exception;

	// 회원 정지날짜
	public String getStopDate(String user_id) throws Exception;
	
	//회원 정지해제
	public void stopUserBlock(String user_id) throws Exception;
	
	//유저 벌점 조회
	public List<DemeritVo> userDemerit(String user_id) throws Exception;
	
	//비번찾기
	public boolean findPw(String user_id, String user_email) throws Exception;
	
	//나의 예약 조회
	public List<ReservationVo> myReservation(MyReviewPagingDto pagingDto)throws Exception;

	//예약취소
	public void cancelReservation(String startdate, String user_id) throws Exception;
}
