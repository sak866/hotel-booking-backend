package com.example.hotelbooking_app.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotelbooking_app.entity.User;
import com.example.hotelbooking_app.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // புது பயனரை பதிவு செய்ய (Register)
    public User registerUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("இந்த மின்னஞ்சல் ஏற்கனவே பதிவு செய்யப்பட்டுள்ளது!");
        }
        // குறிப்பு: GUVI பாதுகாப்பு விதிப்படி பின்னாட்களில் இங்கு Password Encoder சேர்க்கலாம்
        user.setRole("ROLE_USER"); // Default role
        return userRepository.save(user);
    }

    // லாகின் செய்ய (Login)
    public Optional<User> loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password));
    }
}
