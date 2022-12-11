package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A `RestController` that maps to the `/voucher` endpoint and provides
 * methods to access and manipulate a `JsonTable` of `Voucher` objects.
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    /**
     * A `JsonTable` of `Voucher` objects that is populated from a JSON file.
     */
    @JsonAutowired(value = Voucher.class, filepath = "json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    /**
     * Returns the `JsonTable` of `Voucher` objects.
     *
     * @return the `JsonTable` of `Voucher` objects
     */
    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    /**
     * Returns a boolean indicating whether a `Voucher` with the given `id`
     * has been used or not.
     *
     * @param id the ID of the `Voucher` to check
     * @return a boolean indicating whether the `Voucher` has been used
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id)
    {
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }

    /**
     * Determines if a voucher with the given id can be applied to the given price.
     *
     * @param id The id of the voucher.
     * @param price The price to apply the voucher to.
     * @return True if the voucher can be applied to the given price, false otherwise.
     */
    @GetMapping("/{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            )
    {
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }

    /**
     * Returns a paginated list of available vouchers.
     *
     * @param page The page number.
     * @param pageSize The number of vouchers per page.
     * @return A paginated list of available vouchers.
     */
    @GetMapping("/getAvailable")
    List<Voucher> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
    }
}