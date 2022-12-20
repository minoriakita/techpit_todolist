package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todolist.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

// public class TaskRepository {
    
// }
