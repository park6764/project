package com.korea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.k2.guestbook.GuestBookService;
import com.korea.k2.guestbook.GuestBookVO;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookService service;
	
	@RequestMapping("/guestBookInsert.do")
	public String guestBookInsert() {
		GuestBookVO vo = new GuestBookVO();
		String[] str1 = {"박", "석", "김", "이", "최", "윤", "강", "배", "민", "양"};
		String[] str2 = {"민석", "지윤", "민구", "준혁", "성현", "민규", "지호", "지민", "서현", "진욱"};
		String[] title = {"꿀 맛이에요", "여기가 대세", "음..", "좋아요", "괜찮네요", "별로에요", "질소판매", "종류가 다양해요", "굳", "엄 지 척"};
		
		for(int i = 1; i <= 555; i++) {
			int k1 = (int)(Math.random() * 10);
			int k2= (int)(Math.random() * 10);
			int k3 = (int)(Math.random() * 10);
			vo.setWriter(str1[k1] + str2[k2]);
			vo.setTitle(title[k3]);
			service.insert(vo);
		}
		return "/guestbook/insertOK.jsp";
	}
	
	@RequestMapping("/guestBookList.do")
	public String guestBookList(GuestBookVO vo, Model m) {
		m.addAttribute("li", service.list(vo));
		m.addAttribute("totalCount", service.totalCount(vo));
		return "/guestbook/guestBookList.jsp";
	}
}
