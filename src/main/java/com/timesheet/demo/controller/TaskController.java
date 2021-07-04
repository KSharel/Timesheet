package com.timesheet.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.demo.model.Task;
import com.timesheet.demo.repository.TasksRepo;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private TasksRepo trepo;
	
	@RequestMapping(method = RequestMethod.POST)
	public String addTask(@RequestBody Task task){
		String role= request.getHeader("role");
		
		System.out.println("role is "+role);
		if(role==null) {
			return "Role is null";
		}
		
		if(role.equals("Admin"))
		{
			trepo.save(task);
		}
		else {
			return "401 Unauthorized";
		}
		return task.toString();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Task> getAllTaks(){
		
		String role= request.getHeader("role");
		
		System.out.println("role is "+role);
		if(role==null) {
			return null;
		}
		
		if(role.equals("Admin"))
		{
			return trepo.findAll();
		}
		else {
			return null;
		}
	}
	
	@RequestMapping(value = "/{tid}",method = RequestMethod.GET)
	public Task getTask(@PathVariable("tid") Integer tid){
		String role= request.getHeader("role");
		
		System.out.println("role is "+role);
		if(role==null) {
			return null;
		}
		
		if(role.equals("Admin"))
		{
			return trepo.findById(tid).get();
		}
		else {
			return null;
		}
	}

	@DeleteMapping(value = "/{tid}")
	public Task deleteTask(@PathVariable("tid") Integer tid) {
		String role= request.getHeader("role");
		
		System.out.println("role is "+role);
		if(role==null) {
			return null;
		}
		
		if(role.equals("Admin"))
		{
			Task task = trepo.findById(tid).get();
			trepo.deleteById(tid);
			return task;
		}
		else {
			return null;
		}	
	}
}
