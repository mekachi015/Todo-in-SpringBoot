package com.example.ToDoList.Controller;

import com.example.ToDoList.Entity.Todo;
import com.example.ToDoList.Service.ToDoServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private ToDoServiceImplement todoService;

    @GetMapping
    public List<Todo> findAll(){
        return todoService.getAllTodo();
    }

    @PostMapping
    public  void save(@RequestBody Todo todo){
        todoService.saveTodo(todo);
    }

    @GetMapping("/{id}")
    public Todo findOne(@PathVariable Long id){
        return todoService.getTodoById(id);
    }


    @PutMapping({"/id"})
    public  void upddate(@PathVariable Long id, @RequestBody Todo todo){
        this.todoService.updateTodo(id, todo );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.todoService.deleteTodo(id);
    }

}

