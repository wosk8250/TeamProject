package com.kh.team.ljh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingTalkVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.DemeritCodeVo;
import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.ksk.service.UserService;
import com.kh.team.ljh.service.AdminService;
import com.kh.team.ljh.utile.DateUtile;
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Inject
	private AdminService adminService;
	@Inject
	private UserService userService;

	// 유저 조회
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userList(Model model,String user_id) throws Exception {
		if(user_id == null) {
			List<UserVo> list = adminService.userList();
			model.addAttribute("list", list);
		} else {
			List<UserVo> list = adminService.searchUser(user_id);
			model.addAttribute("list", list);
		}
	
		List<DemeritVo> demeritList = adminService.demeritList();
		model.addAttribute("demeritList", demeritList);
		List<DemeritCodeVo> demeritContentList = adminService.demeritContentList();
		model.addAttribute("demeritContentList", demeritContentList);
		return "admin/user";
	}
	
	//정지된 유저 조회
	@RequestMapping(value="/blockUser",method=RequestMethod.GET)
	public String blockUserList(Model model,String user_id) throws Exception{
		List<UserVo> list = null;
		if(user_id == null) {
			list = adminService.blockUserList();
			model.addAttribute("list", list);
		} else {
			list = adminService.searchBlockUser(user_id);
		}
		LocalDateTime nowDate = LocalDateTime.now();
		for (UserVo userVo : list) {
			user_id = userVo.getUser_id();
			String strBlockDate = userService.getStopDate(user_id);
			LocalDateTime blockDate = DateUtile.stopDateTime(strBlockDate);
			boolean result = blockDate.isBefore(nowDate);
			if(result == true) {
				userService.stopUserBlock(user_id);
			}
 		}
		
		
		
		model.addAttribute("list", list);
		
		
		List<DemeritVo> demeritList = adminService.demeritList();
		model.addAttribute("demeritList", demeritList);
		List<DemeritCodeVo> demeritContentList = adminService.demeritContentList();
		model.addAttribute("demeritContentList", demeritContentList);
		
		return "admin/blockUser";
	}

	// 공지사항 조회
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String adminNotice(myReviewPagingDto myReviewPagingDto,Model model,String notice_title) throws Exception {
		if(notice_title == null) {
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.noticePostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		List<CampNoticeVo> list = adminService.noticeListPage(myReviewPagingDto);
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", myReviewPagingDto);
		} else {
			List<CampNoticeVo> list =  adminService.searchNotice(notice_title);
			model.addAttribute("list", list);
		}
		return "admin/notice";
	}

	// 자주묻는질문 조회
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String adminFrequentlyAskedQuestions(myReviewPagingDto myReviewPagingDto,Model model,String faq_title) throws Exception {
		if(faq_title == null){
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.faqPostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		List<FaqVo> list = adminService.faqListPage(myReviewPagingDto);
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", myReviewPagingDto);
		} else {
			List<FaqVo> list = adminService.searchFaq(faq_title);
			model.addAttribute("list", list);
		}
		model.addAttribute("checkBoard", "admin");
		return "admin/faq";
		
	}

	// 캠핑장 조회
	@RequestMapping(value = "/camp", method = RequestMethod.GET)
	public String adminCampList(myReviewPagingDto myReviewPagingDto,Model model,String camp_name) throws Exception {
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.campPostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		List<CampVo> list = null;
		if(camp_name == null) {
			list = adminService.campListPage(myReviewPagingDto);
		} else {
			list = adminService.searchCamp(camp_name);
		}
		
		model.addAttribute("list", list);

		model.addAttribute("pagingDto", myReviewPagingDto);
		return "admin/camp";

	}
	//삭제된 캠핑장 조회
	@RequestMapping(value = "/deleteCamp", method = RequestMethod.GET)
	public String blockCampListPage(myReviewPagingDto myReviewPagingDto,Model model,String camp_name) throws Exception {
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.blockCampPostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		List<CampVo> list = null;
		if(camp_name == null) {
			list = adminService.blockCampListPage(myReviewPagingDto);
		} else {
			list = adminService.searchDeleteCamp(camp_name);
		}
		
		model.addAttribute("list", list);
		
		model.addAttribute("pagingDto", myReviewPagingDto);
		return "admin/deleteCamp";
		
	}

	// 캠핑장 입력폼
	@RequestMapping(value = "/campForm", method = RequestMethod.GET)
	public void campForm() throws Exception {

	}

	// 캠핑장 글쓰기
	@RequestMapping(value = "/campRun", method = RequestMethod.POST)
	public String campInsertRun(CampVo campVo) throws Exception {
		adminService.campInsertRun(campVo);

		return "redirect:/admin/camp";
	}

	// 캠핑장 수정 글
	@RequestMapping(value = "/campModifyForm", method = RequestMethod.GET)
	public String campModifyForm(String camp_address, Model model) throws Exception {
		CampVo campVo = adminService.campModifyForm(camp_address);
		model.addAttribute("campVo", campVo);
		List<FilesVo> list = adminService.filesList(campVo.getTable_name());
		List<FilesVo> fileList = new ArrayList<>();
		for (FilesVo filesVo : list) {
			if (filesVo.getFiles_no() == campVo.getCamp_no()) {
				String file = filesVo.getFiles();
				filesVo.setFiles(file);
				int lastSlash = file.lastIndexOf("/");
				String front = file.substring(0, lastSlash + 1);
				String rear = file.substring(lastSlash + 1);
				String thumbnailName = front + "sm_" + rear;
				filesVo.setThumbnailName(thumbnailName);
				int lastUnderBar = file.lastIndexOf("_");
				String orgFileName = file.substring(lastUnderBar + 1);
				filesVo.setOrgFileName(orgFileName);
				fileList.add(filesVo);
			}
		}
		model.addAttribute("fileList", fileList);
		return "admin/campModifyForm";
	}

	// 캠핑장 수정 처리
	@RequestMapping(value = "/campModifyRun", method = RequestMethod.POST)
	public String campModifyRun(CampVo campVo) throws Exception {
		
		adminService.campModifyRun(campVo);
		return "redirect:/admin/camp";
	}

	// 캠핑장 삭제 처리
	@RequestMapping(value = "/campDelete", method = RequestMethod.GET)
	public String campDelete(int camp_no, RedirectAttributes attr) throws Exception {
		attr.addFlashAttribute("msg", "delete");
		adminService.campDelete(camp_no);
		return "redirect:/admin/camp";

	}
	
	//캠핑장 페이징
	@RequestMapping(value="/campListPage" , method=RequestMethod.GET)
	public void campListPage(myReviewPagingDto myReviewPagingDto,Model model) throws Exception{
		
		
	}

	// 캠핑수칙 조회
	@RequestMapping(value = "/campingTip", method = RequestMethod.GET)
	public String campingTipList(myReviewPagingDto myReviewPagingDto,Model model,String campingtip_title) throws Exception {
		List<CampingTipVo> list = null;
		if(campingtip_title == null) {
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.campingTipPostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		list = adminService.campingTipListPage(myReviewPagingDto);
		}else {
		list =  adminService.searchCampingTip(campingtip_title);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", myReviewPagingDto);
		return "admin/campingTip";
	}

	// 캠핑 수칙 입력 폼
	@RequestMapping(value = "/campingTipForm", method = RequestMethod.GET)
	public void campingTipForm() throws Exception {

	}

	// 캠핑 수칙 입력처리
	@RequestMapping(value = "/campingtipRun", method = RequestMethod.POST)
	public String campingTipInsertRun(CampingTipVo campingTipVo) throws Exception {
		adminService.campingTipInsertRun(campingTipVo);
		return "redirect:/admin/campingTip";
	}

	// 캠핑 수칙 수정 폼
	@RequestMapping(value = "/campingTipModifyForm", method = RequestMethod.GET)
	public String campingModifyForm(String campingtip_title, Model model) throws Exception {
		CampingTipVo campingTipVo = adminService.campingTipModifyForm(campingtip_title);
		model.addAttribute("campingTipVo", campingTipVo);
		List<FilesVo> list = adminService.filesList(campingTipVo.getTable_name());
		List<FilesVo> fileList = new ArrayList<>();
		for (FilesVo filesVo : list) {
			if (filesVo.getFiles_no() == campingTipVo.getCampingtip_no()) {
				String file = filesVo.getFiles();
				filesVo.setFiles(file);
				int lastSlash = file.lastIndexOf("/");
				String front = file.substring(0, lastSlash + 1);
				String rear = file.substring(lastSlash + 1);
				String thumbnailName = front + "sm_" + rear;
				filesVo.setThumbnailName(thumbnailName);
				int lastUnderBar = file.lastIndexOf("_");
				String orgFileName = file.substring(lastUnderBar + 1);
				filesVo.setOrgFileName(orgFileName);
				fileList.add(filesVo);
			}
		}
		model.addAttribute("fileList", fileList);
		return "admin/campingTipModify";
	}

	// 캠핑 수칙 수정 처리
	@RequestMapping(value = "/campingTipModifyRun", method = RequestMethod.POST)
	public String campingModifyRun(CampingTipVo campingTipVo) throws Exception {
		adminService.campingTipModifyRun(campingTipVo);

		return "redirect:/admin/campingTip";
	}

	// 캠핑 수칙 삭제 처리
	@RequestMapping(value = "/campingTipDelete", method = RequestMethod.GET)
	public String campingDelete(int campingtip_no, RedirectAttributes attr) throws Exception {
		adminService.campingTipDelete(campingtip_no);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:/admin/campingTip";
	}

	// 캠핑 이야기 조회
	@RequestMapping(value = "/campingTalk", method = RequestMethod.GET)
	public String campingTalkList(myReviewPagingDto myReviewPagingDto,Model model,String campingtalk_title) throws Exception {
		if(campingtalk_title == null) {
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.campingTalkPostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		List<CampingTalkVo> list = adminService.campingTalkListPage(myReviewPagingDto);
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", myReviewPagingDto);
		} else {
			List<CampingTalkVo> list =  adminService.searchCampingTalk(campingtalk_title);
			model.addAttribute("list", list);
		}
		return "admin/campingTalk";
	}
	
	

	// 캠핑 이야기 삭제
	@RequestMapping(value = "/campingTalkDelete", method = RequestMethod.GET)
	public String campingTalkDelete(int campingTalk_no, RedirectAttributes attr) throws Exception {
		adminService.campingTalkDelete(campingTalk_no);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:/admin/campingTalk";
	}

	// 캠핑 후기 조회
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String reviewList(myReviewPagingDto myReviewPagingDto,Model moadel,String review_title) throws Exception {
		if(review_title == null) {
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.reviewPostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		List<ReviewVo> list = adminService.reviewListPage(myReviewPagingDto);
		moadel.addAttribute("list", list);
		moadel.addAttribute("pagingDto", myReviewPagingDto);
		} else {
			List<ReviewVo> list =  adminService.searchReview(review_title);
			moadel.addAttribute("list", list);
		}
		
		return "admin/review";
		
	}

	// 캠핑 후기 삭제
	@RequestMapping(value = "/reviewDelete", method = RequestMethod.GET)
	public String reviewDelete(int review_no, RedirectAttributes attr) throws Exception {
		adminService.reviewDelete(review_no);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:/admin/review";
	}

	// 공지사항 작성폼
	@RequestMapping(value = "/noticeForm", method = RequestMethod.GET)
	public void noticeForm() throws Exception {

	}

	// 공지사항 작성처리
	@RequestMapping(value = "/noticeRun", method = RequestMethod.GET)
	public String noticeRun(CampNoticeVo campNoticeVo) throws Exception {
		adminService.noticeRun(campNoticeVo);
		return "redirect:/admin/notice";
	}

	// 공지사항 수정폼
	@RequestMapping(value = "/noticeModifyForm", method = RequestMethod.GET)
	public String noticeModifyForm(int notice_no, Model model) throws Exception {
		CampNoticeVo campNoticeVo = adminService.noticeModifyForm(notice_no);
		model.addAttribute("campNoticeVo", campNoticeVo);
		return "admin/noticeModifyForm";
	}

	// 공지사항 수정처리
	@RequestMapping(value = "noticeModifyRun", method = RequestMethod.GET)
	public String noticeModifyRun(CampNoticeVo campNoticeVo) throws Exception {
		adminService.noticeModifyRun(campNoticeVo);
		return "redirect:/admin/notice";
	}

	// 공지사항 삭제처리
	@RequestMapping(value = "/noticeDelete", method = RequestMethod.GET)
	public String noticeRun(int notice_no, RedirectAttributes attr) throws Exception {
		adminService.noticeDeleteRun(notice_no);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:/admin/notice";
	}

	// 자주묻는질문 작성폼
	@RequestMapping(value = "/faqForm", method = RequestMethod.GET)
	public void faqForm() throws Exception {

	}

	// 자주묻는질문 작성처리
	@RequestMapping(value = "/faqRun", method = RequestMethod.GET)
	public String faqRun(FaqVo faqVo) throws Exception {
		adminService.faqRun(faqVo);
		return "redirect:/admin/faq";
	}

	// 자주묻는질문 수정폼
	@RequestMapping(value = "/faqModifyForm/{faq_no}", method = RequestMethod.GET)
	public String faqModifyForm(@PathVariable("faq_no") int faq_no, Model model) throws Exception {
		FaqVo faqVo = adminService.faqModifyForm(faq_no);
		model.addAttribute("faqVo", faqVo);
		return "admin/faqModifyForm";
	}

	// 자주묻는질문 수정처리
	@RequestMapping(value = "/faqModifyRun", method = RequestMethod.GET)
	public String faqModifyRun(FaqVo faqVo) throws Exception {
		adminService.faqModifyRun(faqVo);
		return "redirect:/admin/faq";
	}

	// 자주묻는질문 삭제처리
	@RequestMapping(value = "/faqDelete/{faq_no}", method = RequestMethod.GET)
	public String faqRun(@PathVariable("faq_no") int faq_no, RedirectAttributes attr) throws Exception {
		adminService.faqDeleteRun(faq_no);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:/admin/faq";
	}
	
	//유저 벌점 입력 & 조회 & 정지
		@RequestMapping(value="/userDemerit/{user_id}/{demerit_content}",method=RequestMethod.GET)
		public String userDemerit(@PathVariable("user_id") String user_id,@PathVariable("demerit_content") String demerit_content) throws Exception{
			DemeritCodeVo demeritCodeVo = adminService.selectDemeritCode(demerit_content);
			LocalDateTime time = LocalDateTime.now();
			DemeritVo demeritVo = new DemeritVo(0, demeritCodeVo.getDemerit_code(), demeritCodeVo.getDemerit_content(), user_id, demeritCodeVo.getDemerit_value(), String.valueOf(time));
			adminService.userDemerit(demeritCodeVo.getDemerit_value(), user_id);
			adminService.insertDemerit(demeritVo);
			int userDemerit = adminService.selectUserDemerit(user_id);
			if(10 <= userDemerit && userDemerit < 50) {
				String user_stopdate = String.valueOf(time.plusMinutes(5));
				UserVo userVo = new UserVo();
				userVo.setUser_id(user_id);
				userVo.setUser_stopdate(user_stopdate);
				adminService.userBlockTimeUpdate(userVo);
			}
			if(50 <= userDemerit && userDemerit < 100) {
				String user_stopdate = String.valueOf(time.plusMonths(1));
				UserVo userVo = new UserVo();
				userVo.setUser_id(user_id);
				userVo.setUser_stopdate(user_stopdate);
				adminService.userBlockTimeUpdate(userVo);
			}
			if(userDemerit == 100) {
				adminService.deleteUser(user_id);
			}
			
			return "redirect:/admin/user";
		}
		
		//벌점 내역 조회
		@RequestMapping(value="/demerit",method=RequestMethod.GET)
		public String demritList(Model model) throws Exception{
			List<DemeritCodeVo> list = adminService.demeritContentList();
			model.addAttribute("list", list);
			return "admin/demerit";
		}
		//벌점 등록
		@RequestMapping(value="/insertDemeritCode",method=RequestMethod.GET)
		public String insertDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception{
			adminService.insertDemeritCode(demeritCodeVo);
			return "redirect:/admin/demerit";
		}
		//벌점삭제
		@RequestMapping(value="/demeritDelete",method=RequestMethod.GET)
		public String demeritCodeDelete(String demerit_code) throws Exception{
			adminService.deleteDemeritCode(demerit_code);
			return "redirect:/admin/demerit";
		}
		//벌점 수정
		@RequestMapping(value="/modifyDemeritCode",method=RequestMethod.GET)
		public String modifyDemeritCode(DemeritCodeVo demeritCodeVo) throws Exception{
			adminService.modifyDemeritCode(demeritCodeVo);
			return "redirect:/admin/demerit";
		}
		
		//삭제된 글 보기
		@RequestMapping(value="/deleteList",method=RequestMethod.GET)
		public String deleteList(myReviewPagingDto myReviewPagingDto,Model model) throws Exception{
				myReviewPagingDto.setmyReviewPageInfo();
				int deleteCampingTipCount = adminService.deleteCampingTipCount();
				int deleteCampTalkCount = adminService.deleteCampTalkCount();
				int deleteFaqCount = adminService.deleteFaqCount();
				int deleteNoticeCount = adminService.deleteNoticeCount();
				int deleteReviewCount = adminService.deleteReviewCount();
				int totalCount = deleteCampingTipCount + deleteCampTalkCount + deleteFaqCount + deleteNoticeCount + deleteReviewCount;
				myReviewPagingDto.setTotalCount(totalCount);
				
				List<CampingTipVo> campingTipVoList = adminService.deletePagingCampingTipList(myReviewPagingDto);
				List<CampingTalkVo> campingTalkList = adminService.deletePagingCampTalkList(myReviewPagingDto);
				List<FaqVo> faqList = adminService.deletePagingFaqList(myReviewPagingDto);
				List<CampNoticeVo> noticeList = adminService.deletePagingNoticeList(myReviewPagingDto);
				List<ReviewVo> reviewList = adminService.deletePagingReviewList(myReviewPagingDto);
				
				model.addAttribute("campingTipVoList",campingTipVoList );
				model.addAttribute("campingTalkList",campingTalkList );
				model.addAttribute("noticeList",noticeList );
				model.addAttribute("faqList",faqList );
				model.addAttribute("reviewList",reviewList );
				model.addAttribute("pagingDto", myReviewPagingDto);
				return "admin/deleteList";
		}
		@RequestMapping(value="/deleteList/{board}",method=RequestMethod.GET)
		public String deleteList(myReviewPagingDto myReviewPagingDto,Model model,@PathVariable("board") String board) throws Exception{
			myReviewPagingDto.setmyReviewPageInfo();
		
			 if (board.equals("캠핑 후기")) {
				
				int deleteReviewCount = adminService.deleteReviewCount();
				myReviewPagingDto.setTotalCount(deleteReviewCount);
				List<ReviewVo> reviewList = adminService.deletePagingReviewList(myReviewPagingDto);
				model.addAttribute("reviewList",reviewList );
				
			}else if (board.equals("캠핑 이야기")) {
				
				int deleteCampTalkCount = adminService.deleteCampTalkCount();
				myReviewPagingDto.setTotalCount(deleteCampTalkCount);
				List<CampingTalkVo> campingTalkList = adminService.deletePagingCampTalkList(myReviewPagingDto);
				model.addAttribute("campingTalkList",campingTalkList );
				
			}else if (board.equals("공지사항")) {
				
				int deleteNoticeCount = adminService.deleteNoticeCount();
				myReviewPagingDto.setTotalCount(deleteNoticeCount);
				List<CampNoticeVo> noticeList = adminService.deletePagingNoticeList(myReviewPagingDto);
				model.addAttribute("noticeList",noticeList );
				
			}else if (board.equals("캠핑 수칙")) {
				
				int deleteCampingTipCount = adminService.deleteCampingTipCount();
				myReviewPagingDto.setTotalCount(deleteCampingTipCount);
				List<CampingTipVo> campingTipVoList = adminService.deletePagingCampingTipList(myReviewPagingDto);
				model.addAttribute("campingTipVoList",campingTipVoList );
				
			}else if (board.equals("자주 묻는 질문")) {
				
				int deleteFaqCount = adminService.deleteFaqCount();
				myReviewPagingDto.setTotalCount(deleteFaqCount);
				List<FaqVo> faqList = adminService.deletePagingFaqList(myReviewPagingDto);
				model.addAttribute("faqList",faqList );
				
			}
			model.addAttribute("pagingDto", myReviewPagingDto);
			return "admin/deleteList";
		}
		
		@RequestMapping(value="/deleteList/{board}/{textTitle}",method=RequestMethod.GET)
		public String deleteList(myReviewPagingDto myReviewPagingDto,Model model,@PathVariable("board") String board,@PathVariable("textTitle") String textTitle) throws Exception{
			myReviewPagingDto.setmyReviewPageInfo();
			
			if (board.equals("캠핑 후기")) {
				List<ReviewVo> list = adminService.deleteReviewPost(textTitle);
				model.addAttribute("reviewList", list);
				
			}else if (board.equals("캠핑 이야기")) {
				List<CampingTalkVo> list = adminService.deleteCampingTalkPost(textTitle);
				model.addAttribute("campingTalkList", list);
				
			}else if (board.equals("공지사항")) {
				List<CampNoticeVo> list = adminService.deleteNoticePost(textTitle);
				model.addAttribute("noticeList", list);
				
			}else if (board.equals("캠핑 수칙")) {
				List<CampingTipVo> list = adminService.delelteCampingTipPost(textTitle);
				model.addAttribute("campingTipVoList", list);
				
			}else if (board.equals("자주 묻는 질문")) {
				List<FaqVo> list = adminService.deleteFaqPost(textTitle);
				model.addAttribute("faqList", list);
				
			}
			
			return "admin/deleteList";
		}
		
		//삭제된 캠핑장 글 재등록
		@RequestMapping(value="/deleteCampReEnrollment",method=RequestMethod.GET)
		public String deleteCampReEnrollment(String camp_no) throws Exception{
			adminService.deleteCampReEnrollment(camp_no);
			return "redirect:/admin/deleteCamp";
		}
		
		//등록 대기 캠핑장 조회
		@RequestMapping(value="/waitForRegistrationCamp",method=RequestMethod.GET)
		public String waitForRegistrationCamp(Model model,myReviewPagingDto myReviewPagingDto) throws Exception{
			myReviewPagingDto.setmyReviewPageInfo();
			int totalCount = adminService.waitForRegistrationCampCount();
			myReviewPagingDto.setTotalCount(totalCount);
			System.out.println(totalCount);
			List<CampVo> list = adminService.waitForRegistrationCamp(myReviewPagingDto);
			
			model.addAttribute("list", list);

			model.addAttribute("pagingDto", myReviewPagingDto);
			return "admin/waitForRegistrationCamp";

		}
		//등록 대기 캠핑장 등록
		@RequestMapping(value="/registCamp/{camp_no}" , method = RequestMethod.GET)
		public String registCamp(@PathVariable("camp_no") int camp_no)throws Exception {
			adminService.registCamp(camp_no);
			return "redirect:/admin/waitForRegistrationCamp";
		}
		
		//등록 대기 캠핑장 거절
		@RequestMapping(value="/notRegistCamp/{camp_no}" , method = RequestMethod.GET)
		public String notRegistCamp(@PathVariable("camp_no") int camp_no)throws Exception  {
			adminService.notRegistCamp(camp_no);
			return "redirect:/admin/waitForRegistrationCamp";
		}
		

}
