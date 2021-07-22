package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("MemberRepository")
public interface MemberRepository extends JpaRepository<Member, String> {
    Member findTopByEmailUtilisateur(String email);
}
