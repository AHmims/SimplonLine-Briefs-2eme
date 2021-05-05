package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CouponDao;
import ahmims.BasmaOnlineStore.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CouponService")
public class CouponServiceImpl implements CouponService {
    private final CouponDao couponDao;

    public CouponServiceImpl(CouponDao couponDao) {
        this.couponDao = couponDao;
    }
}
