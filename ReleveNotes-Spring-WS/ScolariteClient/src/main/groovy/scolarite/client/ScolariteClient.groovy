package scolarite.client

import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON

/**
 *
 * @author franck Silvestre
 */
class ScolariteClient {

  def displayAllEtudiants() {
    def status = "success"
    def http = new HTTPBuilder("http://localhost:8080")
    http.request(Method.GET, JSON) {
      uri.path = '/Scolarite/api/v1/etudiants.json'
      response.success = { resp, json ->
          println json
      }
      // handler for any failure status code:
      response.failure = { resp ->
          println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
        status = "failure"
      }
    }
    status
  }
}
