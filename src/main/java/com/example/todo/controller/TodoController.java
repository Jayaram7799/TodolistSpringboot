/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoH2Service;

import java.util.ArrayList;

@RestController
public class TodoController {

    @Autowired
    private TodoH2Service todoService;

    // API 1: GET all todos
    @GetMapping("/todos")
    public ArrayList<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // API 2: POST Create a new todo
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.CreateTodo(todo);
    }

    // API 3: GET a specific todo by id
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") Integer id) {
        return todoService.getByTodoId(id);
    }

    // API 4: PUT Update a todo by id
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") Integer id, @RequestBody Todo todo) {
        return todoService.updateTodoById(id, todo);
    }

    // API 5: DELETE a todo by id
    @DeleteMapping("/todos/{id}")
    public void deleteTodoById(@PathVariable("id") Integer id) {
        todoService.deleteTodoById(id);
    }
}
