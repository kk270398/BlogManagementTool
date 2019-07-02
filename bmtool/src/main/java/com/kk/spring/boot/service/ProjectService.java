package com.kk.spring.boot.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.kk.spring.boot.domain.Project;
import com.kk.spring.boot.exceptions.ProjectIdException;
import com.kk.spring.boot.exceptions.ProjectNotFoundException;
import com.kk.spring.boot.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRespository;

	public Project saveOrUpdateBlog(Project p, String username) {
		try {
			p.setProjectLeader(username);
			p.setBlogIdentifier(p.getBlogIdentifier().toUpperCase());
			return projectRespository.save(p);
		} catch (Exception e) {
			throw new ProjectIdException("Blog ID '" + p.getBlogIdentifier() + "' already exists.");
		}

	}

	public Project findBlogByIdentifier(String blogId, String username) {
		Project p = projectRespository.findByBlogIdentifier(blogId.toUpperCase());
		if (p == null) {
			throw new ProjectIdException("Blog ID '" + blogId + "' does not exist.");
		}
		if (!p.getProjectLeader().equals(username)) {
			throw new ProjectNotFoundException("Blog not found in your account");
		}
		return p;
	}

	public Iterable<Project> findAllBlogs(String username) {
		return projectRespository.findAllByProjectLeader(username);
	}

	public void deleteBlogByIdentifier(String blogId, String username) {
		Project p = projectRespository.findByBlogIdentifier(blogId.toUpperCase());
		if (p == null) {
			throw new ProjectIdException("Blog ID '" + blogId + "' does not exist.");
		}
		if (!p.getProjectLeader().equals(username)) {
			throw new ProjectNotFoundException("Blog not found in your account");
		}
		projectRespository.delete(p);
	}

	public Project upadteBlog(Project p, String username) {
		Project p1 = projectRespository.findByBlogIdentifier(p.getBlogIdentifier().toUpperCase());
		if (p1 == null) {
			throw new ProjectIdException("Blog ID '" + p.getBlogIdentifier().toUpperCase() + "' does not exist.");
		}
		if (!p1.getProjectLeader().equals(username)) {
			throw new ProjectNotFoundException("Blog not found in your account");
		}
		p.setProjectLeader(username);
		p.setId(p1.getId());
		p.setBlogIdentifier(p.getBlogIdentifier().toUpperCase());
		return projectRespository.save(p);
	}

}
