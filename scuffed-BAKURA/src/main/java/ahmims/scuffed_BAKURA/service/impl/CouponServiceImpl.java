package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dao.CouponDao;
import ahmims.scuffed_BAKURA.service.CouponService;
import org.springframework.stereotype.Service;

@Service("CouponService")
public class CouponServiceImpl implements CouponService {
    private final CouponDao couponDao;

    public CouponServiceImpl(CouponDao couponDao) {
        this.couponDao = couponDao;
    }
}
