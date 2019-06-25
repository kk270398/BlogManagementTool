package com.kk.spring.boot.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "blog")
public class Project {
	@Id
	private String id;
	@NotBlank(message = "Blog Title Is Required")
	private String title;
	@NotBlank(message = "Blog Body Is Required")
	private String body;
	@NotBlank(message = "Blog Identifier Is Required")
	@Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
	@Indexed(unique = true)
	private String blogIdentifier;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date date;
	private List<String> tags;
	private String metaDescription;

	public String getBlogIdentifier() {
		return blogIdentifier;
	}

	public void setBlogIdentifier(String blogIdentifier) {
		this.blogIdentifier = blogIdentifier;
	}

	Project(String title, String body, Date date, List<String> tags, String metaDescription) {
		this.title = title;
		this.body = body;
		this.date = date;
		this.tags = tags;
		this.metaDescription = metaDescription;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
}
