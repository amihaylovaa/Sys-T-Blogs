package main

import (
	"net/http"
)

type Comment struct {
	content        string
	attachmentsUrl []string
}

func saveComment(w http.ResponseWriter, r *http.Request) {

}
