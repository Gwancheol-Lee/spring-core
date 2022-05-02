package hello.core.order;

public class Order {

	private Long memberId;
	private String itemName;
	private int itemPrice;
	private int discountPrice;
	
	// Order 생성자 선언
	public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
		super();
		this.memberId = memberId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}
	
	// 할인 금액 계산 메소드
	public int calculatePrice() {
		return itemPrice - discountPrice;
	}
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Override
	public String toString() { // Order 생성자를 보기 쉽게 아래 String 형태로 변환 및 리턴 
		return "Order {memberId=" + memberId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", discountPrice=" + discountPrice + "}";
	}
	
	
}
