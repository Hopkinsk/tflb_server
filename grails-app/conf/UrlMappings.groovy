class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        
		"/day/$id?"(controller: "day", parseRequest: true) {
			action = [GET: "index", PUT: "update", PATCH: "update", DELETE: "delete", POST: "save"]
		}

        "/study/export" (controller: "study", action: "export", parseRequest: true)

        "/study/list" (controller: "study", action: "list", parseRequest: true)

        "/study/$id?"(controller: "study", parseRequest: true) {
            action = [GET: "index", PUT: "update", PATCH: "update", DELETE: "delete", POST: "save"]
        }	
        "/study/$id/safety"(controller: "study", action:'safetyTriggered')
        "/event/$id?"(controller: "event", parseRequest: true) {
            action = [GET: "index", PUT: "update", PATCH: "update", DELETE: "delete", POST: "save"]
        }   

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
