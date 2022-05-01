package hello.core.member;

// Model Repository 추상화 객체
public interface MemberRepository {
	
	void save(Member memver);
	
	Member findById(Long memberId);
}
