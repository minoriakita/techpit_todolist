package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todolist.models.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

}

// public class TaskRepository {
    
// }
