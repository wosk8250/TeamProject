package com.kh.team.ksk.controller;

import java.util.UUID;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.domain.EmailDto;
import com.kh.team.ksk.service.UserService;

@Controller
@RequestMapping(value ="email")
public class EmailController {

	@Inject
	private UserService userService;
	
	@Inject
	private JavaMailSender javaMailSender;
	
	//비밀번호 찾기 처리
	@Transactional
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPwPost(String user_id, String user_email, RedirectAttributes rttr)throws Exception{
		//아이디 이메일이 틀리면 찾기 페이지에 머무르고 메시지 출력
		boolean result = userService.findPw(user_id, user_email);
		if (result == false) {
			System.out.println("실패");
			rttr.addFlashAttribute("message", "unfind");
			return "redirect:/user/findPw";
		}
		//아이디 이메일이 맞으면 로그인 페이지로 보내고 메시지
		UUID uuid = UUID.randomUUID();
		String new_pw = uuid.toString().substring(0,6);
		String contents = "회원님의 비밀번호가 임시비밀번호 (" + new_pw+ ")로 수정 되었습니다. 로그인 하시고 비밀번호를 즉시 바꿔주세요!";
		EmailDto emailDto = new EmailDto();
		emailDto.setTo(user_email);
		emailDto.setContents(contents);
		userService.updatePw(user_id, new_pw);
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
				helper.setFrom(emailDto.getFrom());
				helper.setTo(emailDto.getTo());
				helper.setSubject(emailDto.getSubject());
				helper.setText(emailDto.getContents());
			}
		};
		javaMailSender.send(preparator);
		rttr.addFlashAttribute("message", "find");
		return "redirect:/user/login";
	}
	

}
