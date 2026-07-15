package com.example.hotelbooking_app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hotelbooking_app.entity.HotelBooking;
import com.example.hotelbooking_app.Service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // புது புக்கிங் செய்ய: POST http://localhost:8080/api/bookings/create
    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody HotelBooking booking) {
        try {
            HotelBooking newBooking = bookingService.createBooking(booking);
            return ResponseEntity.ok(newBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // பயனர் செய்த புக்கிங்குகளைப் பார்க்க: GET http://localhost:8080/api/bookings/user/{userId}
    @GetMapping("/user/{userId}")
    public List<HotelBooking> getUserBookings(@PathVariable Long userId) {
        return bookingService.getUserBookings(userId);
    }

    // புக்கிங் கேன்சல் செய்ய: PUT http://localhost:8080/api/bookings/cancel/{bookingId}
    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
        try {
            HotelBooking cancelledBooking = bookingService.cancelBooking(bookingId);
            return ResponseEntity.ok(cancelledBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}