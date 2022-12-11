package com.StefanAgustoHutapeaJSleepDN.controller;
import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Javadoc
 * @author Stefan Agusto Hutapea
 */
/**
 * This interface defines a basic controller for accessing data in a {@link JsonTable}.
 *
 * @param <T> the type of data stored in the table
 */
@RestController
@RequestMapping("/account")
public interface BasicGetController<T extends Serializable> {
    /**
     * Returns the {@link JsonTable} that this controller is using.
     *
     * @return the table
     */
    public abstract JsonTable<T> getJsonTable();
    /**
     * Gets the data with the specified ID from the table.
     *
     * @param id the ID of the data to retrieve
     * @return the data with the specified ID, or null if no such data exists
     */
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        Predicate<T> predicate = object -> object.id == id;
        return Algorithm.find(getJsonTable(), predicate);
    }
    /**
     * Gets a paginated list of data from the table.
     *
     * @param page the page number to retrieve
     * @param pageSize the number of items per page
     * @return a paginated list of data
     */
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}