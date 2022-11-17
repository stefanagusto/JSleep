package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value = Voucher.class, filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("/voucher/{id}/isUsed")
    boolean isUsed(@PathVariable int id)
    {
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }
    @GetMapping("/voucher/{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            )
    {
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }
    @GetMapping("/voucher/getAvailable")
    List<Voucher> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
    }
}