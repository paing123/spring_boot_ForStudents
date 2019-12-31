package com.infinity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infinity.mapper.MemberMapper;
import com.infinity.model.Member;

@Repository("memberRepository")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	MemberMapper memberMapper;

	public void saveMember(Member member) {
		memberMapper.saveMember(member);
	}

	public void updateMember(Member member) {
		memberMapper.updateMember(member);
	}

	public void deleteMember(Integer id) {
		memberMapper.deleteMember(id);
	}

	public List<Member> findMember(Member member) {
		List<Member> members = memberMapper.findMember(member);
		return members;
	}

	@Override
	public List<Member> loginMember(Member member) {
		List<Member> members = memberMapper.loginMember(member);
		return members;
	}
}