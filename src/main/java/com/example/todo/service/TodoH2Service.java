/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoH2Service implements TodoRepository {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public ArrayList<Todo> getAllTodos() {
		List<Todo> list = jt.query("select * from TODOLIST ", new TodoRowMapper());
		ArrayList<Todo> arrayList = new ArrayList<>(list);

		return arrayList;
	}

	@Override
	public Todo CreateTodo(Todo todo) {
		// Correct Insert Query
		jt.update("insert into TODOLIST(todo, priority, status) values (?, ?, ?)",
				todo.getTodo(), todo.getPriority(), todo.getStatus());

		// Correct Select Query
		Todo savedTodo = jt.queryForObject("select * from TODOLIST where todo = ? ",
				new TodoRowMapper(), todo.getTodo());

		return savedTodo;

	}

	@Override
	public Todo getByTodoId(Integer id) {
		try {
			Todo todo = jt.queryForObject("select * from TODOLIST where id = ?", new TodoRowMapper(), id);
			return todo;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Todo updateTodoById(Integer id, Todo todo) {
		if (todo.getTodo() != null) {
			jt.update("update TODOLIST set todo = ? where id = ?", todo.getTodo(), id);
		}
		if (todo.getStatus() != null) {
			jt.update("update TODOLIST set status = ? where id = ?", todo.getStatus(), id);
		}

		if (todo.getPriority() != null) {
			jt.update("update TODOLIST set priority = ? where id = ?", todo.getPriority(), id);
		}
		return getByTodoId(id);

	}

	@Override
	public void deleteTodoById(Integer id) {
		jt.update("delete from TODOLIST where id = ?", id);
	}

}
