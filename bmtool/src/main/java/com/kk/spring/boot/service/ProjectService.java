package com.kk.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.spring.boot.domain.Project;
import com.kk.spring.boot.exceptions.ProjectIdException;
import com.kk.spring.boot.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRespository;

	public Project saveOrUpdateBlog(Project p) {
		try {
			p.setBlogIdentifier(p.getBlogIdentifier().toUpperCase());
			return projectRespository.save(p);
		} catch (Exception e) {
			throw new ProjectIdException("Blog ID '" + p.getBlogIdentifier() + "' already exists.");
		}

	}

	public Project findBlogByIdentifier(String blogId) {
		Project p = projectRespository.findByBlogIdentifier(blogId);
		if (p == null) {
			throw new ProjectIdException("Blog ID '" + blogId + "' does not exist.");
		}
		return p;
	}

	public Iterable<Project> findAllProjects() {
		return projectRespository.findAll();
	}
}
