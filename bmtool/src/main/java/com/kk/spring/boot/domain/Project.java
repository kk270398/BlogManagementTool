package com.kk.spring.boot.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {
	private String title;
	private String body;
	private Date date;
	private List<String> tags;
	private String metaDescription;

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
