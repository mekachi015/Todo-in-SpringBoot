package com.example.ToDoList.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Todo {

    @Id //always use the jakatra
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String taskName; //initializing the task name

    @NonNull
    private String desc; //initializing the task description

    @CreatedDate //specicies to sql the date of creation
    Timestamp dateCreated;


    public String getTaskName() {
        return taskName; // a method that returns the taskName
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName; //a method that sets the name of the Task
    }

    public String getDesc() {
        return desc; //a method that returns the description
    }

    public void setDesc(String desc) {
        this.desc = desc; //a method that sets the description
    }
}
