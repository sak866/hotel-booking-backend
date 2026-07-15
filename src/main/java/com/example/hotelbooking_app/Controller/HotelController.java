package com.example.hotelbooking_app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hotelbooking_app.entity.Hotel;
import com.example.hotelbooking_app.entity.Room;
import com.example.hotelbooking_app.Service.HotelService;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // அனைத்து ஹோட்டல்களையும் பெற: GET http://localhost:8080/api/hotels
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // லொகேஷன் மூலம் தேட: GET http://localhost:8080/api/hotels/search?location=chennai
    @GetMapping("/search")
    public List<Hotel> searchHotels(@RequestParam String location) {
        return hotelService.searchHotelsByLocation(location);
    }

    // புது ஹோட்டல் சேர்க்க: POST http://localhost:8080/api/hotels/add
    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    // புது அறை சேர்க்க: POST http://localhost:8080/api/hotels/rooms/add
    @PostMapping("/rooms/add")
    public Room addRoom(@RequestBody Room room) {
        return hotelService.addRoom(room);
    }

    // ஹோட்டல் ID மூலம் அறைகளைப் பெற: GET http://localhost:8080/api/hotels/{hotelId}/rooms
    @GetMapping("/{hotelId}/rooms")
    public List<Room> getRoomsByHotel(@PathVariable Long hotelId) {
        return hotelService.getRoomsByHotel(hotelId);
    }
}
