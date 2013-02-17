package iaws.relevenotes.domain;

import iaws.relevenotes.domain.nomenclature.AnneeScolaire;
import iaws.relevenotes.domain.nomenclature.Matiere;
import iaws.relevenotes.domain.nomenclature.Niveau;
import iaws.relevenotes.domain.nomenclature.Semestre;

import java.util.Date;

/**
 * @author franck Silvestre
 */
public class Evaluation {

    private Integer id;
    private String titre;
    private Date dateEval;
    private Etudiant etudiant;
    private Matiere matiere;
    private Niveau niveau ;
    private Semestre semestre;
    private AnneeScolaire anneeScolaire;
    private Float note;
    private Float noteMaximale = 20f;
    private Float coefficient = 1f;

    /**
     * Cree une évaluation
     * @param anneeScolaire l'annee scolaire
     * @param coefficient   le coefficient
     * @param etudiant  l'étudiant
     * @param matiere matiere
     * @param niveau  le niveau
     * @param note  la note
     * @param noteMaximale la note maximale
     * @param semestre  le semestre
     */
    public Evaluation(Integer id,
                      String titre,
                      AnneeScolaire anneeScolaire,
                      Date dateEval,
                      Float coefficient,
                      Etudiant etudiant,
                      Matiere matiere,
                      Niveau niveau,
                      Float note,
                      Float noteMaximale,
                      Semestre semestre) {
        this.id = id;
        this.titre = titre;
        this.anneeScolaire = anneeScolaire;
        this.dateEval = dateEval ;
        this.coefficient = coefficient;
        this.etudiant = etudiant;
        this.matiere = matiere;
        this.niveau = niveau;
        this.note = note;
        this.noteMaximale = noteMaximale;
        this.semestre = semestre;
        etudiant.getEvaluationList().add(this);
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Float getNoteMaximale() {
        return noteMaximale;
    }

    public void setNoteMaximale(Float noteMaximale) {
        this.noteMaximale = noteMaximale;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateEval() {
        return dateEval;
    }

    public void setDateEval(Date dateEval) {
        this.dateEval = dateEval;
    }
}
