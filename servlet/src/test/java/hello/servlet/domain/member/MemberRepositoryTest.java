package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        // 테스트 각각 독립적으로 실행하기 위해 추가
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("kim", 26);
        
        // when
        Member savedMember  = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findbyId(member.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("kim", 26);
        Member member2 = new Member("zzang", 26);
        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
