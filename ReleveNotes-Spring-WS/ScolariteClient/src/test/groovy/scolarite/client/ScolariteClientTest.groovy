package scolarite.client



/**
 *
 * @author franck Silvestre
 */
class ScolariteClientTest extends GroovyTestCase {


  void testDisplayAllEtudiants() {
    ScolariteClient scolariteClient = new ScolariteClient()
    def status = scolariteClient.displayAllEtudiants()
    assertEquals("success",status)
  }

}
