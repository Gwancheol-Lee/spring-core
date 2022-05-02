package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	// private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	// 위와 같이 할인 정책을 변경하려면 클라이언트인 OrderServiceImpl 객체 코드를 변경해야하는 문제 발생. DIP, OCP 위반
	private DiscountPolicy discountPolicy; // 인터페이스에만 의존하도록 변경 
	
	// 구현체 클래스인 OrderServiceImpl에서 추상화 클래스인 OrderService의 추상적으로 선언된 createOrder 메소드를 실제 구현한다.
	@Override
	public Order createOrder(Long MemberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(MemberId);
		// 할인 정책이 바뀌면 discountPolicy만 수정하면 된다. 해당 Member Grade가 VIP이면 1000원 할인
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(MemberId, itemName, itemPrice, discountPrice);
	}
}
