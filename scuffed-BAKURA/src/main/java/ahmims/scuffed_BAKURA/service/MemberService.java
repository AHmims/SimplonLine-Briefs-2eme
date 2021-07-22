package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberService {
    Member save(Member member);

    Member getByEmail(String email);
}
