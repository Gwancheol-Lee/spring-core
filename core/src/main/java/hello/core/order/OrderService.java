package hello.core.order;

public interface OrderService {
	
	// 회원 주문 메소드
	Order createOrder(Long MemberId, String itemName, int itemPrice);
}
