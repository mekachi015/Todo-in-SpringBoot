package com.example.ToDoList.Repository;

import com.example.ToDoList.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo  extends JpaRepository <Todo, Long> {

}

