package org.zerock.domain;

import java.util.List;

public class UserVO {

	private String userid, userpw, userName, role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpw=" + userpw + ", userName=" + userName + ", role=" + role + "]";
	}

}
