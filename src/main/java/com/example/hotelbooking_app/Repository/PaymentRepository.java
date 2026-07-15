package com.example.hotelbooking_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hotelbooking_app.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
