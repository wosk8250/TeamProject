package com.kh.team.sjy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampingTipDaoImpl;
import com.kh.team.sjy.service.CampingTipService;

@Controller
@RequestMapping(value="/camp")
public class CampingTipConroller {
	
	@Inject
	private CampingTipDaoImpl campingTipDaoImpl;
	@Inject
	private CampingTipService campingTipService;
	
	//캠핑 수칙 목록
	@RequestMapping(value="/campingTipList" , method = RequestMethod.GET  )
	public String CampTipList(myReviewPagingDto myReviewPagingDto, Model model , String campingtip_title)throws Exception{
		List <CampingTipVo> list = null;
		System.out.println("myReviewPagingDto:"+ myReviewPagingDto);
		if( campingtip_title == null) {
			myReviewPagingDto.setmyReviewPageInfo();
			int totalCount = campingTipService.campingTipListCount(myReviewPagingDto);
			myReviewPagingDto.setTotalCount(totalCount);
			list = campingTipService.campingTipListPage(myReviewPagingDto);

		}else {
			
			list = campingTipService.campingTipSearch(campingtip_title);
		
	
		
		}
	
		model.addAttribute("list",list);	
		model.addAttribute("pagingDto", myReviewPagingDto);
	
		return  "camp/campingTipList";
	}
	//캠핑 수칙 글 내용
	@Transactional
	@RequestMapping(value="/singleContentsCampingTip/{campingtip_no}", method= RequestMethod.GET)
	public String singleContentsCampingTip(@PathVariable("campingtip_no") int campingtip_no,Model model)throws Exception{
		System.out.println("campingtip_no:"+ campingtip_no);
		CampingTipVo campingTipVo = campingTipDaoImpl.singleContentsCampingTip(campingtip_no); //  캠핑수칙 글내용
		List<CampingTipVo> tipList = campingTipService.campingTipList();
		List<FilesVo> fileList = campingTipService.filesList("캠핑수칙");
		List<FilesVo> fileNoListImg = campingTipService.filesNoFilesList(campingtip_no);
		for( CampingTipVo campingTipVo2 : tipList) {
			for( FilesVo filesVo2 : fileList) {
				if(campingTipVo2.getCampingtip_no() == filesVo2.getFiles_no()) {
						String filename = filesVo2.getFiles();
						campingTipVo2.setCampingtip_listFile(filename);
				}
			}
		}
		campingTipDaoImpl.updateCampingTipView(campingtip_no);  //조회수
		System.out.println("campNoticeVo:" + campingTipVo );
		model.addAttribute(campingTipVo);
		model.addAttribute("tipList",tipList);
		model.addAttribute("fileList",fileList);
		model.addAttribute("fileNoListImg",fileNoListImg);
		
		
		
		
		return  "/camp/singleContentsCampingTip";
	}
	
	

}
