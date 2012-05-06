package placements

import org.springframework.dao.DataIntegrityViolationException

class PlacementOppurtunityController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [placementOppurtunityInstanceList: PlacementOppurtunity.list(params), placementOppurtunityInstanceTotal: PlacementOppurtunity.count()]
    }

    def create() {
        [placementOppurtunityInstance: new PlacementOppurtunity(params)]
    }

    def save() {
        def placementOppurtunityInstance = new PlacementOppurtunity(params)
        if (!placementOppurtunityInstance.save(flush: true)) {
            render(view: "create", model: [placementOppurtunityInstance: placementOppurtunityInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), placementOppurtunityInstance.id])
        redirect(action: "show", id: placementOppurtunityInstance.id)
    }

    def show() {
        def placementOppurtunityInstance = PlacementOppurtunity.get(params.id)
        if (!placementOppurtunityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), params.id])
            redirect(action: "list")
            return
        }

        [placementOppurtunityInstance: placementOppurtunityInstance]
    }

    def edit() {
        def placementOppurtunityInstance = PlacementOppurtunity.get(params.id)
        if (!placementOppurtunityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), params.id])
            redirect(action: "list")
            return
        }

        [placementOppurtunityInstance: placementOppurtunityInstance]
    }

    def update() {
        def placementOppurtunityInstance = PlacementOppurtunity.get(params.id)
        if (!placementOppurtunityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (placementOppurtunityInstance.version > version) {
                placementOppurtunityInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity')] as Object[],
                          "Another user has updated this PlacementOppurtunity while you were editing")
                render(view: "edit", model: [placementOppurtunityInstance: placementOppurtunityInstance])
                return
            }
        }

        placementOppurtunityInstance.properties = params

        if (!placementOppurtunityInstance.save(flush: true)) {
            render(view: "edit", model: [placementOppurtunityInstance: placementOppurtunityInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), placementOppurtunityInstance.id])
        redirect(action: "show", id: placementOppurtunityInstance.id)
    }

    def delete() {
        def placementOppurtunityInstance = PlacementOppurtunity.get(params.id)
        if (!placementOppurtunityInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), params.id])
            redirect(action: "list")
            return
        }

        try {
            placementOppurtunityInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'placementOppurtunity.label', default: 'PlacementOppurtunity'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
