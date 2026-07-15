package com.example.hotelbooking_app.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hotelbooking_app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // மின்னஞ்சல் முகவரியை வைத்து பயனரைத் தேட இது உதவும் (Login-க்கு தேவைப்படும்)
    Optional<User> findByEmail(String email);
}