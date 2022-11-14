package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.Voucher;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value = Voucher.class, filepath = "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\src\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("/voucher/{id}/isUsed")
    boolean isUsed(@PathVariable int id)
    {
        return false;
    }
    @GetMapping("/voucher/{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            )
    {
        return false;
    }
    @GetMapping("/voucher/getAvailable")
    List<Voucher> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return null;
    }
}