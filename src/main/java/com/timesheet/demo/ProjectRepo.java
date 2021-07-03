package com.timesheet.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.timesheet.demo.model.Project;

@RepositoryRestResource(collectionResourceRel = "projects",path = "projects")
public interface ProjectRepo extends JpaRepository<Project, Integer>{

}
