package com.example.hotelbooking_app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotelbooking_app.entity.HotelBooking;
import com.example.hotelbooking_app.Repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public HotelBooking createBooking(HotelBooking booking) {
        boolean isAlreadyBooked = bookingRepository.isRoomAlreadyBooked(
                booking.getRoom().getId(), 
                booking.getCheckInDate(), 
                booking.getCheckOutDate()
        );

        if (isAlreadyBooked) {
            throw new RuntimeException("மன்னிக்கவும்! நீங்கள் தேர்ந்தெடுத்த தேதிகளில் இந்த அறை ஏற்கனவே முன்பதிவு செய்யப்பட்டுள்ளது.");
        }

        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    public List<HotelBooking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public HotelBooking cancelBooking(Long bookingId) {
        HotelBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("முன்பதிவு விவரங்கள் எதுவும் கிடைக்கவில்லை!"));
        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }
}