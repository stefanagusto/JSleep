package com.StefanAgustoHutapeaJSleepDN.controller;


import com.StefanAgustoHutapeaJSleepDN.City;
import com.StefanAgustoHutapeaJSleepDN.Facility;
import com.StefanAgustoHutapeaJSleepDN.Room;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//inheritance from BasicGetController<Room>
public class RoomController implements BasicGetController<Room> {
    //override method getJsonTable() from BasicGetController<Room>
    @JsonAutowired(value = Room.class, filepath = "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\src\\json\\room.json")
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/room/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return null;
    }

    @PostMapping("/room/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
            )
    {
        return null;
    }
}
