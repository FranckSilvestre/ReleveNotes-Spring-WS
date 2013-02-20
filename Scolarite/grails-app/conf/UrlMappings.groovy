class UrlMappings {

  static mappings = {
    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }

    "/api/v1/etudiants"(controller: "etudiant", parseRequest: true) {
      action = [GET: "list"]
    }
    "/api/v1/evaluations"(controller: "evaluation", parseRequest: true) {
      action = [GET: "list"]
    }
    "/api/v1/etudiants/$id"(resource: "etudiant")
    "/api/v1/evaluations/$id"(resource: "evaluation")

    "/"(view: "/index")
    "500"(view: '/error')
  }
}
