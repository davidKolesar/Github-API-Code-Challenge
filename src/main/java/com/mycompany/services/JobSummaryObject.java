package com.mycompany.services;

import java.util.UUID;

public class JobSummaryObject {
	UUID uuid = UUID.randomUUID();
	String language; 
	String location;

	
	public UUID getUuid() {
		return uuid;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
