package com.infinity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.infinity.model.Member;

public interface MemberService extends UserDetailsService{

	void saveMember(Member member);

	void updateMember(Member member);

	void deleteMember(Integer id);

	List<Member> findMember(Member member);

}