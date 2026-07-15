package com.example.hotelbooking_app.Controller; // இதுதான் உங்கள் பேக்கேஜ் பெயர் எனில்

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hotelbooking_app.entity.Room;
import com.example.hotelbooking_app.Repository.RoomRepository; // இங்கேதான் பிழை வருகிறது

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Room> getRoomsByHotel(@PathVariable Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
}