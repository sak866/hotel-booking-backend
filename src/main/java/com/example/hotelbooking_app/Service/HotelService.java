package com.example.hotelbooking_app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotelbooking_app.entity.Hotel;
import com.example.hotelbooking_app.entity.Room;
import com.example.hotelbooking_app.Repository.HotelRepository;
import com.example.hotelbooking_app.Repository.RoomRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public List<Hotel> searchHotelsByLocation(String location) {
        return hotelRepository.findByLocationContainingIgnoreCase(location);
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getRoomsByHotel(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
}