package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository = new MemoryMemberRepository();
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
