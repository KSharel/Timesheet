package com.timesheet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timesheet.demo.model.Task;

public interface TasksRepo extends JpaRepository<Task, Integer> {

}
