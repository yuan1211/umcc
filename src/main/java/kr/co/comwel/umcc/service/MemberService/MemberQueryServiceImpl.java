package kr.co.comwel.umcc.service.MemberService;


import jakarta.transaction.Transactional;
import kr.co.comwel.umcc.domain.Member;
import kr.co.comwel.umcc.repository.MemberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> findMember(Long id){
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findMemberAll(String name, Integer point,
                                     String email, LocalDate birth, String address){
        List<Member> filteredMembers = memberRepository.dynamicQueryWithBooleanBuilder(name, point, email, birth, address);

        filteredMembers.forEach(member -> System.out.println("Member: " + member));

        return filteredMembers;
    }
}

