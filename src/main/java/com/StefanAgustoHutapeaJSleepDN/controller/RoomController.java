package com.StefanAgustoHutapeaJSleepDN.controller;


import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//inheritance from BasicGetController<Room>
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class, filepath = "json/room.json")
    public static JsonTable<Room> roomTable;

    @GetMapping
    String index() {
        return "room page";
    }

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == accountId);
        if(account != null || account.renter != null){
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            roomTable.add(room);
            return room;
        }else{
            return null;
        }
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(@RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    @DeleteMapping("/{id}/deleteRoom")
    public boolean deleteRoom(@PathVariable int id){
        Room room = Algorithm.<Room>find(getJsonTable(), pred -> pred.id == id);
        if(room != null){
            getJsonTable().remove(room);
            return true;
        }else{
            return false;
        }
    }
}