package com.kk.spring.boot.exceptions;

public class ProjectIdExceptionResponse {
	private String blogIdentifier;

	public ProjectIdExceptionResponse(String blogIdentifier) {
		this.blogIdentifier = blogIdentifier;
	}

	public String getBlogIdentifier() {
		return blogIdentifier;
	}

	public void setBlogIdentifier(String blogIdentifier) {
		this.blogIdentifier = blogIdentifier;
	}

}
