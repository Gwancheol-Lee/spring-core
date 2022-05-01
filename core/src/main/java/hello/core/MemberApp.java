package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
	// MemberApp run -> 아래 코드 실행
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl(); // MemberService 구현체 클래스 선언
		Member member = new Member(1L, "memberA", Grade.VIP); // Member 클래스 선언 및 생성자 변수값 주입
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find member = " + findMember.getName());
	}
}
