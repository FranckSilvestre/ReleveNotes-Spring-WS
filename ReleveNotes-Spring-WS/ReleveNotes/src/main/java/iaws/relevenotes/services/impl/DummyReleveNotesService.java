package iaws.relevenotes.services.impl;

import iaws.relevenotes.domain.Etudiant;
import iaws.relevenotes.domain.Evaluation;
import iaws.relevenotes.domain.nomenclature.AnneeScolaire;
import iaws.relevenotes.domain.nomenclature.Matiere;
import iaws.relevenotes.domain.nomenclature.Niveau;
import iaws.relevenotes.domain.nomenclature.Semestre;
import iaws.relevenotes.services.ReleveNoteService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author franck Silvestre
 */
public class DummyReleveNotesService implements ReleveNoteService {


    /**
     * Retourne tous les évaluation correspondant à une année scolaire, un niveau
     * et un semestre
     *
     * @param anneeScolaire l'année scolaire
     * @param niveau        le niveau
     * @param semestre      le semestre
     * @return les évaluations correspondant aux critères fournis
     */
    public List<Evaluation> findAllEvaluationsForAnneeScolaireNiveauAndSemestre(AnneeScolaire anneeScolaire, Niveau niveau, Semestre semestre) {
        return createEvaluations();
    }


    private List<Evaluation> createEvaluations() {

        // create etudiants
        //
        Etudiant pauline = new Etudiant();
        pauline.setId(123456789);
        pauline.setPrenom("Pauline");
        pauline.setNom("Dupont");

        Etudiant jules = new Etudiant();
        pauline.setId(189246756);
        pauline.setPrenom("Jules");
        pauline.setNom("Durand");

        // create matieres
        //
        Matiere matiereIaws = new Matiere();
        matiereIaws.setId(598);
        matiereIaws.setCode("IAWS");
        matiereIaws.setLibelle("Interopérabilité Application Web Services");

        Matiere matiereJee = new Matiere();
        matiereJee.setId(421);
        matiereJee.setCode("JEE");
        matiereJee.setLibelle("Java Entreprise Edition");

        // create annee scolaire
        //
        AnneeScolaire anneeScolaire = new AnneeScolaire();
        anneeScolaire.setCode("2012-2013");
        anneeScolaire.setLibelle("Année scolaire 2012-2013");

        // create niveau
        Niveau niveauMaster = new Niveau();
        niveauMaster.setCode("Master");
        niveauMaster.setLibelle("Master");

        // create semestre
        Semestre sem2 = new Semestre();
        sem2.setId(2);

        // create evaluations
        List<Evaluation> evaluationList = new ArrayList<Evaluation>();

        Evaluation eval1Pauline = new Evaluation(235, "Evaluation 1", anneeScolaire, new Date(), 1f, pauline, matiereIaws, niveauMaster, 15.5f, 20f, sem2);
        Evaluation eval2Pauline = new Evaluation(236, "Evaluation 1", anneeScolaire, new Date(), 1f, pauline, matiereJee, niveauMaster, 18f, 20f, sem2);
        Evaluation eval1Jules = new Evaluation(237, "Evaluation 1", anneeScolaire, new Date(), 1f, jules, matiereIaws, niveauMaster, 11f, 20f, sem2);
        Evaluation eval2Jules = new Evaluation(238, "Evaluation 1", anneeScolaire, new Date(), 1f, jules, matiereJee, niveauMaster, 14f, 20f, sem2);

        evaluationList.add(eval1Pauline);
        evaluationList.add(eval2Pauline);
        evaluationList.add(eval1Jules);
        evaluationList.add(eval2Jules);

        return evaluationList;
    }
}
