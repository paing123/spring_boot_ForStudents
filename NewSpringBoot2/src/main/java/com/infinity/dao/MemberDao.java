package com.infinity.dao;

import java.util.List;

import com.infinity.model.Member;

public interface MemberDao{

	void saveMember(Member member);

	void updateMember(Member member);

	void deleteMember(Integer id);

	List<Member> findMember(Member member);
	
	List<Member> loginMember(Member member);

}