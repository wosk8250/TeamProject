package com.kh.team.ljh.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.team.domain.AreaCampingNameVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingTalkVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.DemeritCodeVo;
import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.myReviewPagingDto;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "mappers.admin-mapper.";

	// 사용자 조회
	@Override
	public List<UserVo> userList() throws Exception {

		return sqlSession.selectList(NAMESPACE + "userList");

	}

	// 공지사항 조회
	@Override
	public List<CampNoticeVo> noticeList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "noticeList");
	}

	// 자주묻는 질문 조회
	@Override
	public List<FaqVo> faqList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "faqList");
	}

	// 캠핑장 조회
	@Override
	public List<CampVo> campList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "campList");
	}

	// 캠핑장 입력
	@Override
	public void campInsertRun(CampVo campVo) throws Exception {
		sqlSession.insert(NAMESPACE + "campInsertRun", campVo);
	}

	// 캠핑장 수정폼
	@Override
	public CampVo campModifyForm(String camp_address) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campModifyForm", camp_address);

	}

	// 캠핑장 수정 처리
	@Override
	public void campModifyRun(CampVo campVo) throws Exception {
		
		sqlSession.update(NAMESPACE + "campModifyRun", campVo);
	}

	// 캠핑장 삭제 처리
	@Override
	public void campDelete(int camp_no) throws Exception {
		sqlSession.update(NAMESPACE + "campDeleteRun", camp_no);
	}

	// 캠핑수칙 조회
	@Override
	public List<CampingTipVo> campingTipList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "campingTipList");
	}

	// 캠핑수칙 입력
	@Override
	public void campingTipInsertRun(CampingTipVo campingTipVo) throws Exception {
		sqlSession.insert(NAMESPACE + "campingTipInsertRun", campingTipVo);
	}

	// 캠핑 수칙 수정 폼
	@Override
	public CampingTipVo campingTipModifyForm(String campingtip_title) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingTipModifyForm", campingtip_title);
	}

	// 캠핑 수칙 수정 처리
	@Override
	public void campingTipModifyRun(CampingTipVo campingTipVo) throws Exception {

		sqlSession.update(NAMESPACE + "campingTipModifyRun", campingTipVo);
	}

	// 캠핑 수칙 삭제 처리
	@Override
	public void campingTipDelete(int campingtip_no) throws Exception {
		sqlSession.update(NAMESPACE + "campingTipDelete", campingtip_no);
	}

	// 캠핑 이야기 조회
	@Override
	public List<CampingTalkVo> campingTalkList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "campingTalkList");
	}
	// 캠핑 이야기 삭제

	@Override
	public void campingTalkDelete(int campingTalk_no) throws Exception {
		sqlSession.update(NAMESPACE + "campingTalkDelete", campingTalk_no);
	}
	// 캠핑 후기 조회

	@Override
	public List<ReviewVo> reviewList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "reviewList");
	}

	// 캠핑 후기 삭제
	@Override
	public void reviewDelete(int review_no) throws Exception {
		sqlSession.update(NAMESPACE + "reviewDelete", review_no);
	}

	// 사진 입력
	@Override
	public void fileInsertRun(FilesVo filesVo) throws Exception {
		System.out.println(filesVo);
		sqlSession.insert(NAMESPACE + "fileInsertRun", filesVo);

	}

	// 파일 조회
	@Override
	public List<FilesVo> filesList(String table_name) throws Exception {
		return sqlSession.selectList(NAMESPACE + "fileList", table_name);
	}

	// 공지사항 작성처리
	@Override
	public void noticeRun(CampNoticeVo campNoticeVo) throws Exception {
		sqlSession.insert(NAMESPACE + "noticeInsertRun", campNoticeVo);
	}

	// 공지사항 삭제처리
	@Override
	public void noticeDeleteRun(int notice_no) throws Exception {
		sqlSession.update(NAMESPACE + "noticedeleteRun", notice_no);

	}

	// 공지사항 수정폼
	@Override
	public CampNoticeVo noticeModifyForm(int notice_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "noticeModifyForm", notice_no);
	}

	// 공지사항 수정처리
	@Override
	public void noticeModifyRun(CampNoticeVo campNoticeVo) throws Exception {
		sqlSession.update(NAMESPACE + "noticeModifyRun", campNoticeVo);
	}

	// 자주묻는질문 작성 처리
	@Override
	public void faqRun(FaqVo faqVo) throws Exception {
		sqlSession.insert(NAMESPACE + "faqInsertRun", faqVo);

	}

	// 자주묻는질문 수정 폼
	@Override
	public FaqVo faqModifyForm(int faq_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "faqModifyForm", faq_no);
	}

	// 자주묻는질문 수정 처리
	@Override
	public void faqModifyRun(FaqVo faqVo) throws Exception {
		sqlSession.update(NAMESPACE + "faqModifyRun", faqVo);
	}

	// 자주묻는질문 삭제 처리
	@Override
	public void faqDeleteRun(int faq_no) throws Exception {
		sqlSession.update(NAMESPACE + "faqdeleteRun", faq_no);
	}

	// 캠핑장 지역 구 캠핑장 이름 입력
	@Override
	public void areaInsert(AreaCampingNameVo areaCampingNameVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertAreaCampingName", areaCampingNameVo);
	}

	// 캠핑장 페이징
	@Override
	public List<CampVo> campListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "campListPage", myReviewPagingDto);
	}

	// 캠핑장 게시물 수 조회
	@Override
	public int campPostsCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campPostsCount");
	}
	//삭제된 캠핑장 페이징
	@Override
	public List<CampVo> blockCampListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "blockCampListPage", myReviewPagingDto);
	}
	
	//삭제된 캠핑장 게시물 수 조회
	@Override
	public int blockCampPostsCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "blockCampPostsCount");
	}

	// 캠핑수칙 페이징
	@Override
	public List<CampingTipVo> campingTipListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "campingTipListPage", myReviewPagingDto);
	}

	// 캠핑수칙 게시물 수 조회
	@Override
	public int campingTipPostsCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingTipPostsCount");
	}

	// 자주묻는질문 페이징
	@Override
	public List<FaqVo> faqListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "faqListPage", myReviewPagingDto);
	}

	// 자주묻는질문 게시물 갯수 검색
	@Override
	public int faqPostsCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "faqPostsCount");
	}

	// 공지사항 페이징
	@Override
	public List<CampNoticeVo> noticeListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "noticeListPage", myReviewPagingDto);
	}

	// 공지사항 게시물 숫자 조회
	@Override
	public int noticePostsCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "noticePostsCount");
	}

	@Override
	public List<ReviewVo> reviewListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "reviewListPage", myReviewPagingDto);
	}

	@Override
	public int reviewPostsCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "reviewPostsCount");
	}

	@Override
	public List<CampingTalkVo> campingTalkListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "campingTalkListPage", myReviewPagingDto);
	}

	@Override
	public int campingTalkPostsCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "campingTalkPostsCount");
	}

	@Override
	public List<DemeritVo> demeritList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "demeritList");
	}

	@Override
	public void userBlockTimeUpdate(UserVo userVo) throws Exception {
		sqlSession.update(NAMESPACE + "userDemeritTimeUpdate", userVo);
	}

	@Override
	public int userDemeritRef(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "userDemeritRef", user_id);

	}

	@Override
	public List<DemeritCodeVo> demeritContentList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "demeritContentList");
	}

	@Override
	public DemeritCodeVo selectDemeritCode(String demerit_content) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectDemeritCode", demerit_content);
	}

	@Override
	public void userDemerit(int demerit_value, String user_id) throws Exception {
		DemeritVo demeritVo = new DemeritVo();
		demeritVo.setUser_id(user_id);
		demeritVo.setDemerit_value(demerit_value);
		sqlSession.update(NAMESPACE + "userDemerit", demeritVo);
	}

	@Override
	public void insertDemerit(DemeritVo demeritVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertDemerit", demeritVo);
	}

	@Override
	public int selectUserDemerit(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectUserDemerit",user_id);
	}

	@Override
	public void deleteUser(String user_id) throws Exception {
		sqlSession.delete(NAMESPACE + "deleteUser",user_id);
	}

	@Override
	public void deleteUserByReview(String user_id) throws Exception {
		sqlSession.delete(NAMESPACE + "deleteUserByReview",user_id);
	}

	@Override
	public void deleteUserByCampTalk(String user_id) throws Exception {
		sqlSession.delete(NAMESPACE + "deleteUserByCampTalk",user_id);
	}

	@Override
	public void deleteUserByDemerit(String user_id) throws Exception {
		sqlSession.delete(NAMESPACE + "deleteUserByDemerit",user_id);
	}

	@Override
	public void insertDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertDemeritCode",demeritCodeVo);
	}

	@Override
	public void deleteDemeritCode(String demerit_code) throws Exception {
		sqlSession.delete(NAMESPACE + "deleteDemeritCode" , demerit_code);
	}

	@Override
	public void modifyDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception {
		sqlSession.update(NAMESPACE + "modifyDemeritCode", demeritCodeVo);
	}

	@Override
	public List<UserVo> searchUser(String user_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchUser", user_id);
	}

	@Override
	public List<CampVo> searchCamp(String camp_name) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchCamp", camp_name);
	}

	@Override
	public List<ReviewVo> searchReview(String review_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchReview", review_title);
	}

	@Override
	public List<CampingTalkVo> searchCampingTalk(String campingtalk_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchCampingTalk", campingtalk_title);
	}

	@Override
	public List<FaqVo> searchFaq(String faq_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchFaq", faq_title);
	}

	@Override
	public List<CampNoticeVo> searchNotice(String notice_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchNotice", notice_title);
	}

	@Override
	public List<CampingTipVo> searchCampingTip(String campingtip_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchCampingTip", campingtip_title);
	}

	@Override
	public List<CampVo> deletePagingCampList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deletePagingCampList",myReviewPagingDto);
	}

	@Override
	public List<CampingTipVo> deletePagingCampingTipList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deletePagingCampingTipList",myReviewPagingDto);
	}

	@Override
	public List<CampingTalkVo> deletePagingCampTalkList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deletePagingCampTalkList",myReviewPagingDto);
	}

	@Override
	public List<FaqVo> deletePagingFaqList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deletePagingFaqList",myReviewPagingDto);
	}

	@Override
	public List<CampNoticeVo> deletePagingNoticeList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deletePagingNoticeList",myReviewPagingDto);
	}

	@Override
	public List<ReviewVo> deletePagingReviewList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deletePagingReviewList",myReviewPagingDto);
	}

	@Override
	public int deleteCampCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "deleteCampCount");
	}

	@Override
	public int deleteCampingTipCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "deleteCampingTipCount");
	}

	@Override
	public int deleteCampTalkCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "deleteCampTalkCount");
	}

	@Override
	public int deleteFaqCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "deleteFaqCount");
	}

	@Override
	public int deleteNoticeCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "deleteNoticeCount");
	}

	@Override
	public int deleteReviewCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "deleteReviewCount");
	}

	@Override
	public List<UserVo> blockUserList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "blockUserList");
	}

	@Override
	public List<UserVo> searchBlockUser(String user_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchBlockUser", user_id);
	}

	@Override
	public List<CampVo> searchDeleteCamp(String camp_name) throws Exception {
		return sqlSession.selectList(NAMESPACE + "searchDeleteCamp", camp_name);
	}

	@Override
	public void deleteCampReEnrollment(String camp_no) throws Exception {
		sqlSession.update(NAMESPACE + "deleteCampReEnrollment",camp_no);
	}

	@Override
	public List<CampingTipVo> delelteCampingTipPost(String campingtip_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "delelteCampingTipPost", campingtip_title);
	}

	@Override
	public List<CampingTalkVo> deleteCampingTalkPost(String campingtalk_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deleteCampingTalkPost", campingtalk_title);
	}

	@Override
	public List<FaqVo> deleteFaqPost(String faq_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deleteFaqPost",faq_title);
	}

	@Override
	public List<CampNoticeVo> deleteNoticePost(String notice_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deleteNoticePost", notice_title);
	}

	@Override
	public List<ReviewVo> deleteReviewPost(String review_title) throws Exception {
		return sqlSession.selectList(NAMESPACE + "deleteReviewPost", review_title);
	}

	@Override
	public List<CampVo> waitForRegistrationCamp(myReviewPagingDto myReviewPagingDto) throws Exception {
		return sqlSession.selectList(NAMESPACE + "waitForRegistrationCamp",myReviewPagingDto);
	}

	@Override
	public void registCamp(int camp_no) throws Exception {
		sqlSession.update(NAMESPACE + "registCamp", camp_no);
	}

	@Override
	public void notRegistCamp(int camp_no) throws Exception {
		sqlSession.update(NAMESPACE + "notRegistCamp", camp_no);
	}

	@Override
	public int waitForRegistrationCampCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "waitForRegistrationCampCount");
	}



}
