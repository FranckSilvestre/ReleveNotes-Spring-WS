package scolarite

import org.springframework.dao.DataIntegrityViolationException

class EvaluationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 20, 100)
        [evaluationInstanceList: Evaluation.list(params), evaluationInstanceTotal: Evaluation.count()]
    }

    def create() {
        [evaluationInstance: new Evaluation(params)]
    }

    def save() {
        def evaluationInstance = new Evaluation(params)
        if (!evaluationInstance.save(flush: true)) {
            render(view: "create", model: [evaluationInstance: evaluationInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), evaluationInstance.id])
        redirect(action: "show", id: evaluationInstance.id)
    }

    def show(Long id) {
        def evaluationInstance = Evaluation.get(id)
        if (!evaluationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), id])
            redirect(action: "list")
            return
        }

        [evaluationInstance: evaluationInstance]
    }

    def edit(Long id) {
        def evaluationInstance = Evaluation.get(id)
        if (!evaluationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), id])
            redirect(action: "list")
            return
        }

        [evaluationInstance: evaluationInstance]
    }

    def update(Long id, Long version) {
        def evaluationInstance = Evaluation.get(id)
        if (!evaluationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (evaluationInstance.version > version) {
                evaluationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'evaluation.label', default: 'Evaluation')] as Object[],
                          "Another user has updated this Evaluation while you were editing")
                render(view: "edit", model: [evaluationInstance: evaluationInstance])
                return
            }
        }

        evaluationInstance.properties = params

        if (!evaluationInstance.save(flush: true)) {
            render(view: "edit", model: [evaluationInstance: evaluationInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), evaluationInstance.id])
        redirect(action: "show", id: evaluationInstance.id)
    }

    def delete(Long id) {
        def evaluationInstance = Evaluation.get(id)
        if (!evaluationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), id])
            redirect(action: "list")
            return
        }

        try {
            evaluationInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), id])
            redirect(action: "show", id: id)
        }
    }
}
