package com.example.ToDoList.Service;

//service is specified in the implementation

import com.example.ToDoList.Entity.Todo;
import com.example.ToDoList.Repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImplement implements ToDoService {

    //auto-wiring
    @Autowired
    private ToDoRepo toDoRepo;

    //override method that are in the interface
    @Override //must be public coz controller needs to see this service
    public List<Todo> getAllTodo(){
        return toDoRepo.findAll();  //The repo is where the data is stored aka database
                                    //find all is found in the JPA-Repository
                                    //return type is a list of to do
    }


    @Override // overriding the method in our service and reusing them
    public  void saveTodo(Todo todo){
        this.toDoRepo.save(todo);
    }

    @Override
    public Todo getTodoById(Long id){
        Optional <Todo> optional =toDoRepo.findById(id); //works kind of like a null c
        Todo todo;

        if (optional.isPresent()){
            todo = optional.get();
        } else  {
            throw new RuntimeException("to do for the id"+ id+ "is not found");
            }

        return todo;
    }

    @Override
    public void updateTodo(Long id, Todo todo){ // a method that updates the to do using item id/index
        Todo todoFromDB = toDoRepo.findById(id).get(); //toDoFromDB is declared in this line
        todoFromDB.setTaskName(todo.getTaskName()); // declared in the Entity file
      //  todoFromDB.setDesc(todo.getDesc()); //declare in entity file
        toDoRepo.save(todoFromDB);
    }

    @Override
    public void deleteTodo(Long id){
        this.toDoRepo.deleteById((id));
    }
}
