package scolarite



import org.junit.*
import grails.test.mixin.*

@TestFor(EvaluationController)
@Mock(Evaluation)
class EvaluationControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/evaluation/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.evaluationInstanceList.size() == 0
        assert model.evaluationInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.evaluationInstance != null
    }

    void testSave() {
        controller.save()

        assert model.evaluationInstance != null
        assert view == '/evaluation/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/evaluation/show/1'
        assert controller.flash.message != null
        assert Evaluation.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/evaluation/list'

        populateValidParams(params)
        def evaluation = new Evaluation(params)

        assert evaluation.save() != null

        params.id = evaluation.id

        def model = controller.show()

        assert model.evaluationInstance == evaluation
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/evaluation/list'

        populateValidParams(params)
        def evaluation = new Evaluation(params)

        assert evaluation.save() != null

        params.id = evaluation.id

        def model = controller.edit()

        assert model.evaluationInstance == evaluation
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/evaluation/list'

        response.reset()

        populateValidParams(params)
        def evaluation = new Evaluation(params)

        assert evaluation.save() != null

        // test invalid parameters in update
        params.id = evaluation.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/evaluation/edit"
        assert model.evaluationInstance != null

        evaluation.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/evaluation/show/$evaluation.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        evaluation.clearErrors()

        populateValidParams(params)
        params.id = evaluation.id
        params.version = -1
        controller.update()

        assert view == "/evaluation/edit"
        assert model.evaluationInstance != null
        assert model.evaluationInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/evaluation/list'

        response.reset()

        populateValidParams(params)
        def evaluation = new Evaluation(params)

        assert evaluation.save() != null
        assert Evaluation.count() == 1

        params.id = evaluation.id

        controller.delete()

        assert Evaluation.count() == 0
        assert Evaluation.get(evaluation.id) == null
        assert response.redirectedUrl == '/evaluation/list'
    }
}
