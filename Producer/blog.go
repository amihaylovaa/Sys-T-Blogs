package main

import (
	"net/http"
)

type Blog struct {
	id             uint
	title          string
	subtitle       string
	content        string
	attachmentsUrl []string
	comments       []Comment
}

func saveBlog(w http.ResponseWriter, r *http.Request) {

}
