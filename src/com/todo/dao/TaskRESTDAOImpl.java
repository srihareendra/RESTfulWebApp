package com.todo.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import com.todo.entity.Task;



public class TaskRESTDAOImpl implements TaskDAO{

	public static final String SERVER_URI = "http://localhost:8080/RESTfulWebservice/";
	
	@Override
	public void addTask(Task task) {
		///tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Task> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		restTemplate.postForLocation(SERVER_URI+"tasks/insert/"+task.getName()+"/"+task.getDescription()+"/"+task.getPriority()+"/"+task.getStatus(), task, Task.class);
		//getAllTasks();
	}
	
	public void changeStatus(Task task){
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Task> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		
		  restTemplate.postForLocation(SERVER_URI+"tasks/3/CHANGED", task, Task.class);
	}

	@Override
	public List<Task> getAllTasks() {
		RestTemplate restTemplate = new RestTemplate();
		
		List<Task> tasks= new ArrayList<Task>();
		//we can't get List<Task> because JSON convertor doesn't know the type of
		//object in the list 	a hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> tasksList = restTemplate.getForObject(SERVER_URI+"/tasks", List.class);
		for(LinkedHashMap map : tasksList){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name") +",Description="+map.get("description")+",priority="+map.get("priority")+",status="+map.get("status"));
			Task task = new Task();
			task.setId((Integer)map.get("id"));
			task.setName((String)map.get("name"));
			task.setDescription((String)map.get("description"));
			task.setPriority((String)map.get("priority"));
			task.setStatus((String)map.get("status"));
			tasks.add(task);
		}	
		return tasks;
	}

	@Override
	public void deleteTask(Integer taskId) {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Task> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		
		restTemplate.postForLocation(SERVER_URI+"tasks/delete/"+taskId, null, Task.class);
		//getAllTasks();
	}
	
	public static void main(String args[]){
		
		TaskRESTDAOImpl taskDao = new TaskRESTDAOImpl();
		/*for(int i=1;i<10;i++){
			Task task = new Task();
			task.setId(i);
			task.setName("task-"+String.valueOf(i));
			task.setDescription("desc"+i);
			task.setPriority(String.valueOf(i));
			task.setStatus("STAT-"+String.valueOf(i));
			taskDao.addTask(task);
		}*/
		taskDao.deleteTask(7);
		taskDao.getAllTasks();
	}
}
