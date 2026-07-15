package com.example.hotelbooking_app.Service;

import com.example.hotelbooking_app.entity.Room;
import com.example.hotelbooking_app.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    // அனைத்து அறைகளையும் பெற
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // ஒரு குறிப்பிட்ட ஹோட்டலின் அறைகளைப் பெற
    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    // புதிய அறையைச் சேர்க்க
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    // அறையை நீக்க
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}