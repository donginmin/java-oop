package com.bitcamp.services;

import com.bitcamp.domains.MemberBean;

public class MemberService {
	private MemberBean[] members;
	private int count;

	public MemberService() {
		members = new MemberBean[2];
		count = 0;
	}

	public String join(MemberBean param) {
		String msg = "가입성공";
		members[count] = param;
		count++;
		return msg;
	}

	public String getMypage(MemberBean param) {
		return param.toString();
	}

	public String changePw(MemberBean param) {
		String msg = "비밀번호 변경";
		String id = param.getId();
		String pw = param.getPw();
		String[] pws = pw.split(",");
		String oldPw = pws[0];
		String newPw = pws[1];

		for (int i = 0; i < count; i++) {
			if (param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw())) {
				members[i].setPw(newPw);
				break;
			}
		}
		return msg;
	}

	public String widthdraw(MemberBean param) {
		String msg = "탈퇴";
		return msg;
	}

	public String existId(String id) {
		String msg = "가입가능아이디";
		for (int i = 0; i < count; i++) {
			if (id.equals(members[i].getId())) {
				msg = "이미존재";
				break;
			}
		}
		return msg;
	}

	public String login(MemberBean param) {
		String msg = "로그인실패";
		String id = param.getId();
		String pw = param.getPw();
		for (int i = 0; i < count; i++) {
			if (param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw())) {
				msg = "로그인성공";
				break;
			}
		}

		return msg;
	}

	public String list() {
		String msg = "회원목록";
		for (int i = 0; i < count; i++) {
			msg += members[i].toString() + ",\n";
		}
		return msg;
	}

	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for (int i = 0; i < count; i++) {
			if (id.equals(members[i].getId())) {
				member = members[i];
				break;
			}
		}
		return member;
	}

	public MemberBean[] findByName(String name) {
		int sameName = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(this.members[i].getName())) {
				sameName++;
			}
		}
		MemberBean[] members = new MemberBean[sameName];
		int j = 0;
		for (int i = -0; i < count; i++) {
			if (name.equals(this.members[i].getName())) {
				members[j] = this.members[i];
				j++;

				if (members.length == j) {
					break;
				}
			}
		}
		return members;
	}

	public String countAll() {
		return String.valueOf(count);
	}
}

