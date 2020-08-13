package com.kh.team.sjy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.domain.AreaCampingNameVo;

import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.sjy.persitence.AreaCampingNameDaoImpl;
import com.kh.team.sjy.persitence.CampingReviewDaoImpl;

import com.kh.team.sjy.service.CampingReviewService;
import com.kh.team.sjy.utile.CampingUrlUtil;





@Controller
@RequestMapping(value="/camp")
public class CampingReviewController {
	
	@Inject
	private CampingReviewDaoImpl campingReviewDaoImpl;
	
	@Inject
	private AreaCampingNameDaoImpl areaCampingNameDaoImpl;
	
	@Inject
	private CampingReviewService campingReviewService;

	

	


	
	//캠핑장 후기 목록 
	@RequestMapping(value="/campingReviewList", method=RequestMethod.GET)
	public String campingReviewList(MyReviewPagingDto myReviewPagingDto, Model model)throws Exception{
			myReviewPagingDto.setmyReviewPageInfo();
			int totalCount = campingReviewService.campingReviewListCount(myReviewPagingDto);
//			System.out.println("totalCount:" + totalCount);
			myReviewPagingDto.setTotalCount(totalCount);	
			List<ReviewVo>  list = campingReviewService.campingReviewListPage(myReviewPagingDto);
	
	
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", myReviewPagingDto);		
		
		return "camp/campingReviewList";
	}
	//캠핌장 후기 글 등록(폼) 
	@RequestMapping(value="/campingReviewWritingForm", method=RequestMethod.GET)
	public String campingReviewWritingForm(String area_si,Model model)throws Exception{
	
		List<AreaCampingNameVo> listAll = areaCampingNameDaoImpl.areaCampingName();
		List<AreaCampingNameVo> listArea = areaCampingNameDaoImpl.areaCampingSi();

		model.addAttribute("listAll", listAll);
		model.addAttribute("listArea", listArea);

		return  "/camp/campingReviewWritingForm";
	
	}

	
	//캠핑장 후기 글 등록(처리)
	
	@RequestMapping(value="/campingReviewWritingRun", method = RequestMethod.POST)
	public String campingReviewWritingRun(HttpServletRequest request,ReviewVo reviewVo,  RedirectAttributes rttr)throws Exception{
		rttr.addFlashAttribute("msg","insert");
		HttpSession httpSession =  request.getSession();
		String user_id = (String)httpSession.getAttribute("user_id");
		reviewVo.setReview_id(user_id);


		campingReviewService.campingReviewInsertRun(reviewVo);
		return "redirect:/camp/campingReviewList";
	}
	
	//캠핑장 글 내용
	@RequestMapping(value="/selectReview/{review_no}", method = RequestMethod.GET)
	public String selectReview(@PathVariable("review_no")int review_no , Model model , MyReviewPagingDto myReviewPagingDto) throws Exception{
	
		System.out.println("review_no:" + review_no);
		ReviewVo reviewVo = campingReviewDaoImpl.selectReview(review_no);
		System.out.println("reviewVo:" + reviewVo);
		List<ReviewVo> list = campingReviewService.campingReviewList();
		List<FilesVo> fileList = campingReviewService.filesList("후기");
		List<FilesVo> fileNoListImg = campingReviewService.filesNoFilesList(review_no);
//		System.out.println("list:" + list);
//		System.out.println("fileList:" + fileList);
//		System.out.println("fileList2:" + fileNoListImg);
		for (ReviewVo reviewVo2 : list) {
			for (FilesVo filesVo2 : fileList) {
				if(reviewVo2.getReview_no() == filesVo2.getFiles_no()) {
					String filename = filesVo2.getFiles();
					reviewVo2.setCamp_listFile(filename);
				}
			}
		}	
		
		 campingReviewDaoImpl.campingReviewView(review_no); //조회수
		
		
	
		model.addAttribute(reviewVo);
	
		model.addAttribute("list",list);
		model.addAttribute("fileList",fileList);
		model.addAttribute("fileNoListImg",fileNoListImg);
		model.addAttribute("pagingDto", myReviewPagingDto);

		return "/camp/selectReview";
	}
	
	//캠핑장 후기 수정 글
	@RequestMapping(value="/campingReviewModifyForm/{review_no}", method = RequestMethod.GET)
	public String campingReviewModifyForm(@PathVariable("review_no") int review_no , Model model,HttpServletRequest request) throws Exception{
		ReviewVo reviewVo = campingReviewService.campingReviewModifyForm(review_no);
		
		List<AreaCampingNameVo> modifyListArea = areaCampingNameDaoImpl.updateCampingAreaSi();
		HttpSession httpSession =  request.getSession();
		String user_id = (String)httpSession.getAttribute("user_id");
		if(!user_id.equals(reviewVo.getReview_id())) {
			return "redirect:/camp/main";
		}
		
		model.addAttribute("reviewVo", reviewVo);
		model.addAttribute("modifyListArea",modifyListArea);

		List<FilesVo> modifyList = campingReviewService.modifyFileList(reviewVo.getTable_name());
		List<FilesVo> modifyFileList = new ArrayList<>();
		for(FilesVo filesVo : modifyList) {
			if(filesVo.getFiles_no() == reviewVo.getReview_no()) {
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
				modifyFileList.add(filesVo);
				
			}
			
		}
//		System.out.println("updateFileList2:"+ updateFileList);
		model.addAttribute("modifyFileList", modifyFileList);
//		model.addAttribute("updateList", updateList);
		return "camp/campingReviewModifyForm";
		
	}
	//캠핑장 후기 수정 처리
	@RequestMapping(value="/campingReviewModifyRun", method = RequestMethod.POST)
	public String campingReviewModifyRun(ReviewVo reviewVo , RedirectAttributes rttr,  MyReviewPagingDto pagingDto) throws Exception{
		System.out.println("/camp/selectReview,post, reviewVo:" + reviewVo);
		System.out.println("/camp/selectReview,post, pagingDto:" + pagingDto);
		rttr.addFlashAttribute("msg","modify");
		campingReviewService.campingReviewModifyRun(reviewVo);
		String url = CampingUrlUtil.modifyPagingUrl("/camp/selectReview", pagingDto, reviewVo.getReview_no());
		System.out.println("/camp/selectReview,post, url:" + url);
		return "redirect:" + url;
	}
	
	//캠핑장 후기 삭제 처리
	@RequestMapping(value="/campingReviewDelete/{review_no}" , method = RequestMethod.GET)
	public String campingReviewDelete(@PathVariable("review_no") int review_no , RedirectAttributes rttr, MyReviewPagingDto pagingDto) throws Exception{
		rttr.addFlashAttribute("msg", "delete");
		campingReviewService.campingReviewDelete(review_no);
		String url =CampingUrlUtil.deletePagingUrl("/camp/campingReviewList", pagingDto);
		return "redirect:" +url;
	}

	
}
