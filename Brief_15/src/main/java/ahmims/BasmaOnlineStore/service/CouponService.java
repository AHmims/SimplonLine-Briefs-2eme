package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.CouponFormData;
import ahmims.BasmaOnlineStore.dto.CouponMin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponService {
    CouponMin insert(CouponFormData payload);

    List<CouponMin> getAll();
}
