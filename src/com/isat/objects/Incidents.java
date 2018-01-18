package com.isat.objects;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Incidents {
	
	private String incident_id;
	private String priority;
	private String source;
	private String severity;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date open_time;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date close_time;
	private String closed_by;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date l3_assign_time;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date l2_assign_time;
	private String year;
	private String assignment_group;
	private String description;
	private String language;
	private String l2_analysis;
	private String hpsm_status;
	private String l3_status;
	private String l2_status;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date planned_close_date;
	private String affected_service;
	private String age;
	
    public Incidents() {
    }
 
    public Incidents(String incident_id, String priority, String source, String severity, 
    		Date open_time, Date close_time, String closed_by, Date l3_assign_time, 
    		Date l2_assign_time, String year, String assignment_group, String description, 
    		String language, String l2_analysis, String hpsm_status, String l3_status, 
    		String l2_status, Date planned_close_date, String affected_service, 
    		String age) {
    	this.incident_id = incident_id;
    	this.priority = priority;
    	this.source = source;
    	this.severity = severity;
    	this.open_time = open_time;
    	this.close_time = close_time;
    	this.closed_by = closed_by;
    	this.l3_assign_time = l3_assign_time;
    	this.l2_assign_time = l2_assign_time;
    	this.year = year;
    	this.assignment_group = assignment_group;
    	this.description = description;
    	this.language = language;
    	this.l2_analysis = l2_analysis;
    	this.hpsm_status = hpsm_status;
    	this.l3_status = l3_status;
    	this.l2_status = l2_status;
    	this.planned_close_date = planned_close_date;
    	this.affected_service = affected_service;
    	this.age = age;
    }
	public String getIncident_id() {
		return incident_id;
	}
	public void setIncident_id(String incident_id) {
		this.incident_id = incident_id;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public Date getOpen_time() {
		return open_time;
	}
	public void setOpen_time(Date open_time) {
		this.open_time = open_time;
	}
	public Date getClose_time() {
		return close_time;
	}
	public void setClose_time(Date close_time) {
		this.close_time = close_time;
	}
	public String getClosed_by() {
		return closed_by;
	}
	public void setClosed_by(String closed_by) {
		this.closed_by = closed_by;
	}
	public Date getL3_assign_time() {
		return l3_assign_time;
	}
	public void setL3_assign_time(Date l3_assign_time) {
		this.l3_assign_time = l3_assign_time;
	}
	public Date getL2_assign_time() {
		return l2_assign_time;
	}
	public void setL2_assign_time(Date l2_assign_time) {
		this.l2_assign_time = l2_assign_time;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAssignment_group() {
		return assignment_group;
	}
	public void setAssignment_group(String assignment_group) {
		this.assignment_group = assignment_group;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getL2_analysis() {
		return l2_analysis;
	}
	public void setL2_analysis(String l2_analysis) {
		this.l2_analysis = l2_analysis;
	}
	public String getHpsm_status() {
		return hpsm_status;
	}
	public void setHpsm_status(String hpsm_status) {
		this.hpsm_status = hpsm_status;
	}
	public String getL3_status() {
		return l3_status;
	}
	public void setL3_status(String l3_status) {
		this.l3_status = l3_status;
	}
	public String getL2_status() {
		return l2_status;
	}
	public void setL2_status(String l2_status) {
		this.l2_status = l2_status;
	}
	public Date getPlanned_close_date() {
		return planned_close_date;
	}
	public void setPlanned_close_date(Date planned_close_date) {
		this.planned_close_date = planned_close_date;
	}
	public String getAffected_service() {
		return affected_service;
	}
	public void setAffected_service(String affected_service) {
		this.affected_service = affected_service;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

}
