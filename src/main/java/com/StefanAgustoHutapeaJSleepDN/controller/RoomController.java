package com.StefanAgustoHutapeaJSleepDN.controller;


import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Javadoc
 * @author Stefan Agusto Hutapea
 */

//inheritance from BasicGetController<Room>
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    /**
     * This is a static variable that stores the JSON table of rooms.
     * It is autowired with the Room class and the "json/room.json" filepath.
     */
    @JsonAutowired(value = Room.class, filepath = "json/room.json")
    public static JsonTable<Room> roomTable;
    /**
     * This method maps the index method to the GET /room path.
     * It returns the string "room page".
     *
     * @return a string representing the room page.
     */

    @GetMapping
    String index() {
        return "room page";
    }

    /**
     * This method gets the JSON table of rooms.
     *
     * @return the JSON table of rooms.
     */
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    /**
     * This method maps the GET /room/{id}/renter path.
     * It gets a paginated list of rooms by renter ID.
     *
     * @param id the ID of the renter.
     * @param page the page number of the paginated list.
     * @param pageSize the page size of the paginated list.
     *
     * @return a paginated list of rooms by renter ID.
     */
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

    /**
     * This method handles HTTP POST requests to the "/create" endpoint.
     *
     * @param accountId the ID of the account associated with the room
     * @param name the name of the room
     * @param size the size of the room
     * @param price the price of the room
     * @param facility a list of facilities provided in the room
     * @param city the city where the room is located
     * @param address the address of the room
     * @param bedType the type of bed in the room
     * @return the created Room object, or null if the account associated with the room is not valid
     */
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

    /**
     * Returns a paginated list of all rooms.
     *
     * @param page the page number (1-based index)
     * @param pageSize the number of items per page
     * @return the paginated list of rooms
     */
    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(@RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }
    /**
     * Deletes a room with the given id.
     *
     * @param id the id of the room to delete
     * @return true if the room was deleted, false if no room with the given id was found
     */
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