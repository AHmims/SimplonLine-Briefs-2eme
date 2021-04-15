package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CouponDao")
public interface CouponDao extends CrudRepository<Coupon, String> {
}
