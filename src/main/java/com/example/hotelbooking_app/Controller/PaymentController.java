package com.example.hotelbooking_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.hotelbooking_app.entity.Payment;
import com.example.hotelbooking_app.Service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // பேமெண்ட் பிராசஸ் செய்ய: POST http://localhost:8080/api/payments/process
    @PostMapping("/process")
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }
}