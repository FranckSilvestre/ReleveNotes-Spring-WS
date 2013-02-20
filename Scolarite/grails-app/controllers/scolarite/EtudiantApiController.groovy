package scolarite

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException

class EtudiantApiController {

  static allowedMethods = [createAndInsert: "POST"]


  def list() {
    def etudiants = Etudiant.list()
     render etudiants as JSON
  }

  def createAndInsert() {
    def etudiantInstance = new Etudiant(params).save()
    render etudiantInstance as JSON
  }



  def show(Long id) {
    def etudiantInstance = Etudiant.get(id)
    render etudiantInstance as JSON
  }


}
