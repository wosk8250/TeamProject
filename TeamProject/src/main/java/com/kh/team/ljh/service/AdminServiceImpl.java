package com.kh.team.ljh.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.AreaCampingNameVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.DemeritCodeVo;
import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.ljh.persistence.AdminDao;
import com.kh.team.sjy.persitence.CampNoticeDao;
@Repository
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDao adminDao;

	// 사용자 조회
	@Override
	public List<UserVo> userList() throws Exception {
		return adminDao.userList();
	}

	// 공지사항 조회
	@Override
	public List<CampNoticeVo> noticeList() throws Exception {
		return adminDao.noticeList();
	}

	// 자주묻는질문 조회
	@Override
	public List<FaqVo> faqList() throws Exception {
		return adminDao.faqList();
	}

	// 캠핑장 조회
	@Override
	public List<CampVo> campList() throws Exception {
		return adminDao.campList();
	}

	// 캠핑장 입력
	@Transactional
	@Override
	public void campInsertRun(CampVo campVo, AmenitiesVo amenitiesVo) throws Exception {
		int camp_no = adminDao.getNextVal();
		campVo.setCamp_no(camp_no);
		amenitiesVo.setCamp_no(camp_no);
		if(campVo.getThumbnail() != null) {
			String files[] = campVo.getFiles();
			String filename = files[0];
			int slashIndex = filename.lastIndexOf("/");
			String front = filename.substring(0, slashIndex + 1);
			String rear = filename.substring(slashIndex + 1);
			String thumbnailName = front + "sm_" + rear;
			campVo.setThumbnail(thumbnailName);
			adminDao.campInsertRun(campVo);
			campVo = adminDao.campModifyForm(campVo.getCamp_address());
			for (int i = 0; i < files.length; i++) {
				FilesVo filesVo = new FilesVo(campVo.getCamp_no(), files[i], campVo.getTable_name());
				adminDao.fileInsertRun(filesVo);
			}
			
		}else {
			campVo.setThumbnail("사진없음");
			adminDao.campInsertRun(campVo);
		}
		adminDao.campAmenities(amenitiesVo);//부대 시설
		
		AreaCampingNameVo areaCampingNameVo = new AreaCampingNameVo(0, campVo.getCamp_location(), campVo.getCamp_area(),
				campVo.getCamp_name());
		adminDao.areaInsert(areaCampingNameVo);
	}

	// 캠핑장 수정 폼
	@Override
	public CampVo campModifyForm(String camp_address) throws Exception {
		return adminDao.campModifyForm(camp_address);
	}

	// 캠핑장 수정 처리
	@Transactional
	@Override
	public void campModifyRun(CampVo campVo) throws Exception {
		
		if(campVo.getFiles() != null){
			String files[] = campVo.getFiles();
			String filename = files[0];
			int slashIndex = filename.lastIndexOf("/");
			String front = filename.substring(0, slashIndex + 1);
			String rear = filename.substring(slashIndex + 1);
			String thumbnailName = front + "sm_" + rear;
			campVo.setThumbnail(thumbnailName);
			for (int i = 0; i < files.length; i++) {
				FilesVo filesVo = new FilesVo(campVo.getCamp_no(), files[i], campVo.getTable_name());
				adminDao.fileInsertRun(filesVo);
			}
		}else {
			campVo.setThumbnail("사진없음");
		}
		adminDao.campModifyRun(campVo);
	}

	// 캠핑장 삭제 처리
	@Override
	public void campDelete(int camp_no) throws Exception {
		adminDao.campDelete(camp_no);
	}

	// 캠핑 수칙 조회
	@Override
	public List<CampingTipVo> campingTipList() throws Exception {
		return adminDao.campingTipList();
	}

	// 캠핑 수칙 입력
	@Transactional
	@Override
	public void campingTipInsertRun(CampingTipVo campingTipVo) throws Exception {
		if(campingTipVo.getFiles() != null) {
			String files[] = campingTipVo.getFiles();
			String filename = files[0];
			int slashIndex = filename.lastIndexOf("/");
			String front = filename.substring(0, slashIndex + 1);
			String rear = filename.substring(slashIndex + 1);
			String thumbnailName = front + "sm_" + rear;
			campingTipVo.setCampingtip_img(thumbnailName);
			adminDao.campingTipInsertRun(campingTipVo);
			campingTipVo = adminDao.campingTipModifyForm(campingTipVo.getCampingtip_title());
				for (int i = 0; i < files.length; i++) {
					FilesVo filesVo = new FilesVo(campingTipVo.getCampingtip_no(), files[i], campingTipVo.getTable_name());
					adminDao.fileInsertRun(filesVo);
				}
			
		}else {
			campingTipVo.setCampingtip_img("사진없음");
			adminDao.campingTipInsertRun(campingTipVo);
		}
		

	}
	
	
	// 캠핑 수칙 수정 폼
	@Override
	public CampingTipVo campingTipModifyForm(String campingtip_title) throws Exception {
		return adminDao.campingTipModifyForm(campingtip_title);
	}

	// 캠핑 수칙 수정 처리
	@Transactional
	@Override
	public void campingTipModifyRun(CampingTipVo campingTipVo) throws Exception {
		
		System.out.println(campingTipVo);
		
		if(campingTipVo.getFiles() != null){
			
			String files[] = campingTipVo.getFiles();
			String filename = files[0];
			int slashIndex = filename.lastIndexOf("/");
			String front = filename.substring(0, slashIndex + 1);
			String rear = filename.substring(slashIndex + 1);
			String thumbnailName = front + "sm_" + rear;
				campingTipVo.setCampingtip_img(thumbnailName);
			for (int i = 0; i < files.length; i++) {
				files = campingTipVo.getFiles();
				FilesVo filesVo = new FilesVo(campingTipVo.getCampingtip_no(), campingTipVo.getFiles()[i],campingTipVo.getTable_name());
				adminDao.fileInsertRun(filesVo);
			}
		}else {
			campingTipVo.setCampingtip_img("사진없음");
		}
		
		
		adminDao.campingTipModifyRun(campingTipVo);

	}

	// 캠핑 수칙 삭제 처리
	@Override
	public void campingTipDelete(int campingtip_no) throws Exception {
		adminDao.campingTipDelete(campingtip_no);
	}

	


	// 후기 조회
	@Override
	public List<ReviewVo> reviewList() throws Exception {

		return adminDao.reviewList();
	}

	// 후기 삭제
	@Override
	public void reviewDelete(int review_no) throws Exception {
		adminDao.reviewDelete(review_no);
	}

	// 게시판 별 이미지 조회
	@Override
	public List<FilesVo> filesList(String table_name) throws Exception {
		return adminDao.filesList(table_name);
	}

	@Override
	public void noticeRun(CampNoticeVo campNoticeVo) throws Exception {
		adminDao.noticeRun(campNoticeVo);
	}

	@Override
	public void noticeDeleteRun(int notice_no) throws Exception {
		adminDao.noticeDeleteRun(notice_no);
	}

	@Override
	public CampNoticeVo noticeModifyForm(int notice_no) throws Exception {
		return adminDao.noticeModifyForm(notice_no);
	}

	@Override
	public void noticeModifyRun(CampNoticeVo campNoticeVo) throws Exception {
		adminDao.noticeModifyRun(campNoticeVo);

	}

	@Override
	public void faqRun(FaqVo faqVo) throws Exception {
		adminDao.faqRun(faqVo);

	}

	@Override
	public FaqVo faqModifyForm(int faq_no) throws Exception {
		return adminDao.faqModifyForm(faq_no);
	}

	@Override
	public void faqModifyRun(FaqVo faqVo) throws Exception {
		adminDao.faqModifyRun(faqVo);
	}

	@Override
	public void faqDeleteRun(int faq_no) throws Exception {
		adminDao.faqDeleteRun(faq_no);
	}

	// 캠핑장 페이징
	@Override
	public List<CampVo> campListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.campListPage(myReviewPagingDto);
	}

	// 캠핑장 게시물 수 조회
	@Override
	public int campPostsCount() throws Exception {
		return adminDao.campPostsCount();
	}
	// 삭제된 캠핑장 페이징
	@Override
	public List<CampVo> blockCampListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.blockCampListPage(myReviewPagingDto);
	}
	
	// 삭제된 캠핑장 게시물 수 조회
	@Override
	public int blockCampPostsCount() throws Exception {
		return adminDao.blockCampPostsCount();
	}

	@Override
	public List<CampingTipVo> campingTipListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.campingTipListPage(myReviewPagingDto);
	}

	@Override
	public int campingTipPostsCount() throws Exception {
		return adminDao.campPostsCount();
	}

	@Override
	public List<FaqVo> faqListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.faqListPage(myReviewPagingDto);
	}

	@Override
	public int faqPostsCount() throws Exception {
		return adminDao.faqPostsCount();
	}

	@Override
	public List<CampNoticeVo> noticeListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.noticeListPage(myReviewPagingDto);
	}

	@Override
	public int noticePostsCount() throws Exception {
		return adminDao.noticePostsCount();
	}

	@Override
	public List<ReviewVo> reviewListPage(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.reviewListPage(myReviewPagingDto);
	}

	@Override
	public int reviewPostsCount() throws Exception {
		return adminDao.reviewPostsCount();
	}

	


	@Override
	public List<DemeritVo> demeritList() throws Exception {
		return adminDao.demeritList();
	}

	@Override
	public void userBlockTimeUpdate(UserVo userVo) throws Exception {
		adminDao.userBlockTimeUpdate(userVo);
	}

	@Override
	public int userDemeritRef(String user_id) throws Exception {
		return adminDao.userDemeritRef(user_id);
	}

	@Override
	public List<DemeritCodeVo> demeritContentList() throws Exception {
		return adminDao.demeritContentList();
	}

	@Override
	public DemeritCodeVo selectDemeritCode(String demerit_content) throws Exception {
		return adminDao.selectDemeritCode(demerit_content);
	}

	@Override
	public void userDemerit(int demerit_value, String user_id) throws Exception {
		adminDao.userDemerit(demerit_value, user_id);
	}

	@Override
	public void insertDemerit(DemeritVo demeritVo) throws Exception {
		adminDao.insertDemerit(demeritVo);
	}

	@Override
	public int selectUserDemerit(String user_id) throws Exception {
		return adminDao.selectUserDemerit(user_id);
	}
	@Transactional
	@Override
	public void deleteUser(String user_id) throws Exception {
			adminDao.deleteUser(user_id);
	}

	@Override
	public void insertDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception {
		adminDao.insertDemeritCode(demeritCodeVo);
	}

	@Override
	public void deleteDemeritCode(String demerit_code) throws Exception {
		adminDao.deleteDemeritCode(demerit_code);
	}

	@Override
	public void modifyDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception {
		adminDao.modifyDemeritCode(demeritCodeVo);
	}

	@Override
	public List<UserVo> searchUser(String user_id) throws Exception {
		return adminDao.searchUser(user_id);
	}

	@Override
	public List<CampVo> searchCamp(String camp_name) throws Exception {
		return adminDao.searchCamp(camp_name);
	}

	@Override
	public List<ReviewVo> searchReview(String review_title) throws Exception {
		return adminDao.searchReview(review_title);
	}


	@Override
	public List<FaqVo> searchFaq(String faq_title) throws Exception {
		return adminDao.searchFaq(faq_title);
	}

	@Override
	public List<CampNoticeVo> searchNotice(String notice_title) throws Exception {
		return adminDao.searchNotice(notice_title);
	}

	@Override
	public List<CampingTipVo> searchCampingTip(String campingtip_title) throws Exception {
		return adminDao.searchCampingTip(campingtip_title);
	}

	@Override
	public List<CampVo> deletePagingCampList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.deletePagingCampList(myReviewPagingDto);
	}

	@Override
	public List<CampingTipVo> deletePagingCampingTipList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.deletePagingCampingTipList(myReviewPagingDto);
	}

	

	@Override
	public List<FaqVo> deletePagingFaqList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.deletePagingFaqList(myReviewPagingDto);
	}

	@Override
	public List<CampNoticeVo> deletePagingNoticeList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.deletePagingNoticeList(myReviewPagingDto);
	}

	@Override
	public List<ReviewVo> deletePagingReviewList(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.deletePagingReviewList(myReviewPagingDto);
	}

	@Override
	public int deleteCampCount() throws Exception {
		return adminDao.deleteCampCount();
	}

	@Override
	public int deleteCampingTipCount() throws Exception {
		return adminDao.deleteCampingTipCount();
	}

	

	@Override
	public int deleteFaqCount() throws Exception {
		return adminDao.deleteFaqCount();
	}

	@Override
	public int deleteNoticeCount() throws Exception {
		return adminDao.deleteNoticeCount();
	}

	@Override
	public int deleteReviewCount() throws Exception {
		return adminDao.deleteReviewCount();
	}

	@Override
	public List<UserVo> blockUserList() throws Exception {
		return adminDao.blockUserList();
	}

	@Override
	public List<UserVo> searchBlockUser(String user_id) throws Exception {
		return adminDao.searchBlockUser(user_id);
	}

	@Override
	public List<CampVo> searchDeleteCamp(String camp_name) throws Exception {
		return adminDao.searchDeleteCamp(camp_name);
	}

	@Override
	public void deleteCampReEnrollment(String camp_no) throws Exception {
		adminDao.deleteCampReEnrollment(camp_no);
		
	}

	@Override
	public List<CampingTipVo> delelteCampingTipPost(String campingtip_title) throws Exception {
		return adminDao.delelteCampingTipPost(campingtip_title);
	}

	

	@Override
	public List<FaqVo> deleteFaqPost(String faq_title) throws Exception {
		return adminDao.deleteFaqPost(faq_title);
	}

	@Override
	public List<CampNoticeVo> deleteNoticePost(String notice_title) throws Exception {
		return adminDao.deleteNoticePost(notice_title);
	}

	@Override
	public List<ReviewVo> deleteReviewPost(String review_title) throws Exception {
		return adminDao.deleteReviewPost(review_title);
	}

	@Override
	public List<CampVo> waitForRegistrationCamp(myReviewPagingDto myReviewPagingDto) throws Exception {
		return adminDao.waitForRegistrationCamp(myReviewPagingDto);
	}

	@Override
	public void registCamp(int camp_no) throws Exception {
		adminDao.registCamp(camp_no);
	}

	@Override
	public void notRegistCamp(int camp_no) throws Exception {
		adminDao.notRegistCamp(camp_no);
	}

	@Override
	public int waitForRegistrationCampCount() throws Exception {
		return adminDao.waitForRegistrationCampCount();
	}

	@Override
	public void reservationDate(ReservationVo reservationVo) throws Exception {
		adminDao.reservationDate(reservationVo);
	}

	@Override
	public List<ReservationVo> reservationDateList(int camp_no) {
		return adminDao.reservationDateList(camp_no);
	}



}
