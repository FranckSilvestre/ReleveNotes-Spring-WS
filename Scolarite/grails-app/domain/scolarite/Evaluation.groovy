package scolarite

class Evaluation {

  String titre

  Float note
  Float noteMax = 20
  Float coeff = 1

  Etudiant etudiant
  static belongsTo = [etudiant: Etudiant]

  String toString() {
      "$titre noté sur $noteMax avec coeff $coeff"
    }

  static constraints = {
    titre blank: false
  }
}
