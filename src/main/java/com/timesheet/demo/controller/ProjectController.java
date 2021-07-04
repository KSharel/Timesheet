package com.timesheet.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.demo.ProjectRepo;
import com.timesheet.demo.model.Project;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private ProjectRepo prepo;
	
	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@RequestBody Project project){
		String role= request.getHeader("role");
		
		System.out.println("role is "+role);
		if(role==null) {
			return "Roll is null";
		}
		
		if(role.equals("Admin"))
		{
			prepo.save(project);
		}
		else {
			return "401 Unauthorized";
		}
		return project.toString();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Project> getAllProjects(){
		return prepo.findAll();
	}
	
	@RequestMapping(value = "/{pid}",method = RequestMethod.GET)
	public Project getProject(@PathVariable("pid") Integer pid){
		return prepo.findById(pid).get();
	}
}
