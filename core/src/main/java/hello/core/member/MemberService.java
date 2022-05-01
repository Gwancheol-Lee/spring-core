package hello.core.member;

// Service 추상화 객체
public interface MemberService {

	void join(Member member);
	
	Member findMember(Long memberId);
}
