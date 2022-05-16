package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		// Thread A :  A 사용자 10000원 주문
		statefulService1.order("userA", 10000);
		// Thread B :  B 사용자 10000원 주문
		statefulService2.order("userB", 20000);
		
		// Thread A :  사용자 A 주문 금액 조회
		int price = statefulService1.getPrice();
		System.out.println("price = " + price);
		
		// 사용자 A getPrice = 10000 이어야 하는데 같은 객체를 공유하기 때문에 20000원으로 조회된다.
		assertThat(statefulService1.getPrice()).isEqualTo(20000);
	}
	
	static class TestConfig {
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
