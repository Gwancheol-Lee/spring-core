package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// @Component 어노테이션이 선언된 빈을 스캔해서 자동으로 등록해줌
// @Configuration 어노테이션을 제외한 컴포넌트 스캔(Configuration 안에 Component 어노테이션이 선언된 클래스가 존재함)
@ComponentScan(
		// 탐색할 패키지의 시작 위치를 지정한다. 지정하지 않으면 모든 패키지를 조회하기 때문에 필수로 지정해주어야 한다.
		// 권장하는 방법은. 패키지 위치를 지정하지 않고, AppConfig 클래스를 프로젝트 최상단(hello.core)에 둔다.
		/*
		 @SpringBootApplication에 @ComponentScan 어노테이션이 있으며, 아래 어노테이션을 포함하여 스캔.
		 
		  @Component: 컴포넌트 스캔에서 사용, 
		  @Controller: 스프링 MVC 컨트롤러에서 사용, MVC 컨트롤러로 인식 
		  @Service: 스프링 비즈니스 로직에서 사용, 특별한 처리는 하지 않는다. 핵심 비즈니스 로직이 여기에 있다는걸 인식하는데 도움을 준다.
		  @Repository: 스프링 데이터 접근 계층에서 사용, 데이터 계층의 예외를 스프링 예외로 변환해줌.
		  @Configuration: 스프링 설정 정보에서 사용, 스프링 설정 정보로 인식하고 스프링 빈이 싱글톤을 유지하도록 추가 처리를 한다.
		 
		*/
		basePackages = "hello.core.member", 
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
@Configuration
public class AutoAppConfig {
	
}
