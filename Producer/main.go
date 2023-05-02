package main

import (
	"net/http"

	"github.com/go-chi/chi"
)

func main() {
	r := chi.NewRouter()

	r.Route("/api/v1", func(r chi.Router) {
		r.Post("/blog", handleRequest(saveBlog))
		r.Post("/comment", handleRequest(saveComment))

	})
	http.ListenAndServe(":5500", r)
}

func handleRequest(handle Handler) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		statusCode, responseBody := handle(r)

		w.Header().Set("Content-Type", "application/json; charset=utf-8")
		w.WriteHeader(statusCode)

		if statusCode != http.StatusOK {
			http.Error(w, responseBody, statusCode)
			return
		}
	}
}

type Handler func(r *http.Request) (statusCode int, responseBody string)
