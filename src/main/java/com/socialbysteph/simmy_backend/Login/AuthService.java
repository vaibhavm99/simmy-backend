//package com.socialbysteph.simmy_backend.Login;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//    private final PasswordEncoder passwordEncoder;
//
//
//    public AuthService() {
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    public String hashPassword(String plainPassword) {
//        return passwordEncoder.encode(plainPassword);
//    }
//
//    public boolean checkPassword(String plainPassword, String hashedPassword) {
//        return passwordEncoder.matches(plainPassword, hashedPassword);
//    }
//}
