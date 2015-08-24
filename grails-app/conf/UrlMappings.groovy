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

        "/study/$id?"(controller: "study", parseRequest: true) {
            action = [GET: "index", PUT: "update", PATCH: "update", DELETE: "delete", POST: "save"]
        }	
        	
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
