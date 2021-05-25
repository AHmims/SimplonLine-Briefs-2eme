package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.CouponFormData;
import ahmims.BasmaOnlineStore.dto.CouponMin;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponService {
    public CouponMin insert(CouponFormData payload);
}
