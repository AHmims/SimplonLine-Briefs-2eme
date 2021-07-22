package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CouponDao")
public interface CouponDao extends CrudRepository<Coupon, String> {
}
