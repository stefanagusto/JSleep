package com.StefanAgustoHutapeaJSleepDN.controller;
import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public interface BasicGetController<T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        Predicate<T> predicate = object -> object.id == id;
        return Algorithm.find(getJsonTable(), predicate);
    }

    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}