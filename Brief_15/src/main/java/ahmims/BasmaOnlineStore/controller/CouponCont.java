package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.CouponFormData;
import ahmims.BasmaOnlineStore.dto.CouponMin;
import ahmims.BasmaOnlineStore.dto.ProduitFormData;
import ahmims.BasmaOnlineStore.dto.ProduitMin;
import ahmims.BasmaOnlineStore.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coupon")
public class CouponCont {
    //#region
    private final CouponService couponService;

    public CouponCont(CouponService couponService) {
        this.couponService = couponService;
    }
    //#endregion
    //Add coupon
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<CouponMin> addCoupon(@RequestBody CouponFormData payload) {
        return new ResponseEntity<>(couponService.insert(payload), HttpStatus.valueOf(200));
    }
}
