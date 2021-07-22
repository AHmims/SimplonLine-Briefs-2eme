package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.model.Member;
import ahmims.scuffed_BAKURA.repository.MemberRepository;
import ahmims.scuffed_BAKURA.service.MemberService;
import org.springframework.stereotype.Service;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
    private final MemberRepository MemberRepository;

    public MemberServiceImpl(MemberRepository MemberRepository) {
        this.MemberRepository = MemberRepository;
    }

    @Override
    public Member save(Member member) {
        try {
            return MemberRepository.save(member);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Member getByEmail(String email) {
        return MemberRepository.findTopByEmailUtilisateur(email);
    }
}
