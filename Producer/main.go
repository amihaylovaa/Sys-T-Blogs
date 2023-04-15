package main

import (
	"net/http"

	"github.com/go-chi/chi"
	"github.com/go-chi/chi/middleware"
)

func main() {
	router := chi.NewRouter()

	router.Use(middleware.Logger)
	router.Post("/blog", saveBlog)
	router.Post("/comment", saveComment)

	http.ListenAndServe(":5500", router)
}
