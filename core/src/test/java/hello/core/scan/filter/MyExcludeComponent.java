package hello.core.scan.filter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 @Target = Annotation이 어디에 적용될지 결정하기 위해 사용한다.
 	ElementType.PACKAGE : 패키지 선언
	ElementType.TYPE : 타입 선언
	ElementType.ANNOTATION_TYPE : 어노테이션 타입 선언
	ElementType.CONSTRUCTOR : 생성자 선언
	ElementType.FIELD : 멤버 변수 선언
	ElementType.LOCAL_VARIABLE : 지역 변수 선언
	ElementType.METHOD : 메서드 선언
	ElementType.PARAMETER : 전달인자 선언
	ElementType.TYPE_PARAMETER : 전달인자 타입 선언
	ElementType.TYPE_USE : 타입 선언
	
 @Retention = Annotation이 실제로 적용되고 유지되는 범위를 의미한다. Policy에 관련된 Annotation으로 컴파일 이후에도 JVM에서 참조가 가능한 RUNTIME으로 지정한다.
 	RetentionPolicy.RUNTIME : 컴파일 이후에도 JVM에 의해 계속 참조 가능. 주로 리플렉션이나 로깅에 많이 사용됨.
 	RetentionPolicy.CLASS : 컴파일라거 클래스를 참조할 때까지 유효함.
 	RetentionPolicy.SOURCE : 컴파일 전까지만 유효함. 즉 컴파일 이후에는 사라짐.
 
 @Documented = javadoc 문서 생성시 현재 어노테이션 설명을 추가해서 생성한다는 어노테이션. 아래 3개 어노테이션은 짝꿍이라고 보면 된다.
*/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
