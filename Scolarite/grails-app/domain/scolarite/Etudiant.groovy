package scolarite

class Etudiant {

  String nom
  String prenom

  static hasMany = [evaluations: Evaluation]

  String toString() {
    "$prenom ${nom.toUpperCase()}"
  }

  static constraints = {
    nom blank: false
    prenom blank: false
    evaluations nullable: true
  }
}
