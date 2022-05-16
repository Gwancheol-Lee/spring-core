package hello.core.member;

public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	
	// 생성자
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	// MemberService 인터페이스를 구현한다. 
	// Override : 부모 클래스(MemberService)의 메서드를 자식클래스(MemberServiceImpl)에서 재 선언 후 사용한다는 걸 명시해주는 어노테이션.  
	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}
	
	// 테스트 용도
	public MemberRepository getMemberRepository() { 
		return memberRepository;
	}
}
