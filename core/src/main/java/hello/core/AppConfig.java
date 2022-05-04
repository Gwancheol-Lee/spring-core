package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
public class AppConfig {
	
	// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다
	
	// MemberService 인터페이스에 MemberServiceImpl 구현 클래스 주입
	public MemberService memberService( ) {
		return new MemberServiceImpl(memberRepository());
	}
	
	// MemberRepository 인터페이스에 MemoryMemberRepository 구현 클래스 주입
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	// OrderService 인터페이스에 OrderServiceImpl 구현 클래스 주입
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	// DiscountPolicy 인터페이스에 FixDiscountPolicy 구현 클래스 주입
	public DiscountPolicy discountPolicy() {
		// return new FixDiscountPolicy();
		 return new RateDiscountPolicy();
	}
}
