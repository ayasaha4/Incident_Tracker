package com.isat.dao;

import java.util.List;

import com.isat.objects.Incidents;

public interface IncidentDao {

	public void update(Incidents incidents);
	
	public void save(Incidents incidents);
    
    public void delete(String incidentId);
     
    public Incidents get(String incidentId);
     
    public List<Incidents> list();

}
