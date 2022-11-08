package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.Algorithm;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import com.StefanAgustoHutapeaJSleepDN.dbjson.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account")
public interface BasicGetController <T extends Serializable> {
    @GetMapping("/person")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    )
    {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred->true);
    }

    @GetMapping("/person/{id}")
    public default T getById(
            @PathVariable int id
    )
    {
        //Request Method GET will return object T with id
        return (T)Algorithm.<T>find(getJsonTable(), pred->pred.id==id);
    }

    //Method getPage and getById will refer to collection from getJsonTable() method and use Algorithm to get the data
    public abstract JsonTable<T> getJsonTable();


}
