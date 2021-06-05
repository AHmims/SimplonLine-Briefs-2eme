package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Coupon;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("CouponRepository")
public interface CouponRepository extends Repository<Coupon,String> {
    Coupon findTopByCodeCoupon(String CodeCoupon);
}
