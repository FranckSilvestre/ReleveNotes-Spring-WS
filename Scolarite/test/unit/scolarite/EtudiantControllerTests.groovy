package scolarite



import org.junit.*
import grails.test.mixin.*

@TestFor(EtudiantController)
@Mock(Etudiant)
class EtudiantControllerTests {

  def populateValidParams(params) {
    assert params != null
    // TODO: Populate valid properties like...
    //params["name"] = 'someValidName'
  }

  void testIndex() {
    controller.index()
    assert "/etudiant/list" == response.redirectedUrl
  }

  void testList() {

    def model = controller.list()

    assert model.etudiantInstanceList.size() == 0
    assert model.etudiantInstanceTotal == 0
  }

  void testCreate() {
    def model = controller.create()

    assert model.etudiantInstance != null
  }

  void testSave() {
    controller.save()

    assert model.etudiantInstance != null
    assert view == '/etudiant/create'

    response.reset()

    populateValidParams(params)
    controller.save()

    assert response.redirectedUrl == '/etudiant/show/1'
    assert controller.flash.message != null
    assert Etudiant.count() == 1
  }

  void testShow() {
    controller.show()

    assert flash.message != null
    assert response.redirectedUrl == '/etudiant/list'

    populateValidParams(params)
    def etudiant = new Etudiant(params)

    assert etudiant.save() != null

    params.id = etudiant.id

    def model = controller.show()

    assert model.etudiantInstance == etudiant
  }

  void testEdit() {
    controller.edit()

    assert flash.message != null
    assert response.redirectedUrl == '/etudiant/list'

    populateValidParams(params)
    def etudiant = new Etudiant(params)

    assert etudiant.save() != null

    params.id = etudiant.id

    def model = controller.edit()

    assert model.etudiantInstance == etudiant
  }

  void testUpdate() {
    controller.update()

    assert flash.message != null
    assert response.redirectedUrl == '/etudiant/list'

    response.reset()

    populateValidParams(params)
    def etudiant = new Etudiant(params)

    assert etudiant.save() != null

    // test invalid parameters in update
    params.id = etudiant.id
    //TODO: add invalid values to params object

    controller.update()

    assert view == "/etudiant/edit"
    assert model.etudiantInstance != null

    etudiant.clearErrors()

    populateValidParams(params)
    controller.update()

    assert response.redirectedUrl == "/etudiant/show/$etudiant.id"
    assert flash.message != null

    //test outdated version number
    response.reset()
    etudiant.clearErrors()

    populateValidParams(params)
    params.id = etudiant.id
    params.version = -1
    controller.update()

    assert view == "/etudiant/edit"
    assert model.etudiantInstance != null
    assert model.etudiantInstance.errors.getFieldError('version')
    assert flash.message != null
  }

  void testDelete() {
    controller.delete()
    assert flash.message != null
    assert response.redirectedUrl == '/etudiant/list'

    response.reset()

    populateValidParams(params)
    def etudiant = new Etudiant(params)

    assert etudiant.save() != null
    assert Etudiant.count() == 1

    params.id = etudiant.id

    controller.delete()

    assert Etudiant.count() == 0
    assert Etudiant.get(etudiant.id) == null
    assert response.redirectedUrl == '/etudiant/list'
  }
}
