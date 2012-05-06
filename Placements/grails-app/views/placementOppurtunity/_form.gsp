<%@ page import="placements.PlacementOppurtunity" %>



<div class="fieldcontain ${hasErrors(bean: placementOppurtunityInstance, field: 'applications', 'error')} ">
	<label for="applications">
		<g:message code="placementOppurtunity.applications.label" default="Applications" />
		
	</label>
	<g:textField name="applications" value="${placementOppurtunityInstance?.applications}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOppurtunityInstance, field: 'companyName', 'error')} ">
	<label for="companyName">
		<g:message code="placementOppurtunity.companyName.label" default="Company Name" />
		
	</label>
	<g:textField name="companyName" value="${placementOppurtunityInstance?.companyName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOppurtunityInstance, field: 'jobTitle', 'error')} ">
	<label for="jobTitle">
		<g:message code="placementOppurtunity.jobTitle.label" default="Job Title" />
		
	</label>
	<g:textField name="jobTitle" value="${placementOppurtunityInstance?.jobTitle}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: placementOppurtunityInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="placementOppurtunity.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${placementOppurtunityInstance?.status}"/>
</div>

