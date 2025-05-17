package com.example.ichsan.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ichsan.demo.model.User;
import com.example.ichsan.demo.repository.UserRepository;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUser() { return userRepository.findAll(); }

    public Optional<User> getUserById(String id) { return userRepository.findById(id); }

    public void saveUser(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(idUser());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        userRepository.save(user);
    }

    public void deleteUser(String id) { userRepository.deleteById(id); }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private String idUser() {
        Random random = new Random();
        int idRandom = random.nextInt(1000);
        return "us" + idRandom;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
