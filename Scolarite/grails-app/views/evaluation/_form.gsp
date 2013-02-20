<%@ page import="scolarite.Evaluation" %>



<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="evaluation.titre.label" default="Titre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titre" required="" value="${evaluationInstance?.titre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'coeff', 'error')} required">
	<label for="coeff">
		<g:message code="evaluation.coeff.label" default="Coeff" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="coeff" value="${fieldValue(bean: evaluationInstance, field: 'coeff')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'etudiant', 'error')} required">
	<label for="etudiant">
		<g:message code="evaluation.etudiant.label" default="Etudiant" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="etudiant" name="etudiant.id" from="${scolarite.Etudiant.list()}" optionKey="id" required="" value="${evaluationInstance?.etudiant?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'note', 'error')} required">
	<label for="note">
		<g:message code="evaluation.note.label" default="Note" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="note" value="${fieldValue(bean: evaluationInstance, field: 'note')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'noteMax', 'error')} required">
	<label for="noteMax">
		<g:message code="evaluation.noteMax.label" default="Note Max" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="noteMax" value="${fieldValue(bean: evaluationInstance, field: 'noteMax')}" required=""/>
</div>

