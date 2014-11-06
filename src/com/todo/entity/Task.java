package com.todo.entity;

public class Task {
	
	private int  id;
	 private String  name;
	 private String  description; 
	 private String  priority;
	 private String  status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	  
		
	 @Override
	 public String toString() {
	  return "Task [task_id=" + id + ", task_name=" + name
	    + ", task_description=" + description + ", task_priority="
	    + priority +",task_status="+status+ "]";
	 }
	  

}
