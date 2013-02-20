package scolarite

import org.springframework.dao.DataIntegrityViolationException

class EtudiantController {

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def index() {
    redirect(action: "list", params: params)
  }

  def list(Integer max) {
    params.max = Math.min(max ?: 10, 100)
    [etudiantInstanceList: Etudiant.list(params), etudiantInstanceTotal: Etudiant.count()]
  }

  def create() {
    [etudiantInstance: new Etudiant(params)]
  }

  def save() {
    def etudiantInstance = new Etudiant(params)
    if (!etudiantInstance.save(flush: true)) {
      render(view: "create", model: [etudiantInstance: etudiantInstance])
      return
    }

    flash.message = message(code: 'default.created.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), etudiantInstance.id])
    redirect(action: "show", id: etudiantInstance.id)
  }

  def show(Long id) {
    def etudiantInstance = Etudiant.get(id)
    if (!etudiantInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), id])
      redirect(action: "list")
      return
    }

    [etudiantInstance: etudiantInstance]
  }

  def edit(Long id) {
    def etudiantInstance = Etudiant.get(id)
    if (!etudiantInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), id])
      redirect(action: "list")
      return
    }

    [etudiantInstance: etudiantInstance]
  }

  def update(Long id, Long version) {
    def etudiantInstance = Etudiant.get(id)
    if (!etudiantInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), id])
      redirect(action: "list")
      return
    }

    if (version != null) {
      if (etudiantInstance.version > version) {
        etudiantInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                                            [message(code: 'etudiant.label', default: 'Etudiant')] as Object[],
                                            "Another user has updated this Etudiant while you were editing")
        render(view: "edit", model: [etudiantInstance: etudiantInstance])
        return
      }
    }

    etudiantInstance.properties = params

    if (!etudiantInstance.save(flush: true)) {
      render(view: "edit", model: [etudiantInstance: etudiantInstance])
      return
    }

    flash.message = message(code: 'default.updated.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), etudiantInstance.id])
    redirect(action: "show", id: etudiantInstance.id)
  }

  def delete(Long id) {
    def etudiantInstance = Etudiant.get(id)
    if (!etudiantInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), id])
      redirect(action: "list")
      return
    }

    try {
      etudiantInstance.delete(flush: true)
      flash.message = message(code: 'default.deleted.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), id])
      redirect(action: "list")
    } catch (DataIntegrityViolationException e) {
      flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'etudiant.label', default: 'Etudiant'), id])
      redirect(action: "show", id: id)
    }
  }
}
