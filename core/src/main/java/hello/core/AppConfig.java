package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션 설정 정보 어노테이션
@Configuration
public class AppConfig {
	
	// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다
	
	// 스프링 컨테이너에 등록됨
	@Bean
	public MemberService memberService( ) {
		return new MemberServiceImpl(memberRepository());
	}
	
	// MemberRepository 인터페이스에 MemoryMemberRepository 구현 클래스 주입
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	// OrderService 인터페이스에 OrderServiceImpl 구현 클래스 주입
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	// DiscountPolicy 인터페이스에 FixDiscountPolicy 구현 클래스 주입
	@Bean
	public DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		 return new RateDiscountPolicy();
	}
}
