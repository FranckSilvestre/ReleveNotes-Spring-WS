import scolarite.Etudiant
import scolarite.Evaluation

class BootStrap {

  def init = { servletContext ->

    // create etudiants
    def pauline = new Etudiant(nom: "Dupont", prenom: "Pauline").save()
    def pierre = new Etudiant(nom: "Durand", prenom: "Pierre").save()
    def julie = new Etudiant(nom: "Smith", prenom: "Julie").save()
    def john = new Etudiant(nom: "Doo", prenom: "John").save()

    // create evaluations
    new Evaluation(etudiant: pauline, note: 18, titre: "Devoir 1").save()
    new Evaluation(etudiant: pauline, note: 15, titre: "Devoir 2").save()
    new Evaluation(etudiant: pauline, note: 14.5, titre: "Devoir 3").save()
    new Evaluation(etudiant: pierre, note: 8.5, titre: "Devoir 1").save()
    new Evaluation(etudiant: pierre, note: 13, titre: "Devoir 2").save()
    new Evaluation(etudiant: pierre, note: 11, titre: "Devoir 3").save()
    new Evaluation(etudiant: julie, note: 11, titre: "Devoir 1").save()
    new Evaluation(etudiant: julie, note: 8, titre: "Devoir 2").save()
    new Evaluation(etudiant: julie, note: 19.5, titre: "Devoir 3").save()
    new Evaluation(etudiant: john, note: 12, titre: "Devoir 1").save()
    new Evaluation(etudiant: john, note: 4, titre: "Devoir 2").save()
    new Evaluation(etudiant: john, note: 18.5, titre: "Devoir 3").save()


  }
  def destroy = {}
}
