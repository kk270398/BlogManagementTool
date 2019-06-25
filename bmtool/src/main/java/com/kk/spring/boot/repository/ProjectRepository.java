package com.kk.spring.boot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kk.spring.boot.domain.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
	public Project findByBlogIdentifier(String blogIdentifier);

	@Override
	List<Project> findAll();

}
