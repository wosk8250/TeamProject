package com.kh.team.ksk.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.ksk.persistence.UserDao;

@Repository
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;

	// 회원가입
	@Override
	public void insertUser(UserVo userVo) throws Exception {
		userDao.insertUser(userVo);
	}

	// 로그인, 비밀번호 체크
	@Override
	public boolean checkByIdAndPw(String user_id, String user_pw) throws Exception {
		UserVo userVo = userDao.checkByIdAndPw(user_id, user_pw);
		if (userVo == null) {
			return false;
		}
		return true;
	}

	// admin 체크
	@Override
	public String checkAdmin(String user_id) throws Exception {
		UserVo userVo = userDao.checkAdmin(user_id);
		String checkAdmin = userVo.getAdmin();
		return checkAdmin;
	}

	// 회원정보 보기
	@Override
	public UserVo profile(String user_id) throws Exception {
		return userDao.profile(user_id);
	}

	// 회원정보 수정
	@Override
	public void updateInfo(UserVo userVo) throws Exception {
		userDao.updateInfo(userVo);
	}

	// 아이디 중복 체크
	@Override
	public UserVo checkId(String user_id) throws Exception {
		return userDao.checkId(user_id);
	}

	// 비밀번호 수정
	@Override
	public void updatePw(String user_id, String new_pw) throws Exception {
		userDao.updatePw(user_id, new_pw);
	}

	// 회원탈퇴
	@Override
	public void secessionUser(String user_id) throws Exception {
		userDao.secessionUser(user_id);
	}

	// 내가 쓴 리뷰
	@Override
	public List<ReviewVo> myReviewList(myReviewPagingDto pagingDto) throws Exception {
		List<ReviewVo> list = userDao.myReviewList(pagingDto);
		return list;
	}

	// 리뷰 갯수
	@Override
	public int getCount(myReviewPagingDto pagingDto) throws Exception {
		return userDao.getCount(pagingDto);
	}
	
	// 예약 갯수
	@Override
	public int getReservationCount(myReviewPagingDto pagingDto) throws Exception {
		return userDao.getReservationCount(pagingDto);
	}

	// 회원 정지
	@Override
	public String getStopDate(String user_id) throws Exception {
		return userDao.getStopDate(user_id);
	}

	// 정지해제 날짜
	@Override
	public void stopUserBlock(String user_id) throws Exception {
		userDao.stopUserBlock(user_id);
	}
	
	//유저 벌점 조회
	@Override
	public List<DemeritVo> userDemerit(String user_id) throws Exception {
		return userDao.userDemerit(user_id);
	}

	//비밀번호 찾기
	@Override
	public boolean findPw(String user_id, String user_email) throws Exception {
		UserVo userVo = userDao.findPw(user_id, user_email);
		if (userVo == null) {
			return false;
		}
		return true;
	}

	//나의 예약조회
	@Override
	public List<ReservationVo> myReservation(myReviewPagingDto pagingDto) throws Exception {
		return userDao.myReservation(pagingDto);
	}

}