package main

import (
	"net/http"

	"github.com/go-chi/chi"
)

func main() {
	r := chi.NewRouter()

	r.Route("/api/v1", func(r chi.Router) {

		r.Post("/blog", saveBlog)
		r.Post("/comment", saveComment)

	})

	http.ListenAndServe(":5500", r)
}
