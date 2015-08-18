class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        /*
		"/participant/$id?"(controller: "participant", parseRequest: true) {
			action = [GET: "index", PUT: "update", PATCH: "update", DELETE: "delete", POST: "save"]
		}
		*/
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
