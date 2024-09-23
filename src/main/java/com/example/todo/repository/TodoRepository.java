// Write your code here

package com.example.todo.repository;

import java.util.ArrayList;

import com.example.todo.model.Todo;

public interface TodoRepository {

    ArrayList<Todo> getAllTodos();

    Todo CreateTodo(Todo todo);

    Todo getByTodoId(Integer id);

    Todo updateTodoById(Integer id, Todo todo);

    void deleteTodoById(Integer id);

}
