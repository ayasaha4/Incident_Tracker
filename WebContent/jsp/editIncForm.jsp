<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Incident</title>
</head>
<body>
    <div align="center">
        <h1>Edit Incident</h1>
        <form:form action="saveEditIncident" method="post" modelAttribute="incidents">
        <table>
             <form:hidden path="incident_id"/>
            <tr>
                <td>Priority:</td>
                <td><form:input path="priority" /></td>
            </tr>
            <tr>
                <td>Source:</td>
                <td><form:input path="source" /></td>
            </tr>
            <tr>
                <td>Severity:</td>
                <td><form:input path="severity" /></td>
            </tr>
            <tr>
                <td>Open_Time:</td>
                <td><form:input path="open_time" /></td>
            </tr>
            <tr>
                <td>Close_Time:</td>
                <td><form:input path="close_time" /></td>
            </tr>
            <tr>
                <td>Closed_By:</td>
                <td><form:input path="closed_by" /></td>
            </tr>
            <tr>
                <td>L3_Assign_Time:</td>
                <td><form:input path="l3_assign_time" /></td>
            </tr>
            <tr>
                <td>L2_Assign_Time:</td>
                <td><form:input path="l2_assign_time" /></td>
            </tr>
            <tr>
                <td>Year:</td>
                <td><form:input path="year" /></td>
            </tr>
            <tr>
                <td>Assignment_Group:</td>
                <td><form:input path="assignment_group" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td>Language:</td>
                <td><form:input path="language" /></td>
            </tr>
            <tr>
                <td>L2_Analysis:</td>
                <td><form:input path="l2_analysis" /></td>
            </tr>
            <tr>
                <td>Hpsm_Status:</td>
                <td><form:input path="hpsm_status" /></td>
            </tr>
            <tr>
                <td>L3_Status:</td>
                <td><form:input path="l3_status" /></td>
            </tr>
            <tr>
                <td>L2_Status:</td>
                <td><form:input path="l2_status" /></td>
            </tr>
            <tr>
                <td>Planned_Close_Date:</td>
                <td><form:input path="planned_close_date" /></td>
            </tr>
            <tr>
                <td>Affected_Service:</td>
                <td><form:input path="affected_service" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>