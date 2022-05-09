package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
	// MemberApp run -> 아래 코드 실행
	public static void main(String[] args) {
		
		// AppConfig 선언
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService(); 

		// AppConfig의 환경 설정을 스프링 컨테이너에 빈 등록 
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP); // Member 클래스 선언 및 생성자 변수값 주입
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find member = " + findMember.getName());
	}
}
