Une fois l'archive dézippée et importée en tant que projet Maven, l'execution du test signale un probleme avec le endpoint :

ATTENTION: No endpoint mapping found for [SaajSoapMessage {http://iaws/ws/contractfirst/exemple}ReleveNotesRequest]
13 mars 2013 22:56:48 org.springframework.ws.test.server.MockWebServiceClient sendRequest
GRAVE: Could not send request
org.springframework.ws.NoEndpointFoundException: No endpoint can be found for request [SaajSoapMessage {http://iaws/ws/contractfirst/exemple}ReleveNotesRequest]

Le endpoint, c'est le fournisseur du web service. Outre le pointeur sur le sujet de TP pour l'ecriture de web service selon une approche contract first, vous pouvez trouver aussi de la doc à cette adresse : http://static.springsource.org/spring-ws/sites/2.0/reference/html/index.html

Comme pour l'exemple du tutoriel, on retrouve dans le module "ReleveNotes-Spring-WS" un repertoire src/main qui contient la description de la webapp avec le descripteur classique web.xml dans le repertoire WEB-INF. Celui-ci est complété par un descripteur specifique "spring-ws-serlet.xml" dans lequel on trouve quelle est la classe qui implante le endpoint.
Pour solutionner le probleme, il faut donc implanter le endpoint. Pour cela on rajoute comme cela est indiqué dans le tuto ou dans les docs de reference comme celui-ci (http://static.springsource.org/spring-ws/sites/2.0/reference/html/server.html#server-atEndpoint-methods) les annotations suivantes à la classe précédemment citée :

 - La premiere annotation @Endpoint marque la classe comme candidate à une implantation.
 - L'annotation @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReleveNotesRequest") precise à quel message XML la méthode pourra répondre.
 - Le contenu de la réponse est tagguée par l'annotation @ResponsePayload
 - Enfin, l'utilisation de 3 balises @XPathParam permet d'extraire facilement le contenu du message XML à partir de l'expression XPath passée en paramètre.
 
 On peut également consulter cette javadoc (http://static.springsource.org/spring-ws/sites/2.0/apidocs/index.html?org/springframework/ws/server/endpoint/annotation) pour plus de details sur les annotations utilisées.
 
 Ainsi modifiée, la classe ReleveNotesEndpoint est analysée comme une classe qui implante un endpoint permettant de répondre aux requetes de releves de notes.
 