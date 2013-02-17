package iaws.relevenotes.ws.contractfirst;

import iaws.relevenotes.domain.Evaluation;
import iaws.relevenotes.domain.nomenclature.AnneeScolaire;
import iaws.relevenotes.domain.nomenclature.Niveau;
import iaws.relevenotes.domain.nomenclature.Semestre;
import iaws.relevenotes.services.ReleveNoteService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;
import org.w3c.dom.Element;


import java.util.List;

/**
 * @author franck Silvestre
 */

public class ReleveNotesEndpoint {
    private ReleveNoteService releveNotesService;

    private static final String NAMESPACE_URI = "http://iaws/ws/contractfirst/exemple";

    public ReleveNotesEndpoint(ReleveNoteService releveNotesService) {
        this.releveNotesService = releveNotesService;
    }


    public Element handleReleveNotesRequest(String anneeScol,  String niveauCode, Integer semestreId) throws Exception {

        // parse le XML de ReleveNotesRequest pour extraire les informations de
        // l'année scolaire, du niveau et du semestre  et creer les objets ad-hoc
        AnneeScolaire anneeScolaire = new AnneeScolaire(anneeScol);
        Niveau niveau = new Niveau(niveauCode);
        Semestre semestre = new Semestre(semestreId);


        // invoque le service "releveNoteService" pour récupérer les objets recherchés
        //
        List<Evaluation> evals = releveNotesService.findAllEvaluationsForAnneeScolaireNiveauAndSemestre(anneeScolaire, niveau, semestre);

        // Transforme en élément XML ad-hoc pour le retour
        // Ici, on prend le parti de renvoyer un fichier XML statique. Il faudrait traiter la
        // liste des évaluations avec une API XML pour fournir l'élément réponse de manière
        // dynamique

        Element elt = XmlHelper.getRootElementFromFileInClasspath("ReleveNotes.xml") ;
        return  elt;

    }

}
