package com.kh.team.ljh.service;

import java.util.List;
import java.util.Map;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.AreaCampingNameVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingTalkVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.DemeritCodeVo;
import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampNoticeDao;

public interface AdminService {
	// 사용자 조회
	public List<UserVo> userList() throws Exception;

	// 공지사항 조회
	public List<CampNoticeVo> noticeList() throws Exception;

	// 자주묻는 질문 조회
	public List<FaqVo> faqList() throws Exception;

	// 캠핑장 조회
	public List<CampVo> campList() throws Exception;

	// 캠핑장 글쓰기
	public void campInsertRun(CampVo campVo, AmenitiesVo amenitiesVo) throws Exception;

	// 캠핑장 수정 글 내용
	public CampVo campModifyForm(String camp_address) throws Exception;

	// 캠핑장 수정 글 처리
	public void campModifyRun(CampVo campVo) throws Exception;

	// 캠핑장 삭제 처리
	public void campDelete(int camp_no) throws Exception;

	// 캠핑수칙 조회
	public List<CampingTipVo> campingTipList() throws Exception;

	// 캠핑수칙 입력
	public void campingTipInsertRun(CampingTipVo campingTipVo) throws Exception;

	// 캠핑수칙 수정 글 내용
	public CampingTipVo campingTipModifyForm(String campingtip_title) throws Exception;

	// 캠핑수칙 수정 글 처리
	public void campingTipModifyRun(CampingTipVo campingTipVo) throws Exception;

	// 캠핑수칙 삭제 처리
	public void campingTipDelete(int campingtip_no) throws Exception;

	// 캠핑 이야기 조회
	public List<CampingTalkVo> campingTalkList() throws Exception;

	// 캠핑 이야기 삭제
	public void campingTalkDelete(int campingTalk_no) throws Exception;

	// 후기 조회
	public List<ReviewVo> reviewList() throws Exception;

	// 캠핑 후기 삭제
	public void reviewDelete(int review_no) throws Exception;

	// 캠핑장 파일 조회
	public List<FilesVo> filesList(String table_name) throws Exception;

	// 공지사항 작성처리
	public void noticeRun(CampNoticeVo campNoticeVo) throws Exception;

	// 공지사항 삭제처리
	public void noticeDeleteRun(int notice_no) throws Exception;

	// 공지사항 수정폼
	public CampNoticeVo noticeModifyForm(int notice_no) throws Exception;

	// 공지사항 수정처리
	public void noticeModifyRun(CampNoticeVo campNoticeVo) throws Exception;

	// 자주묻는질문 작성처리
	public void faqRun(FaqVo faqVo) throws Exception;

	// 자주묻는질문 수정폼
	public FaqVo faqModifyForm(int faq_no) throws Exception;

	// 자주묻는질문 수정처리
	public void faqModifyRun(FaqVo faqVo) throws Exception;

	// 자주묻는질문 삭제처리
	public void faqDeleteRun(int faq_no) throws Exception;

	// 캠핑장 페이징
	public List<CampVo> campListPage(myReviewPagingDto myReviewPagingDto) throws Exception;

	// 게시물 갯수 검색
	public int campPostsCount() throws Exception;
	// 삭제된 캠핑장 페이징
	public List<CampVo> blockCampListPage(myReviewPagingDto myReviewPagingDto) throws Exception;
	
	// 삭제된 캠핑장 갯수 검색
	public int blockCampPostsCount() throws Exception;

	// 캠핑 수칙 페이징
	public List<CampingTipVo> campingTipListPage(myReviewPagingDto myReviewPagingDto) throws Exception;

	// 캠핑 수칙 게시물 갯수 검색
	public int campingTipPostsCount() throws Exception;

	// 자주묻는질문 페이징
	public List<FaqVo> faqListPage(myReviewPagingDto myReviewPagingDto) throws Exception;

	// 자주묻는질문 게시물 갯수 검색
	public int faqPostsCount() throws Exception;

	// 공지사항 페이징
	public List<CampNoticeVo> noticeListPage(myReviewPagingDto myReviewPagingDto) throws Exception;

	// 공지사항 게시물 갯수 검색
	public int noticePostsCount() throws Exception;

	// 캠핑후기 페이징
	public List<ReviewVo> reviewListPage(myReviewPagingDto myReviewPagingDto) throws Exception;

	// 캠핑후기 게시물 갯수 검색
	public int reviewPostsCount() throws Exception;

	// 캠핑이야기 페이징
	public List<CampingTalkVo> campingTalkListPage(myReviewPagingDto myReviewPagingDto) throws Exception;

	// 캠핑이야기 게시물 갯수 검색
	public int campingTalkPostsCount() throws Exception;

