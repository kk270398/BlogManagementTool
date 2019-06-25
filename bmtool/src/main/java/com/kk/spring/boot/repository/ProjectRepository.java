package com.kk.spring.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kk.spring.boot.domain.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {
	public Project findByTitle(String title);

}
