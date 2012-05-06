
<%@ page import="placements.PlacementOppurtunity" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-placementOppurtunity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-placementOppurtunity" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list placementOppurtunity">
			
				<g:if test="${placementOppurtunityInstance?.applications}">
				<li class="fieldcontain">
					<span id="applications-label" class="property-label"><g:message code="placementOppurtunity.applications.label" default="Applications" /></span>
					
						<span class="property-value" aria-labelledby="applications-label"><g:fieldValue bean="${placementOppurtunityInstance}" field="applications"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${placementOppurtunityInstance?.companyName}">
				<li class="fieldcontain">
					<span id="companyName-label" class="property-label"><g:message code="placementOppurtunity.companyName.label" default="Company Name" /></span>
					
						<span class="property-value" aria-labelledby="companyName-label"><g:fieldValue bean="${placementOppurtunityInstance}" field="companyName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${placementOppurtunityInstance?.jobTitle}">
				<li class="fieldcontain">
					<span id="jobTitle-label" class="property-label"><g:message code="placementOppurtunity.jobTitle.label" default="Job Title" /></span>
					
						<span class="property-value" aria-labelledby="jobTitle-label"><g:fieldValue bean="${placementOppurtunityInstance}" field="jobTitle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${placementOppurtunityInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="placementOppurtunity.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${placementOppurtunityInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${placementOppurtunityInstance?.id}" />
					<g:link class="edit" action="edit" id="${placementOppurtunityInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
