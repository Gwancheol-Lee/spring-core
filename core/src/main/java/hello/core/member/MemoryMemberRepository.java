package hello.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository {
	// store 객체 선언
	private static Map<Long, Member> store = new HashMap<>();
	
	// MemberRepository 인터페이스를 구현한다. 
	// Override : 부모 클래스(MemberService)의 메서드를 자식클래스(MemberServiceImpl)에서 재 선언 후 사용한다는 걸 명시해주는 어노테이션.  
	@Override
	public void save(Member member) {
		store.put(member.getId(), member);		
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}
}
