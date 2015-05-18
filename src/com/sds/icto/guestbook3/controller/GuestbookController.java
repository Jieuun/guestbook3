package com.sds.icto.guestbook3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.sds.icto.guestbook3.dao.GuestBookDao;
import com.sds.icto.guestbook3.vo.GuestBookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	GuestBookDao guestbookDao;
	
	@RequestMapping("/index")
	
	public String index(Model model){
		List<GuestBookVo> list = guestbookDao.fetchlist();
		model.addAttribute("list", list);
		return "/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form(){
		return "/views/index.jsp";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(
			@RequestParam("name") String name,
			@RequestParam("pass") String pass, 
			@RequestParam("content") String content)
	
	{
		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPassword(pass);
		vo.setMessage(content);
		
		guestbookDao.add(vo);

		return "redirect:/index";

	}
	
}
