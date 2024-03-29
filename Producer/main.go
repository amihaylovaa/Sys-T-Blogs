package main

import (
	"log"
	"net/http"
	"time"

	"github.com/Shopify/sarama"
	"github.com/go-chi/chi"
)

func main() {
	producer, err := createKafkaProducer(5, 30*time.Second, createNewProducer)

	if err != nil {
		log.Fatalln(err)
	}
	log.Println("Producer connection successfully established")

	r := chi.NewRouter()

	r.Route("/api/v1", func(r chi.Router) {
		r.Post("/blog", handleRequest(saveBlog, producer))
		r.Post("/comment", handleRequest(saveComment, producer))

	})
	http.ListenAndServe(":5500", r)
}

func handleRequest(handle Handler, producer sarama.SyncProducer) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		statusCode, responseBody := handle(r, producer)

		w.Header().Set("Content-Type", "application/json; charset=utf-8")
		w.WriteHeader(statusCode)

		if statusCode != http.StatusOK {
			http.Error(w, responseBody, statusCode)
			return
		}
	}
}

type Handler func(r *http.Request, producer sarama.SyncProducer) (statusCode int, responseBody string)
