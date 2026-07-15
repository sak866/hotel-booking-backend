package com.example.hotelbooking_app.Repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.hotelbooking_app.entity.HotelBooking;

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {

    List<HotelBooking> findByUserId(Long userId);

    // ஒரு அறை குறிப்பிட்ட தேதிகளில் ஏற்கனவே புக் செய்யப்பட்டுள்ளதா என சரிபார்க்க
    @Query("SELECT COUNT(b) > 0 FROM HotelBooking b WHERE b.room.id = :roomId " +
           "AND b.status = 'CONFIRMED' " +
           "AND (:checkInDate < b.checkOutDate AND :checkOutDate > b.checkInDate)")
    boolean isRoomAlreadyBooked(@Param("roomId") Long roomId, 
                                @Param("checkInDate") LocalDate checkInDate, 
                                @Param("checkOutDate") LocalDate checkOutDate);
}