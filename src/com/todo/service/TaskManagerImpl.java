package com.todo.service;

import java.util.List;
import com.todo.dao.TaskDAO;
import com.todo.entity.Task;

public class TaskManagerImpl implements TaskManager {
	//Task dao injected by Spring context
    private TaskDAO taskDao;
		
	//This setter will be used by Spring context to inject the dao's instance
	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDao = taskDAO;
	}

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		taskDao.addTask(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskDao.getAllTasks();
	}

	@Override
	public void deleteTask(Integer taskId) {
		// TODO Auto-generated method stub
		taskDao.deleteTask(taskId);
	}
}
