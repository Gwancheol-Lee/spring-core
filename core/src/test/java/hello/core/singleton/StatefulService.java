package hello.core.singleton;

public class StatefulService {

	private int price; // 상태를 유지하는 필드
	
	public void order(String name, int price) {
		System.out.println("name = " + name + " price = " + price);
		this.price = price; // 여기가 문제!
	}
	
	// price 지역변수를 구체화 객체에 선언 및 관리하면 무결성 상태를 유지할 수 없음. 구현체 객체는 무조건 결과값을 return 처리 해주자. 
	public int getPrice() { 
		return price;
	}
}
