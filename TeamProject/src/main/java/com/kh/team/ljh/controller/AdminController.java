package com.kh.team.ljh.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.DemeritCodeVo;
import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.EmailDto;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.ksk.service.UserService;
import com.kh.team.ljh.service.AdminService;
import com.kh.team.ljh.utile.DateUtile;
import com.kh.team.ljh.utile.ReservationDate;
import com.kh.team.ljh.utile.UrlUtil;
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Inject
	private AdminService adminService;
	@Inject
	private UserService userService;
	@Inject
	private JavaMailSender javaMailSender;

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
	public String adminNotice(MyReviewPagingDto myReviewPagingDto,Model model,String notice_title) throws Exception {
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
	public String adminFrequentlyAskedQuestions(MyReviewPagingDto myReviewPagingDto,Model model,String faq_title) throws Exception {
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
		
		return "admin/faq";
		
	}

	// 캠핑장 조회
	@RequestMapping(value = "/camp", method = RequestMethod.GET)
	public String adminCampList(HttpSession session,MyReviewPagingDto myReviewPagingDto,Model model,String camp_name) throws Exception {
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = adminService.campPostsCount();
		myReviewPagingDto.setTotalCount(totalCount);
		List<CampVo> list = null;
		if(camp_name == null) {
			list = adminService.campListPage(myReviewPagingDto);
		} else {
			list = adminService.searchCamp(camp_name);
		}
		
		session.setAttribute("checkBoard", "admin");
		model.addAttribute("list", list);

		model.addAttribute("pagingDto", myReviewPagingDto);
		return "admin/camp";

	}
	//삭제된 캠핑장 조회
	@RequestMapping(value = "/deleteCamp", method = RequestMethod.GET)
	public String blockCampListPage(MyReviewPagingDto myReviewPagingDto,Model model,String camp_name) throws Exception {
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
	//캠핑장 재등록
	@RequestMapping(value="/deleteCampReEnrollment/{camp_no}",method = RequestMethod.GET)
	public String deleteCampReEnrollment(@PathVariable("camp_no")String camp_no) throws Exception{
		adminService.deleteCampReEnrollment(camp_no);
		return "redirect:/admin/deleteCamp";
	}

	// 캠핑장 입력폼
	@RequestMapping(value = "/campForm", method = RequestMethod.GET)
	public void campForm() throws Exception {

	}

	// 캠핑장 글쓰기
	@RequestMapping(value = "/campRun", method = RequestMethod.POST)
	public String campInsertRun(CampVo campVo, AmenitiesVo amenitiesVo) throws Exception {
		adminService.campInsertRun(campVo, amenitiesVo);

		return "redirect:/admin/camp";
	}

	// 캠핑장 수정 글
	@RequestMapping(value = "/campModifyForm", method = RequestMethod.GET)
	public String campModifyForm(int camp_no, Model model) throws Exception {
		CampVo campVo = adminService.campModifyForm(camp_no);
		AmenitiesVo amenitiesVo = adminService.selectByAmenities(camp_no);
		model.addAttribute("campVo", campVo);
		model.addAttribute("amenitiesVo", amenitiesVo);
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
	public String campModifyRun(CampVo campVo, AmenitiesVo amenitiesVo) throws Exception {
		adminService.campModifyRun(campVo, amenitiesVo);
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
	public void campListPage(MyReviewPagingDto myReviewPagingDto,Model model) throws Exception{
		
		
	}

	// 캠핑수칙 조회
	@RequestMapping(value = "/campingTip", method = RequestMethod.GET)
	public String campingTipList(MyReviewPagingDto myReviewPagingDto,Model model,String campingtip_title) throws Exception {
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
		return "/admin/campingTip";
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
	@RequestMapping(value = "/campingTipModifyForm/{campingtip_title}", method = RequestMethod.GET)
	public String campingModifyForm(@PathVariable("campingtip_title") String campingtip_title, Model model) throws Exception {
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
		return "redirect:/camp/singleContentsCampingTip/" + campingTipVo.getCampingtip_no() ;
	}

	// 캠핑 수칙 삭제 처리
	@RequestMapping(value = "/campingTipDelete", method = RequestMethod.GET)
	public String campingDelete(int campingtip_no, RedirectAttributes attr) throws Exception {
		adminService.campingTipDelete(campingtip_no);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:/admin/campingTip";
	}

	
	
	



	// 캠핑 후기 조회
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String reviewList(MyReviewPagingDto myReviewPagingDto,Model moadel,String review_title) throws Exception {
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
	public String noticeModifyForm(int notice_no, Model model,PagingDto pagingDto) throws Exception {
		CampNoticeVo campNoticeVo = adminService.noticeModifyForm(notice_no);
		model.addAttribute("campNoticeVo", campNoticeVo);
		return "admin/noticeModifyForm";
	}

	// 공지사항 수정처리
	@RequestMapping(value = "/noticeModifyRun", method = RequestMethod.GET)
	public String noticeModifyRun(CampNoticeVo campNoticeVo,PagingDto pagingDto) throws Exception {
		System.out.println(campNoticeVo);
		adminService.noticeModifyRun(campNoticeVo);
		String url = UrlUtil.makePagingUrl(campNoticeVo.getNotice_no(),"/camp/singleContentsCampNotice", pagingDto);
		return "redirect:" + url;
	}

	// 공지사항 삭제처리
	@RequestMapping(value = "/noticeDelete", method = RequestMethod.GET)
	public String noticeRun(int notice_no, RedirectAttributes attr,PagingDto pagingDto) throws Exception {
		adminService.noticeDeleteRun(notice_no);
		String url = UrlUtil.makePagingUrl("/admin/notice", pagingDto);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:" + url;
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
		return "redirect:/camp/selectByfaq/" + faqVo.getFaq_no();
	}

	// 자주묻는질문 삭제처리
	@RequestMapping(value = "/faqDelete/{faq_no}", method = RequestMethod.GET)
	public String faqRun(@PathVariable("faq_no") int faq_no, RedirectAttributes attr) throws Exception {
		adminService.faqDeleteRun(faq_no);
		attr.addFlashAttribute("msg", "delete");
		return "redirect:/admin/faq";
	}
	
	//유저 벌점 입력 & 조회 & 정지
		@RequestMapping(value="/userDemerit/{user_id}/{demerit_content}/{user}",method=RequestMethod.GET)
		public String userDemerit(@PathVariable("user_id") String user_id,@PathVariable("demerit_content") String demerit_content,@PathVariable("user")String user) throws Exception{
			DemeritCodeVo demeritCodeVo = adminService.selectDemeritCode(demerit_content);
			LocalDateTime time = LocalDateTime.now();
			DemeritVo demeritVo = new DemeritVo(0, demeritCodeVo.getDemerit_code(), demeritCodeVo.getDemerit_content(), user_id, demeritCodeVo.getDemerit_value(), String.valueOf(time));
			adminService.userDemerit(demeritCodeVo.getDemerit_value(), user_id);
			adminService.insertDemerit(demeritVo);
			int userDemerit = adminService.selectUserDemerit(user_id);
			if(10 <= userDemerit && userDemerit < 50) {
				String user_stopdate = String.valueOf(time.plusSeconds(3));
				UserVo userVo = new UserVo();
				userVo.setUser_id(user_id);
				userVo.setUser_stopdate(user_stopdate);
				adminService.userBlockTimeUpdate(userVo);
			}else if(50 <= userDemerit && userDemerit < 100) {
				String user_stopdate = String.valueOf(time.plusMonths(1));
				UserVo userVo = new UserVo();
				userVo.setUser_id(user_id);
				userVo.setUser_stopdate(user_stopdate);
				adminService.userBlockTimeUpdate(userVo);
			}else if(userDemerit >= 100) {
			adminService.deleteUser(user_id);
			}
			String returnStr = null;
			
			if(user.equals("user")) {
				returnStr = "redirect:/admin/user";
			}else {
				returnStr = "redirect:/admin/blockUser";
			}
			return returnStr;
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
		
		//등록 대기 캠핑장 조회
		@RequestMapping(value="/waitForRegistrationCamp",method=RequestMethod.GET)
		public String waitForRegistrationCamp(Model model,MyReviewPagingDto myReviewPagingDto) throws Exception{
			myReviewPagingDto.setmyReviewPageInfo();
			int totalCount = adminService.waitForRegistrationCampCount();
			myReviewPagingDto.setTotalCount(totalCount);
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
		@RequestMapping(value="/notRegistCamp/{camp_no}	" , method = RequestMethod.GET)
		public String notRegistCamp(@PathVariable("camp_no") int camp_no)throws Exception  {
			adminService.notRegistCamp(camp_no);
			
			EmailDto emailDto = new EmailDto();
			emailDto.setTo("janjan44@naver.com");
			emailDto.setContents("등록이 거절되엇습니다");
			
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
					helper.setFrom(emailDto.getFrom());
					helper.setTo(emailDto.getTo());
					helper.setSubject("camping club입니다");
					helper.setText(emailDto.getContents());
				}
			};
			javaMailSender.send(preparator);
			
			return "redirect:/admin/waitForRegistrationCamp";
		}
		
}