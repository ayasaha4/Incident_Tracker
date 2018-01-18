package com.isat.service;

import java.util.List;

import com.isat.exception.IncidentTrackerBusinessException;
import com.isat.objects.Incidents;

public interface IncidentService {

	public List<Incidents> getIncidentlist();
	
	public Incidents getIncidents(String incidentId);
	
	public void removeIncident(String incidentId);
	
	public void insertIncident(Incidents incidents);
	
	public void editIncident(Incidents incidents);

}
