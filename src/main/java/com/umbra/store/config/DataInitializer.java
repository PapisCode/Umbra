package com.umbra.store.config;

import com.umbra.store.entity.Role;
import com.umbra.store.entity.User;
import com.umbra.store.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner seedUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole(Role.ADMIN);
                userRepository.save(admin);
            }

            if (!userRepository.existsByUsername("staff")) {
                User staff = new User();
                staff.setUsername("staff");
                staff.setPassword(passwordEncoder.encode("staff123"));
                staff.setRole(Role.STAFF);
                userRepository.save(staff);
            }

            if (!userRepository.existsByUsername("customer")) {
                User customer = new User();
                customer.setUsername("customer");
                customer.setPassword(passwordEncoder.encode("customer123"));
                customer.setRole(Role.CUSTOMER);
                userRepository.save(customer);
            }
        };
    }
}