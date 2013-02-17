package iaws.relevenotes.services;

import iaws.relevenotes.domain.Evaluation;
import iaws.relevenotes.domain.nomenclature.AnneeScolaire;
import iaws.relevenotes.domain.nomenclature.Niveau;
import iaws.relevenotes.domain.nomenclature.Semestre;

import java.util.List;

/**
 * @author franck Silvestre
 */
public interface ReleveNoteService {

    /**
     * Retourne tous les évaluation correspondant à une année scolaire, un niveau
     * et un semestre
     * @param anneeScolaire  l'année scolaire
     * @param niveau  le niveau
     * @param semestre le semestre
     * @return les évaluations correspondant aux critères fournis
     */
    public List<Evaluation> findAllEvaluationsForAnneeScolaireNiveauAndSemestre(
            AnneeScolaire anneeScolaire,
            Niveau niveau,
            Semestre semestre
    );
}
