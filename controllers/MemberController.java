package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member = null;
		String[] arr = null;
		String temp = "";
		
		while (true) {
			switch(JOptionPane.showInputDialog("0 종료 1 회원가입 2 마이페이지 3비번수정 4 5 6 7")) {
			case "0": return;
			case "1":
				String spec = JOptionPane.showInputDialog("이름,아이디,비밀번호,주민번호,혈액형,키,몸무게"); 
				System.out.println("*****" + spec);
				arr = spec.split(",");
				member = new MemberBean();
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				JOptionPane.showMessageDialog(null, service.join(member)); 

				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.getMypage(member));
				break;
			case "3":
				temp = JOptionPane.showInputDialog("id, 현재비번, 변경할비번");
				arr = temp.split(",");
				member = new MemberBean(); 
				member.setId(arr[0]);
				member.setPw(arr[1]+","+arr[2]);
				JOptionPane.showMessageDialog(null, service.changePw(member));
				break;
			case "4":
				break;
			case "5":
				JOptionPane.showInputDialog(null, service.list());
				break;
			case "6":
				String searchId = JOptionPane.showInputDialog("검색 ID");
				member = service.findById(searchId);
				JOptionPane.showMessageDialog(null, member);

				break;
			case "7":
				String loginValue = JOptionPane.showInputDialog("로그인 ID,pw");
				String[] loginValues = loginValue.split(",");
				String loginId = loginValues[0];
				String loginPw = loginValues[1];
				member = new MemberBean(); 
				member.setId(loginPw);
				member.setPw(loginPw);
				String msg = service.login(member);
				JOptionPane.showMessageDialog(null, msg);

				break;
			}
			
		}

	}

}
