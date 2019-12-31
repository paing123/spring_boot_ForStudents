package com.infinity.model;

public class Member{
	public Integer memberId;
	public String memberName;
	public boolean enable;
	public String role;
	public String login;
	public String password;
	
	public void setMemberId(Integer memberId){
		this.memberId=memberId;
	}

	public Integer getMemberId(){
		return memberId;
	}

	public void setMemberName(String memberName){
		this.memberName=memberName;
	}

	public String getMemberName(){
		return memberName;
	}

	public void setLogin(String login){
		this.login=login;
	}

	public String getLogin(){
		return login;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}