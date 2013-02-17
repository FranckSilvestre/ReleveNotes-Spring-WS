package iwas.relevenotes.ws.contractfirst;

import iaws.relevenotes.domain.Evaluation;
import iaws.relevenotes.services.ReleveNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.w3c.dom.Element;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author franck Silvestre
 */
@Endpoint
public class ReleveNotesEndpoint {
    private ReleveNoteService releveNoteService;

    private static final String NAMESPACE_URI = "http://iaws/ws/contractfirst/exemple";

    @Autowired
    public ReleveNotesEndpoint(ReleveNoteService releveNoteService) {
        this.releveNoteService = releveNoteService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReleveNotesRequest")
      public void handleReleveNotesRequest(@RequestPayload Element ReleveNotesRequest)
          throws Exception {

        // parse le XML de ReleveNotesRequest pour extraire les informations de
        // l'année scolaire, du niveau et du semestre

        // invoque le service "releveNoteService" pour récupérer les objets recherchés
        //
        //List<Evaluation> evals = releveNoteService.findAllEvaluationsForAnneeScolaireNiveauAndSemestre();

        // Transforme en élément XML ad-hoc pour le retour
        //

      }

}
