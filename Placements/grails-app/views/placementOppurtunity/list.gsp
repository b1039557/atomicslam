
<%@ page import="placements.PlacementOppurtunity" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-placementOppurtunity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-placementOppurtunity" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="applications" title="${message(code: 'placementOppurtunity.applications.label', default: 'Applications')}" />
					
						<g:sortableColumn property="companyName" title="${message(code: 'placementOppurtunity.companyName.label', default: 'Company Name')}" />
					
						<g:sortableColumn property="jobTitle" title="${message(code: 'placementOppurtunity.jobTitle.label', default: 'Job Title')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'placementOppurtunity.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${placementOppurtunityInstanceList}" status="i" var="placementOppurtunityInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${placementOppurtunityInstance.id}">${fieldValue(bean: placementOppurtunityInstance, field: "applications")}</g:link></td>
					
						<td>${fieldValue(bean: placementOppurtunityInstance, field: "companyName")}</td>
					
						<td>${fieldValue(bean: placementOppurtunityInstance, field: "jobTitle")}</td>
					
						<td>${fieldValue(bean: placementOppurtunityInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${placementOppurtunityInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
