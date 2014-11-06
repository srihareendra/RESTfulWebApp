package com.todo.action;

import java.util.List;
import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.todo.entity.Task;
import com.todo.service.TaskManager;

public class EditTaskAction extends ActionSupport implements Preparable	
{
	private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditTaskAction.class);
	//List of Tasks; Setter and Getter are below
	private List<Task> tasks;
	//Task object to be added; Setter and Getter are below
	private Task task;
	
	//Task manager injected by spring context; This is cool !!
	private TaskManager taskManager;

	//This method return list of Tasks in database
	public String listTasks() {
		//logger.info("listTasks method called");
		tasks= taskManager.getAllTasks();
		return SUCCESS;
	}

	//This method will be called when a Task object is added
	public String addTask() {
		//logger.info("addTask method called");
		taskManager.addTask(task);
		return SUCCESS;
	}

	//Deletes a Task by it's id passed in path parameter
	public String deleteTask() {
		//logger.info("deleteTask method called");
		System.out.println("delete task invoked... "+task.getId());
		taskManager.deleteTask(task.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		task = null;
	}

	public void setTaskManager(TaskManager taskManager) {
		this.taskManager = taskManager;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> Tasks) {
		this.tasks = tasks;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
