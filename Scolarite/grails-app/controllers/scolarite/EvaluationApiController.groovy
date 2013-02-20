package scolarite

import grails.converters.JSON

class EvaluationApiController {

  static allowedMethods = [createAndInsert: "POST"]


  def list() {
    def evaluations = Evaluation.list()
     render evaluations as JSON
  }

  def createAndInsert() {
    def evalInstance = new Evaluation(params).save()
    render evalInstance as JSON
  }



  def show(Long id) {
    def evalInstance = Evaluation.get(id)
    render evalInstance as JSON
  }


}
