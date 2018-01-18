package com.isat.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.isat.dao.IncidentDao;
import com.isat.objects.Incidents;

@Repository(value = "IncidentDao")
public class IncidentDaoImpl implements IncidentDao {

	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
    public void update(Incidents incidents) {
	        // update
	        String sql = "UPDATE EAI.TEMP_INCIDENT_MASTER SET priority=?, "
	        		+ "source=?, severity=?, open_time=?, close_time=?, closed_by=?, "
	        		+ "l3_assign_time=?, l2_assign_time=?, year=?, assignment_group=?, "
	        		+ "description=?, language=?, l2_analysis=?, hpsm_status=?, l3_status=?, "
	        		+ "l2_status=?, planned_close_date=?, affected_service=?, age=? "
	        		+ "WHERE incident_id=?";
	        jdbcTemplate.update(sql, incidents.getPriority(),
	        		incidents.getSource(), incidents.getSeverity(), incidents.getOpen_time(),
	        		incidents.getClose_time(), incidents.getClosed_by(), incidents.getL3_assign_time(), 
	        		incidents.getL2_assign_time(), incidents.getYear(), incidents.getAssignment_group(), 
	        		incidents.getDescription(), incidents.getLanguage(), incidents.getL2_analysis(), 
	        		incidents.getHpsm_status(), incidents.getL3_status(), incidents.getL2_status(), 
	        		incidents.getPlanned_close_date(), incidents.getAffected_service(), incidents.getAge(), incidents.getIncident_id());
	}
	

	@Override
	public void save(Incidents incidents){
        // insert
	        String sql = "INSERT INTO EAI.TEMP_INCIDENT_MASTER (incident_id, priority, "
	        		+ "source, severity, open_time, close_time, closed_by, "
	        		+ "l3_assign_time, l2_assign_time, year, assignment_group, "
	        		+ "description, language, l2_analysis, hpsm_status, l3_status, "
	        		+ "l2_status, planned_close_date, affected_service, age)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
	                    + "?, ?)";
	        jdbcTemplate.update(sql, incidents.getIncident_id(), incidents.getPriority(),
	        		incidents.getSource(), incidents.getSeverity(), incidents.getOpen_time(),
	        		incidents.getClose_time(), incidents.getClosed_by(), incidents.getL3_assign_time(), 
	        		incidents.getL2_assign_time(), incidents.getYear(), incidents.getAssignment_group(), 
	        		incidents.getDescription(), incidents.getLanguage(), incidents.getL2_analysis(), 
	        		incidents.getHpsm_status(), incidents.getL3_status(), incidents.getL2_status(), 
	        		incidents.getPlanned_close_date(), incidents.getAffected_service(), incidents.getAge());
	        logger.info("saveOrUpdate3");
	    }
 
    @Override
    public void delete(String incidentId) {
    	
        String sql = "DELETE FROM TEMP_INCIDENT_MASTER WHERE INCIDENT_ID=?";
        jdbcTemplate.update(sql, incidentId);
    }
 
    @Override
    public List<Incidents> list() {
        String sql = "SELECT * FROM EAI.TEMP_INCIDENT_MASTER";
        List<Incidents> listIncidents = jdbcTemplate.query(sql, new IncMapper());
     
        return listIncidents;
    }
 
    @Override
    public Incidents get(String incidentId) {
    	String sql = "SELECT * FROM TEMP_INCIDENT_MASTER WHERE INCIDENT_ID=?";
    	return jdbcTemplate.queryForObject(sql, new Object[]{incidentId},new IncMapper());
        
    }
    
    public class IncMapper implements RowMapper<Incidents>{
    public Incidents mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Incidents inc = new Incidents();
        
    	inc.setIncident_id(rs.getString("incident_id"));
    	inc.setPriority(rs.getString("priority"));
    	inc.setSource(rs.getString("source"));
    	inc.setSeverity(rs.getString("severity"));
    	inc.setOpen_time(rs.getDate("open_time"));
    	inc.setClose_time(rs.getDate("close_time"));
    	inc.setClosed_by(rs.getString("closed_by"));
    	inc.setL3_assign_time(rs.getDate("l3_assign_time"));
    	inc.setL2_assign_time(rs.getDate("l2_assign_time"));
    	inc.setYear(rs.getString("year"));
    	inc.setAssignment_group(rs.getString("assignment_group"));
    	inc.setDescription(rs.getString("description"));
    	inc.setLanguage(rs.getString("language"));
    	inc.setL2_analysis(rs.getString("l2_analysis"));
    	inc.setHpsm_status(rs.getString("hpsm_status"));
    	inc.setL3_status(rs.getString("l3_status"));
    	inc.setL2_status(rs.getString("l2_status"));
    	inc.setPlanned_close_date(rs.getDate("planned_close_date"));
    	inc.setAffected_service(rs.getString("affected_service"));
    	inc.setAge(rs.getString("age"));

        return inc;
    	
    }
    }

}
