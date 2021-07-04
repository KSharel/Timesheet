package com.timesheet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.timesheet.demo.model.User;

@RepositoryRestResource(collectionResourceRel = "users",path = "usersRes")
public interface UserRepo extends JpaRepository<User, Integer>{
	
}
