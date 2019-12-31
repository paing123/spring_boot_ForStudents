package com.infinity.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.infinity.dao.MemberDao;
import com.infinity.model.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	//spring security
	public void saveMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.setRole("ROLE_MEMBER");
		member.setEnable(true);
		memberDao.saveMember(member);
	}

	public void updateMember(Member member) {
		memberDao.updateMember(member);
	}

	public void deleteMember(Integer id) {
		memberDao.deleteMember(id);
	}

	public List<Member> findMember(Member member) {
		List<Member> members = memberDao.findMember(member);
		return members;
	}

	//spring security
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Member member = findMemberByLogin(login);
		if (member == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	    String role = member.getRole();
	    grantedAuthorities.add(new SimpleGrantedAuthority(role));
	    return new org.springframework.security.core.userdetails.User(member.getLogin(), member.getPassword(), grantedAuthorities);
	}
	
	//spring security
	public Member findMemberByLogin(String login) {
		Member member = new Member();
		member.setLogin(login);
		member = memberDao.loginMember(member).get(0);
		return member;
	}
}