	// 유저 벌점내용 조회
	public List<DemeritVo> demeritList() throws Exception;

	// 유저 정지 시간입력
	public void userBlockTimeUpdate(UserVo userVo) throws Exception;

	// 유저 벌점 조회
	public int userDemeritRef(String user_id) throws Exception;

	// 벌점내용 조회
	public List<DemeritCodeVo> demeritContentList() throws Exception;

	// 정해진 벌점 내용 조회
	public DemeritCodeVo selectDemeritCode(String demerit_content) throws Exception;

	// 유저 벌점 입력
	public void userDemerit(int demerit_value, String user_id) throws Exception;

	// 벌점 기록 입력
	public void insertDemerit(DemeritVo demeritVo) throws Exception;

	// 유저 벌점 조회
	public int selectUserDemerit(String user_id) throws Exception;

	// 유저 강제탈퇴
	public void deleteUser(String user_id) throws Exception;

	// 벌점 입력
	public void insertDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception;

	// 벌점 삭제
	public void deleteDemeritCode(String demerit_code) throws Exception;

	// 벌점 수정
	public void modifyDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception;

	// 유저 검색
	public List<UserVo> searchUser(String user_id) throws Exception;

	// 캠핑장 검색
	public List<CampVo> searchCamp(String camp_name) throws Exception;

	// 리뷰 검색
	public List<ReviewVo> searchReview(String review_title) throws Exception;

	// 캠핑이야기 검색
	public List<CampingTalkVo> searchCampingTalk(String campingtalk_title) throws Exception;

	// 자주묻는질문 검색
	public List<FaqVo> searchFaq(String faq_title) throws Exception;

	// 공지사항 검색
	public List<CampNoticeVo> searchNotice(String notice_title) throws Exception;

	// 캠핑이야기 검색
	public List<CampingTipVo> searchCampingTip(String campingtip_title) throws Exception;
	
	// 삭제된 글 조회
		public List<CampVo> deletePagingCampList(myReviewPagingDto myReviewPagingDto)throws Exception;
		public List<CampingTipVo> deletePagingCampingTipList(myReviewPagingDto myReviewPagingDto)throws Exception;
		public List<CampingTalkVo> deletePagingCampTalkList(myReviewPagingDto myReviewPagingDto)throws Exception;
		public List<FaqVo> deletePagingFaqList(myReviewPagingDto myReviewPagingDto)throws Exception;
		public List<CampNoticeVo> deletePagingNoticeList(myReviewPagingDto myReviewPagingDto)throws Exception;
		public List<ReviewVo> deletePagingReviewList(myReviewPagingDto myReviewPagingDto)throws Exception;
	// 삭제된 글 조회
			
	//삭제된글 갯수 조회
	public int deleteCampCount() throws Exception;
	public int deleteCampingTipCount() throws Exception;
	public int deleteCampTalkCount() throws Exception;
	public int deleteFaqCount() throws Exception;
	public int deleteNoticeCount() throws Exception;
	public int deleteReviewCount() throws Exception;
	//삭제된글 갯수 조회
	
	//정지된 유저 조회
		public List<UserVo> blockUserList() throws Exception;
		
		//정지된 유저아이디 검색
		public List<UserVo> searchBlockUser(String user_id) throws Exception;
		//삭제된 캠핑장 검색
		public List<CampVo> searchDeleteCamp(String camp_name) throws Exception;
		//삭제된 캠핑장 재등록
		public void deleteCampReEnrollment(String camp_no)throws Exception;
		//삭제된 게시글 제목으로 검색
		public List<CampingTipVo> delelteCampingTipPost(String campingtip_title) throws Exception;
		public List<CampingTalkVo> deleteCampingTalkPost(String campingtalk_title) throws Exception;
		public List<FaqVo> deleteFaqPost(String faq_title) throws Exception;
		public List<CampNoticeVo> deleteNoticePost(String notice_title) throws Exception;
		public List<ReviewVo> deleteReviewPost(String review_title) throws Exception;
		//삭제된 게시글 제목으로 검색
		
		//캠핑장 등록대기 목록
		public List<CampVo> waitForRegistrationCamp(myReviewPagingDto myReviewPagingDto) throws Exception;
		//대기상태 캠핑장 등록
		public void registCamp(int camp_no)throws Exception;
		//대기상태 캠핑장 거절
		public void notRegistCamp(int camp_no)throws Exception;
		//등록대기 캠핑장 갯수
		public int waitForRegistrationCampCount() throws Exception;
		//예약 입력
		public void reservationDate(ReservationVo reservationVo) throws Exception;
		//예약 조회
		public List<ReservationVo> reservationDateList(int camp_no);
		
}