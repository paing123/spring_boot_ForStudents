package com.infinity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.infinity.model.Member;

@Mapper
public interface MemberMapper{

	public void saveMember(@Param("member") Member member);

	public void updateMember(@Param("member") Member member);

	public void deleteMember(@Param("id") Integer id);

	public List<Member> findMember(@Param("member") Member member);
	
	public List<Member> loginMember(@Param("member") Member member);

}