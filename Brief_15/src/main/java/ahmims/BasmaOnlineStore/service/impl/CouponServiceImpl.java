package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CouponDao;
import ahmims.BasmaOnlineStore.dto.*;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Coupon;
import ahmims.BasmaOnlineStore.repository.CouponRepository;
import ahmims.BasmaOnlineStore.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CouponService")
public class CouponServiceImpl implements CouponService {
    //#region
    private final CouponDao couponDao;
    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponDao couponDao, CouponRepository couponRepository) {
        this.couponDao = couponDao;
        this.couponRepository = couponRepository;
    }

    //#endregion
    @Override
    public CouponMin insert(CouponFormData payload) {
        if (payload != null && payload.isInsertable()) {
            Coupon originalCoupon = couponRepository.findTopByCodeCoupon(payload.getCode());
            if (originalCoupon != null)
                throw new RequestException("There is a Coupon that already exists with the same code", HttpStatus.BAD_REQUEST);
            //
            Coupon coupon = new Coupon(payload.getCode(), payload.getRemise(), new Date(), payload.getDateExpiration(), payload.isActive(), null);
            coupon = couponDao.save(coupon);

            return coupon.getIdCoupon() != null ? new CouponMin(coupon) : null;
        } else
            throw new RequestException("Some of the Coupon's main data is missing or bad-formatted", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public List<CouponMin> getAll() {
        List<CouponMin> coupons = new ArrayList<>();
        for (Coupon coupon : couponDao.findAll()) {
            coupons.add(new CouponMin(coupon));
        }
        //
        return coupons.size() > 0 ? coupons : null;
    }
}
