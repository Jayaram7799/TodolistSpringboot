package com.example.todo.model;

public class Todo {

    private Integer id;
    private String todo;
    private String priority;
    private String status;

    // Constructor with parameters
    public Todo(Integer id, String todo, String priority, String status) {
        super();
        this.id = id;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    // Default constructor
    public Todo() {
        super();
    }

    // Getter and setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and setter for todo
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    // Getter and setter for priority
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Getter and setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
