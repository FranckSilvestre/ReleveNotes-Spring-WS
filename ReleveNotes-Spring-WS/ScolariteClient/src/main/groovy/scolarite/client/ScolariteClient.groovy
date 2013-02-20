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
    def http = new HTTPBuilder("http://scolarite.ticetime.cloudbees.net")
    http.request(Method.GET, JSON) {
      uri.path = '/api/v1/etudiants'
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
