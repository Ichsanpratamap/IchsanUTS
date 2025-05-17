package com.example.ichsan.demo.repository;

import com.example.ichsan.demo.model.Todo;
import com.example.ichsan.demo.model.User;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> 
    
    findByUser(User user); 

    List<Todo> findByState(int state);

    List<Todo> findByDate(LocalDate date);

    List<Todo> findByStateAndUser(int state, User user);
}
