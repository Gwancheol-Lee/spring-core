package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))//@Component 어노테이션이 선언된 빈을 스캔해서 자동으로 등록해줌 
public class AutoAppConfig {
	
}
