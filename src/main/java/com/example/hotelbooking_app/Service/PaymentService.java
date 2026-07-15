package com.example.hotelbooking_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotelbooking_app.entity.Payment;
import com.example.hotelbooking_app.Repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setStatus("SUCCESS");
        return paymentRepository.save(payment);
    }
}