package com.example.ichsan.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ichsan.demo.model.Todo;
import com.example.ichsan.demo.model.User;
import com.example.ichsan.demo.repository.UserRepository;
import com.example.ichsan.demo.service.TodoServices;

@Controller
public class ToDoController {

    @Autowired
    private TodoServices todoServices;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/todos")
    public String home(Model model,
                       @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) return "redirect:/login";

        Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
        if (optionalUser.isEmpty()) return "redirect:/login";

        User user = optionalUser.get();
        List<Todo> unfinished = todoServices.getTodoByStatusAndUser(0, user);
        List<Todo> finished = todoServices.getTodoByStatusAndUser(1, user);

        model.addAttribute("todos", unfinished);
        model.addAttribute("finishedTodos", finished);
        model.addAttribute("name", user.getName());

        return "index";
    }

    @PostMapping("/todos/create")
    public String addTodo(@RequestParam String task,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline,
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails) {

        Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
        if (optionalUser.isEmpty()) {
            return "redirect:/login";
        }

        Todo todo = new Todo();
        todo.setTask(task);
        todo.setState(0);
        todo.setDate(deadline);
        todo.setUser(optionalUser.get());

        todoServices.saveTodo(todo);
        return "redirect:/todos";
    }

        @PostMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoServices.deleteTodo(id);
        return "redirect:/todos";
    }

    @PostMapping("/done/{id}")
    public String markAsDone(@PathVariable Long id) {
        todoServices.markAsDone(id);
        return "redirect:/todos";
    }

        @PostMapping("/undo")
    public String undoTodo(@RequestParam Long id, @RequestParam(required = false) String task,
    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline) {
        Todo todoOptional = todoServices.getTodoById(id);

        if (todoOptional != null) {
            todoOptional.setDate(deadline);
            todoOptional.setState(0);
            todoServices.saveTodo(todoOptional);
        }

        return "redirect:/todos";
    }
}
