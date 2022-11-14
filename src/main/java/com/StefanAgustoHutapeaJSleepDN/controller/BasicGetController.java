package com.StefanAgustoHutapeaJSleepDN.controller;
import com.StefanAgustoHutapeaJSleepDN.Algorithm;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import com.StefanAgustoHutapeaJSleepDN.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public interface BasicGetController<T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();
    @GetMapping("/page")
    public default List<T> getPage
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        final JsonTable<T> table = getJsonTable();
        return Algorithm.paginate(table, page, pageSize, o -> true);
    }

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
    }
}