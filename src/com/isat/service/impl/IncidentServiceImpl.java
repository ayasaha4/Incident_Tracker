package com.isat.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isat.common.StaticVariable;
import com.isat.dao.IncidentDao;
import com.isat.exception.IncidentTrackerBusinessException;
import com.isat.objects.Incidents;
import com.isat.service.IncidentService;

@Service(value = "IncidentService")
public class IncidentServiceImpl implements IncidentService {
	
	private static final Logger logger = Logger.getLogger(IncidentServiceImpl.class);

	@Autowired
	IncidentDao incidentDao;
	@Override
	public List<Incidents> getIncidentlist() {
		List<Incidents> listIncidents = null;
		try {
			listIncidents = incidentDao.list();
			if (listIncidents != null) {
				logger.info("incident list is not empty");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return listIncidents;

	}
	@Override
	public Incidents getIncidents(String incidentId){
		Incidents incidents = null;
		try{
			incidents = incidentDao.get(incidentId);
			if (incidents != null){
				logger.info("incident is not null");
			}
		}catch (Exception e){
			logger.info(e.getMessage());
		}
		return incidents;
	}
	
	@Override
	public void removeIncident(String incidentId) {
			incidentDao.delete(incidentId);
			System.out.println("inc" + incidentId);
			logger.info("incident deleted");
	}
	
	@Override
	public void insertIncident(Incidents incidents) {
			incidentDao.save(incidents);
			logger.info("incident inserted");
	}
	
	@Override
	public void editIncident(Incidents incidents) {
			incidentDao.update(incidents);
			logger.info("incident updated");
		}	

}
