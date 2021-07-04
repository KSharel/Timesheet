package com.timesheet.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.demo.UserRepo;
import com.timesheet.demo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private UserRepo repo;
	
	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@RequestBody User user){
		String role= request.getHeader("role");
		
		System.out.println("role is "+role);
		if(role==null) {
			return "Roll is null";
		}
		
		if(role.equals("Admin"))
		{
			repo.save(user);
		}
		else {
			return "401 Unauthorized";
		}
		return user.toString();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String UpdateUser(@RequestBody User user){
		String role= request.getHeader("role");
		
		System.out.println("role is "+role);
		if(role==null) {
			return "Role is null";
		}
		
		if(role.equals("Admin"))
		{
			repo.save(user);
		}
		else {
			return "401 Unauthorized";
		}
		return user.toString();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/{uid}",method = RequestMethod.GET)
	public User getUser(@PathVariable("uid") Integer id){
		return repo.findById(id).get();
	}

}
