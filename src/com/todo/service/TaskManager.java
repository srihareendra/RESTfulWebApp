package com.todo.service;

import java.util.List;

import com.todo.entity.Task;


public interface TaskManager {
	//This method will be called when a Task object is added
    public void addTask(Task task);
    //This method return list of Tasks available
    public List<Task> getAllTasks();
    //Deletes a Task by it's id
    public void deleteTask(Integer taskId);
}
