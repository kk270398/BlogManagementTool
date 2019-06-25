package com.kk.spring.boot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.spring.boot.domain.Project;
import com.kk.spring.boot.service.MapValidationErrorService;
import com.kk.spring.boot.service.ProjectService;

@RestController
@RequestMapping("/blog")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private MapValidationErrorService mapValaidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewBlog(@Valid @RequestBody Project project, BindingResult result) {
		ResponseEntity<?> errorMap = mapValaidationErrorService.MapValidationService(result);
		if (errorMap != null)
			return errorMap;
		Project p = projectService.saveOrUpdateBlog(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}

	@GetMapping("/{blogId}")
	public ResponseEntity<?> getBlogById(@PathVariable String blogId) {
		Project p = projectService.findBlogByIdentifier(blogId);
		return new ResponseEntity<Project>(p, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<Project> getAllBlogs() {
		return projectService.findAllBlogs();
	}

	@DeleteMapping("/{blogId}")
	public ResponseEntity<?> deleteBlogById(@PathVariable String blogId) {
		projectService.deleteBlogByIdentifier(blogId);
		return new ResponseEntity<String>("Project with ID '" + blogId + "' was deleted.", HttpStatus.OK);
	}
}
