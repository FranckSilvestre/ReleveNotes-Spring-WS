
<%@ page import="scolarite.Evaluation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'evaluation.label', default: 'Evaluation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-evaluation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-evaluation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list evaluation">
			
				<g:if test="${evaluationInstance?.titre}">
				<li class="fieldcontain">
					<span id="titre-label" class="property-label"><g:message code="evaluation.titre.label" default="Titre" /></span>
					
						<span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${evaluationInstance}" field="titre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${evaluationInstance?.coeff}">
				<li class="fieldcontain">
					<span id="coeff-label" class="property-label"><g:message code="evaluation.coeff.label" default="Coeff" /></span>
					
						<span class="property-value" aria-labelledby="coeff-label"><g:fieldValue bean="${evaluationInstance}" field="coeff"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${evaluationInstance?.etudiant}">
				<li class="fieldcontain">
					<span id="etudiant-label" class="property-label"><g:message code="evaluation.etudiant.label" default="Etudiant" /></span>
					
						<span class="property-value" aria-labelledby="etudiant-label"><g:link controller="etudiant" action="show" id="${evaluationInstance?.etudiant?.id}">${evaluationInstance?.etudiant?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${evaluationInstance?.note}">
				<li class="fieldcontain">
					<span id="note-label" class="property-label"><g:message code="evaluation.note.label" default="Note" /></span>
					
						<span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${evaluationInstance}" field="note"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${evaluationInstance?.noteMax}">
				<li class="fieldcontain">
					<span id="noteMax-label" class="property-label"><g:message code="evaluation.noteMax.label" default="Note Max" /></span>
					
						<span class="property-value" aria-labelledby="noteMax-label"><g:fieldValue bean="${evaluationInstance}" field="noteMax"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${evaluationInstance?.id}" />
					<g:link class="edit" action="edit" id="${evaluationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
