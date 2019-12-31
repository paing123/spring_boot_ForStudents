package com.infinity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.infinity.service.MemberService;
import com.infinity.model.Member;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@InitBinder
	private void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = { "/addmember" }, method = RequestMethod.GET)
	public String showMemberPage(Model model) {
		Member member = new Member();
		model.addAttribute("member",member);
		return "addmember";
	}
	
	@RequestMapping(value = { "/addmember" }, method = RequestMethod.POST)
	public String saveMemberPage(@ModelAttribute("member") Member member){
		memberService.saveMember(member);
		return "login";
	}
	
	@RequestMapping(value = {"/admin/member" }, method = RequestMethod.GET)
	public String member(Model model) {
		Member member = new Member();
		model.addAttribute("member",member);
		return "admin/member";
	}
	
	@RequestMapping(value = { "/admin/searchmember" }, method = RequestMethod.POST)
	public String SearchMember(@ModelAttribute("member") Member member, Model model) {
		List<Member> members = memberService.findMember(member);
		model.addAttribute("members", members);
		return "admin/member";
	}

	@GetMapping("/admin/deletemember/{id}")
	public ModelAndView deleteMember(@ModelAttribute("id") Integer id) {
		memberService.deleteMember(id);
		Member member = new Member();
		ModelAndView mav = new ModelAndView("admin/member");
		List<Member> members = memberService.findMember(member);
		mav.addObject("members", members);
		mav.addObject("member", member);
		return mav;
	}

	@GetMapping("/admin/updatemember/{id}")
	public ModelAndView showUpdateMemberForm(@ModelAttribute("id") Integer id) {
		Member member = new Member();
		member.setMemberId(id);
		member = memberService.findMember(member).get(0);
		ModelAndView mav = new ModelAndView("admin/updatemember");
		mav.addObject("member", member);
		return mav;
	}

	@RequestMapping(value = { "/admin/updatemember" }, method = RequestMethod.POST)
	public ModelAndView updateMember(@ModelAttribute("member") Member member) {
		memberService.updateMember(member);
		ModelAndView mav = new ModelAndView("admin/member");Member nmember = new Member();
		List<Member> members = memberService.findMember(nmember);
		mav.addObject("members", members);
		mav.addObject("member", nmember);
		return mav;
	}

}