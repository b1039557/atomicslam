package placements



import org.junit.*
import grails.test.mixin.*

@TestFor(PlacementOppurtunityController)
@Mock(PlacementOppurtunity)
class PlacementOppurtunityControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/placementOppurtunity/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.placementOppurtunityInstanceList.size() == 0
        assert model.placementOppurtunityInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.placementOppurtunityInstance != null
    }

    void testSave() {
        controller.save()

        assert model.placementOppurtunityInstance != null
        assert view == '/placementOppurtunity/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/placementOppurtunity/show/1'
        assert controller.flash.message != null
        assert PlacementOppurtunity.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/placementOppurtunity/list'


        populateValidParams(params)
        def placementOppurtunity = new PlacementOppurtunity(params)

        assert placementOppurtunity.save() != null

        params.id = placementOppurtunity.id

        def model = controller.show()

        assert model.placementOppurtunityInstance == placementOppurtunity
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/placementOppurtunity/list'


        populateValidParams(params)
        def placementOppurtunity = new PlacementOppurtunity(params)

        assert placementOppurtunity.save() != null

        params.id = placementOppurtunity.id

        def model = controller.edit()

        assert model.placementOppurtunityInstance == placementOppurtunity
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/placementOppurtunity/list'

        response.reset()


        populateValidParams(params)
        def placementOppurtunity = new PlacementOppurtunity(params)

        assert placementOppurtunity.save() != null

        // test invalid parameters in update
        params.id = placementOppurtunity.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/placementOppurtunity/edit"
        assert model.placementOppurtunityInstance != null

        placementOppurtunity.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/placementOppurtunity/show/$placementOppurtunity.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        placementOppurtunity.clearErrors()

        populateValidParams(params)
        params.id = placementOppurtunity.id
        params.version = -1
        controller.update()

        assert view == "/placementOppurtunity/edit"
        assert model.placementOppurtunityInstance != null
        assert model.placementOppurtunityInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/placementOppurtunity/list'

        response.reset()

        populateValidParams(params)
        def placementOppurtunity = new PlacementOppurtunity(params)

        assert placementOppurtunity.save() != null
        assert PlacementOppurtunity.count() == 1

        params.id = placementOppurtunity.id

        controller.delete()

        assert PlacementOppurtunity.count() == 0
        assert PlacementOppurtunity.get(placementOppurtunity.id) == null
        assert response.redirectedUrl == '/placementOppurtunity/list'
    }
}
