class UrlMappings {

  static mappings = {
    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }

    "/api/v1/etudiants"(controller: "etudiantApi", parseRequest: true) {
      action = [GET: "list", POST: "createAndInsert"]
    }

    "/api/v1/etudiants/$id"(controller: "etudiantApi", parseRequest: true) {
      action = [GET: "show"]
    }

    "/api/v1/evaluations"(controller: "evaluationApi", parseRequest: true) {
      action = [GET: "list", POST: "createAndInsert"]
    }

    "/api/v1/evaluations/$id"(controller: "evaluationApi", parseRequest: true) {
      action = [GET: "show"]
    }

    "/"(view: "/index")
    "500"(view: '/error')
  }
}
