package com.example.ToDoList.Service;

import com.example.ToDoList.Entity.Todo;

import java.util.List;

public interface ToDoService {

    List <Todo> getAllTodo(); //method  that gets all items within the list

                                //functionName(entity object)
    void saveTodo(Todo todo); //no return type coz it is a void

    void updateTodo(Long id, Todo todo); //parameters are long id which is the id of element you want
                                        // after the two to does become an object

    Todo getTodoById(Long id);

    void deleteTodo(Long id);

}
